package web;

import domin.Product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/allProduct")
public class AllProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // 查询 创建Service
        ProductService productService = new ProductService();

        // 调用 查询方法
        List<Product> products = productService.queryAllProduct();

        System.out.println(products);

        // 保存到页面
        request.setAttribute("products" , products);


        // 转发
        request.getRequestDispatcher("/product_list.jsp").forward(request,response);
    }
}
