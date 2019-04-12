package shop.servlet;


import Entity.Address;
import Entity.User;
import Service.AccountService;
import Service.Impl.AccountServiceImpl;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;

public class login extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException,IOException{
        // 相关设置
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);

        // 声明判断变量
        //https://zhidao.baidu.com/question/493951478.html  getParameter和getAttribute区别
        String id=request.getParameter("id");
        String pd=request.getParameter("password");
        String productid=(String)session.getAttribute("productid");
        String mark_login;
        String autologin=request.getParameter("autologin");

        //声明存值变量
        User user=null;
        List<Address> addressList=new ArrayList<>();

        //调用接口
        AccountService accountService=new AccountServiceImpl();
        mark_login=accountService.login(id,pd);
        switch (mark_login){
            case "登录成功！":
                if(autologin!=null){
                    Cookie cookie_userid=new Cookie("cook_userid",id);
                    Cookie cookie_userpd=new Cookie("cook_userpd",pd);
                    cookie_userid.setMaxAge(60*60);//1小时
                    cookie_userpd.setMaxAge(60*60);
                    cookie_userid.setPath(request.getContextPath());
                    cookie_userpd.setPath(request.getContextPath());
                    response.addCookie(cookie_userid);
                    response.addCookie(cookie_userpd);
                }
                session.setAttribute("user",accountService.getUser(id));
                session.setAttribute("userid",id);
                response.sendRedirect("listproduct");
                return;
            default:
                request.setAttribute("login_msg",mark_login);
                request.getRequestDispatcher("login.jsp").forward(request,response);  //request不跟session一样
                return;
        }
    }
}
