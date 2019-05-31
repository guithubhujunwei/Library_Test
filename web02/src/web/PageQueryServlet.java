package web;

import domin.PageBean;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/page")
public class PageQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数
        String currentPage = request.getParameter("currentPage");

        //2.创建service对象
        ProductService ps = new ProductService();
        PageBean pageBean = ps.pageQueryProduct(currentPage);

        //3.保存数据
        request.setAttribute("pageBean",pageBean);

        //4.请求转发
         request.getRequestDispatcher("/product_list.jsp").forward(request,response);
    }
}
