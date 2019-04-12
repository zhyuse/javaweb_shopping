package shop.servlet;
import Entity.*;
import Service.AddressService;
import Service.Impl.AddressServiceImpl;
import Service.Impl.OrderServiceImpl;
import Service.Impl.Order_listServiceImpl;
import Service.OrderService;
import Service.Order_listService;
import fangfa.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class order_detail extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        // 相关设置
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);

        //判断变量
        String id_str=request.getParameter("id");//订单id
        int id=0;
        String userid=(String)session.getAttribute("userid");
        String address=request.getParameter("address");
        String change=request.getParameter("change");
        String status=request.getParameter("status");//判断状态

        //存值变量
        List<Order> orderList=null;
        double total=0;

        //调用接口
        OrderService orderService=new OrderServiceImpl();
        AddressService addressService=new AddressServiceImpl();

        //类型转换
        if(id_str!=null) {
            id=Integer.parseInt(id_str);
        }
        //返回
        if(change==null){
            if(status==null){
                orderList=orderService.getorders(id);
                total=orderService.getprice(id);
                session.setAttribute("total",total);
                session.setAttribute("address",addressService.choice(userid,orderList.get(0).getAddress()));
                session.setAttribute("order",orderList);
                response.sendRedirect("order/order_detail.jsp");
                return;
            }
            else {
                switch (Integer.parseInt(status)){
                    case 1:
                        orderList=orderService.getorders(id);
                        total=orderService.getprice(id);
                        session.setAttribute("total",total);
                        session.setAttribute("address",addressService.choice(userid,orderList.get(0).getAddress()));
                        session.setAttribute("order",orderList);
                        response.sendRedirect("order/order_detail.jsp");
                        return;
                    case 2:
                        orderList=orderService.getorders(id);
                        total=orderService.getprice(id);
                        session.setAttribute("total",total);
                        session.setAttribute("address",addressService.choice(userid,orderList.get(0).getAddress()));
                        session.setAttribute("order",orderList);
                        response.sendRedirect("order/order_detail.jsp");
                        return;
                }
            }
        }
        else {
            switch (Integer.parseInt(status)){
                case 1:
                    id=orderService.submit(userid,addressService.choice(userid,address));
                    orderList=orderService.getorders(id);
                    total=orderService.getprice(id);
                    Address theaddress=addressService.choice(userid,orderList.get(0).getAddress());
                    session.setAttribute("total",total);
                    session.setAttribute("address",theaddress);
                    session.setAttribute("order", orderList);
                    response.sendRedirect("order/order_detail.jsp");
                    return;
                 default:
                     return;
            }
        }
    }
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}
