package dao;

import domin.PageBean;
import domin.Product;
import domin.QueryCondition;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import utils.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

/*
 操作数据库中Product 表的类.
 */
public class ProductDao {
    QueryRunner qr = new QueryRunner(C3P0Utils.getDS());
    public List<Product> queryAllProduct() throws SQLException {


        String sql = "SELECT * FROM product";

        return  qr.query( sql,  new BeanListHandler<>(Product.class));
    }

     /*
       通过pid 删除商品信息 .
       参数: pid
       返回值类型 : int

     */
    public int delProduct(String pid) throws SQLException {
        String sql = "delete from product where pid=?";
        int update = qr.update(sql, pid);
        return update;
    }
/*@Test
public void run() throws SQLException {
    List<Product> products = queryCondition("华为", "1000", "4000", null);
    for (Product p : products) {
        System.out.println(p.toString());
    }
    }*/
    //多条件查询
    public List<Product> queryCondition(String keyWord, String min_price, String max_price, String is_hot) throws SQLException {

        StringBuilder sql = new StringBuilder("select * from product where 1=1");
        // 根据查询条件 ,进行 拼接
        //  关键字
        if (keyWord !=null &&  !"".equals(keyWord.trim())){
            // 拼接 关键字 条件
            sql.append(" AND pname LIKE '%"+keyWord+"%'");
        }

        //  最小值
        if (min_price !=null && !"".equals(min_price.trim())){
            // 拼接 关键字 条件
            sql.append(" AND shop_price > " + min_price);
        }

        //  最大值
        if (max_price !=null &&  !"".equals(max_price.trim())){
            // 拼接 关键字 条件
            sql.append(" AND shop_price < " + max_price);
        }

        //  是否热卖
        if (is_hot !=null && !"".equals(is_hot.trim())){
            // 拼接 关键字 条件
            sql.append(" AND is_hot = " + is_hot);
        }

        List<Product> query = qr.query(sql.toString(), new BeanListHandler<Product>(Product.class));
        return query;

    }

/*    @Test
public void run() throws SQLException {
        PageBean pageBean1 = new PageBean();
        List<Product> productList = pageBean1.getProductList();
        PageBean pageBean = new PageBean("12","1",48,4,productList);
        List<Product> products = pageQueryProduct(pageBean);
    for (Product p : products) {
        System.out.println(p.toString());
    }
    }*/

    //分页查询
    public List<Product>  pageQueryProduct(PageBean pageBean) throws SQLException {

        String   sql = "SELECT * FROM product LIMIT ? , ?";
        // 获取每页数量
        int everyNum = Integer.parseInt(pageBean.getEveryNum());

        // 计算 limit 的第一个参数
        int a  = (Integer.parseInt(pageBean.getCurrentPage()) - 1) * everyNum;

        List<Product> query = qr.query(sql, new BeanListHandler<>(Product.class), a, everyNum);
        return  query;
    }


   /* @Test
    public void run() throws Exception {
        Object products = queryTotalCount();
        System.out.println(products);
    }*/
    public Object queryTotalCount() throws SQLException {
        String sql = "SELECT count(*) FROM product";

        Object query = qr.query(sql, new ScalarHandler());

        return  query;
    }
}
