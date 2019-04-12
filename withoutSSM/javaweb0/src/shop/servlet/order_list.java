package shop.servlet;

import Entity.Order_list;
import Service.Impl.Order_listServiceImpl;
import Service.Order_listService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class order_list extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        // 相关设置
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);

        //判断变量
        String status_str=request.getParameter("status");
        String userid=(String)session.getAttribute("userid");
        int status;

        //存值变量
        List<Order_list> order_listList=null;

        //调用接口
        Order_listService order_listService=new Order_listServiceImpl();

        //返回
        if(status_str==null){
            order_listList=order_listService.getall(userid);
            if(order_listList.size()==0){
                request.setAttribute("msg_order","你还没有任何订单呢~");
                request.getRequestDispatcher("order/order_list.jsp").forward(request,response);
            }
            else {
                session.setAttribute("list_order",order_listList);
                response.sendRedirect("order/order_list.jsp");
            }
            return;
        }
        else {
            status=Integer.parseInt(status_str);
        }
        switch (status){
            case 1:
                order_listList=order_listService.getall_pay(userid);
                if(order_listList.size()==0){
                    request.setAttribute("msg_order","你还没有任何待付款订单呢~");
                    request.getRequestDispatcher("order/order_list.jsp").forward(request,response);
                }
                else {
                    session.setAttribute("list_order",order_listList);
                    response.sendRedirect("order/order_list.jsp");
                }
                return;
            case 2:
                order_listList=order_listService.getall_deliver(userid);
                if(order_listList.size()==0){
                    request.setAttribute("msg_order","你还没有任何待发货订单呢~");
                    request.getRequestDispatcher("order/order_list.jsp").forward(request,response);
                }
                else {
                    session.setAttribute("list_order",order_listList);
                    response.sendRedirect("order/order_list.jsp");
                }
                return;
            default:
                request.setAttribute("msg_order","哎呀，网页出错了呢(手动滑稽)");
                request.getRequestDispatcher("order/order_list.jsp").forward(request,response);
                return;
        }
    }
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}
