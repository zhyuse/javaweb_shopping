package shop.servlet;
import Entity.User;
import Service.AccountService;
import Service.Impl.AccountServiceImpl;
import fangfa.Mail;
import snnu.zhyuse.mymail.MyMail;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class findpassword extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        // 相关设置
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);

        //设置判断变量
        String userid = request.getParameter("id");
        String yzm=request.getParameter("yzm");
        String pd = request.getParameter("pd");

        //调用接口
        AccountService accountService=new AccountServiceImpl();

        //返回
        if(userid!=null){
            if(accountService.yanzheng(userid)){
                MyMail myMail=new MyMail();
                yzm=myMail.send(accountService.getUser(userid).getMail());
                session.setAttribute("yzm",yzm);
                session.setAttribute("userid_find",userid);
                request.setAttribute("step",2);
                request.getRequestDispatcher("findpassword.jsp").forward(request,response);
                return;
            }
            else {
                request.setAttribute("msg","用户不存在");
                request.setAttribute("step",1);
                request.getRequestDispatcher("findpassword.jsp").forward(request,response);
                return;
            }
        }
        else if(yzm!=null){
           if(Integer.parseInt(yzm)==Integer.parseInt((String) session.getAttribute("yzm"))){
                request.setAttribute("step",3);
                request.getRequestDispatcher("findpassword.jsp").forward(request,response);
                return;
            }
            else {
                request.setAttribute("msg","验证码错误");
                request.setAttribute("step",2);
                request.getRequestDispatcher("findpassword.jsp").forward(request,response);
                return;
            }
        }
        else if(pd!=null){
            userid= (String) session.getAttribute("userid_find");
            User user=accountService.getUser(userid);
            user.setPassword(pd);
            accountService.update(user);
            request.setAttribute("login_msg","新密码修改成功！");
            request.getRequestDispatcher("login.jsp").forward(request,response);
            session.invalidate();
            return;
        }
        else {
            request.setAttribute("step",1);
            request.getRequestDispatcher("findpassword.jsp").forward(request,response);
            return;
        }
    }
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
       doPost(request,response);
    }
}
