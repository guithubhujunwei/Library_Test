package web;

import domin.Product;
import org.junit.Test;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/queryCondition")
public class QueryConditionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.获取数据String keyWord, String min_price, String max_price, String is_hot
        String keyWord = request.getParameter("keyWord");
        String min_price = request.getParameter("min_price");
        String max_price = request.getParameter("max_price");
        String is_hot = request.getParameter("is_hot");
        System.out.println(keyWord);
        System.out.println(min_price);
        System.out.println(max_price);
        System.out.println(is_hot);

        //2.创建service对象，调用queryCondition方法
        ProductService ps = new ProductService();
        List<Product> products = ps.queryCondition(keyWord, min_price, max_price, is_hot);
        for (Product p : products) {
            System.out.println(p.toString());
        }


        //3.保存数据
        request.setAttribute("products",products);

        //4.请求转发到/admin/product/list.jsp
        request.getRequestDispatcher("/admin/product/list.jsp").forward(request,response);
    }
}
