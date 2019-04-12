package shop.servlet;

import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;

public class myinfo extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        // 相关设置
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);

        //调用接口

        //返回
        response.sendRedirect("myinfo.jsp");
    }
}
