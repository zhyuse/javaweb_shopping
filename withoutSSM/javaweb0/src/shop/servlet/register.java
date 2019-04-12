package shop.servlet;
import Entity.User;
import Service.AccountService;
import Service.Impl.AccountServiceImpl;
import fangfa.Mail;
import fangfa.connect;
import snnu.zhyuse.mymail.MyMail;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class register extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        // 相关设置
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);

        //判断变量
        String userid = request.getParameter("userid");
        String name = request.getParameter("username");
        String pd = request.getParameter("userpd");
        String mail = request.getParameter("usermail");
        String yzm=request.getParameter("yzm");

        //调用接口
        AccountService accountService=new AccountServiceImpl();

        if(userid!=null){
            if(mail==null){
                if(accountService.yanzheng(userid)){
                    response.getWriter().write("n");
                }
                else {
                    response.getWriter().write("y");
                }
                return;
            }
            else {
                MyMail myMail=new MyMail();
                yzm=myMail.send(mail);
                session.setAttribute("yzm_register",yzm);
                request.setAttribute("step",2);
                session.setAttribute("user_register",new User(userid,name,pd,mail));
                request.getRequestDispatcher("register.jsp").forward(request,response);
                return;
            }
        }
        else if(yzm!=null){
            if(yzm.equals((String)session.getAttribute("yzm_register"))){
                User user=(User)session.getAttribute("user_register");
                accountService.register(user);
                request.setAttribute("login_msg","注册成功！");
                request.getRequestDispatcher("login.jsp").forward(request,response);
                session.invalidate();
                return;
            }
            else {
                request.setAttribute("msg","验证码错误!");
                request.setAttribute("step",2);
                request.getRequestDispatcher("register.jsp").forward(request,response);
                return;
            }
        }
        else {
             request.setAttribute("step",1);
             request.getRequestDispatcher("register.jsp").forward(request,response);
             return;
        }
        /**
         * if(yzm!=null){
         *             if(yzm.equals((String)session.getAttribute("yzm_register"))){
         *                 User user=(User)session.getAttribute("user_register");
         *                 accountService.register(user);
         *                 request.setAttribute("login_msg","注册成功！");
         *                 request.getRequestDispatcher("login.jsp").forward(request,response);
         *                 session.invalidate();
         *                 return;
         *             }
         *             else {
         *                 request.setAttribute("msg","验证码错误!");
         *                 request.setAttribute("step",2);
         *                 request.getRequestDispatcher("register.jsp").forward(request,response);
         *                 return;
         *             }
         *         }
         *         else if(userid!=null){
         *             if(accountService.yanzheng(userid)){
         *                 request.setAttribute("msg","该用户名已被注册~");
         *                 request.setAttribute("step",1);
         *                 request.getRequestDispatcher("register.jsp").forward(request,response);
         *                 return;
         *             }
         *             else {
         *                 MyMail myMail=new MyMail();
         *                 yzm=myMail.send(mail);
         *                 session.setAttribute("yzm_register",yzm);
         *                 request.setAttribute("step",2);
         *                 session.setAttribute("user_register",new User(userid,name,pd,mail));
         *                 request.getRequestDispatcher("register.jsp").forward(request,response);
         *                 return;
         *             }
         *         }
         *         else {
         *             request.setAttribute("step",1);
         *             request.getRequestDispatcher("register.jsp").forward(request,response);
         *             return;
         *         }
         */
    }
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);

    }
}