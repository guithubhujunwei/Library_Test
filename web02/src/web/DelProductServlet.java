package web;

import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delProduct")
public class DelProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取需要删除的商品的pid
        String pid = request.getParameter("pid");

        //2.创建Service对象，调用delProduct()方法
        ProductService ps = new ProductService();
        boolean b = ps.delProduct(pid);

        //3.判断处理结果
        if(b){
            //刷新页面,再次查询所有
            request.getRequestDispatcher("/adminall").forward(request,response);
        }


    }
}
