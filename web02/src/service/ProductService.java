package service;

import dao.ProductDao;
import domin.PageBean;
import domin.Product;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/*
  商品相关的服务
 */
public class ProductService {
    ProductDao productDao = new ProductDao();

    public  List<Product>   queryAllProduct(){



        List<Product> products = null;
        try {
            products = productDao.queryAllProduct();
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  null;


    }


    //根据pid,调用delProduct()方法删除商品
    public boolean delProduct(String pid) {

        try {
            int i = productDao.delProduct(pid);
            return i==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
   /* @Test
    public void run() throws SQLException {
        List<Product> products = queryCondition("华为", "1000", "4000", null);
        for (Product p : products) {
            System.out.println(p.toString());
        }
    }*/

    //根据String keyWord, String min_price, String max_price, String is_hot，查询符合条件的商品
    public List<Product> queryCondition(String keyWord, String min_price, String max_price, String is_hot){

        try {
            List<Product> products = productDao.queryCondition(keyWord, min_price, max_price, is_hot);
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //分页查询

//       参数 :  当前页
//       返回类型 : PageBean ( 当前页, 总页 , list)
//
//       组装 PageBean对象.
  /* @Test
    public void run() {
       PageBean pageBean = pageQueryProduct("4");
       System.out.println(pageBean.getProductList());
   }*/
    public PageBean pageQueryProduct(String currentPage) {
        try {

            // 创建 PageBean 对象
            PageBean pageBean = new PageBean();

            // 保存当前页
            pageBean.setCurrentPage(currentPage);

            int totalPage = 0;

            // 保存商品总数量

            Object o = productDao.queryTotalCount();
            int count = Integer.parseInt(o.toString());
            // 计算 总页数
            totalPage = (int) Math.ceil((count / 12.0));

            pageBean.setTotalCount(count);

            // 保存总页数
            pageBean.setTotalPage(totalPage);

            // 保存 商品信息
            List<Product> products = productDao.pageQueryProduct(pageBean);
            pageBean.setProductList(products);
            return pageBean;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return null;
    }
}
