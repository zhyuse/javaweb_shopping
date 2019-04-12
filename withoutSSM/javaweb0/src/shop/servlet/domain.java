package shop.servlet;

import Entity.Order;
import Entity.Order_list;
import Service.Impl.OrderServiceImpl;
import Service.Impl.Order_listServiceImpl;
import Service.OrderService;
import Service.Order_listService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class domain extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        // 相关设置
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);

        //定义存值变量
        List<Order_list> orderList=null;

        //获取判断变量
        String find=request.getParameter("find");

        //调用接口
        Order_listService order_listService=new Order_listServiceImpl();

        if(find!=null) {
            switch (find) {
                case "all":
                    orderList = order_listService.getall();
                    if (orderList == null || orderList.size() == 0) {
                        request.setAttribute("msg_order", "当前没有任何订单~");
                    }
                    System.out.println(orderList);
                    session.setAttribute("list_order", orderList);
                    request.getRequestDispatcher("domain_order_list.jsp").forward(request, response);
                    return;
                case "deliver":
                    orderList = order_listService.getall_deliver();
                    if (orderList == null || orderList.size() == 0) {
                        request.setAttribute("msg_order", "当前没有任何待发货订单~");
                    }
                    session.setAttribute("list_order", orderList);
                    request.getRequestDispatcher("domain_order_list.jsp").forward(request, response);
                    return;
                case "pay":
                    orderList = order_listService.getall_pay();
                    if (orderList == null || orderList.size() == 0) {
                        request.setAttribute("msg_order", "当前没有任何待付款订单~");
                    }
                    session.setAttribute("list_order", orderList);
                    request.getRequestDispatcher("domain_order_list.jsp").forward(request, response);
                    return;
                case "receiver":
                    orderList = order_listService.getall_receiver();
                    if (orderList == null || orderList.size() == 0) {
                        request.setAttribute("msg_order", "当前没有任何待收货订单~");
                    }
                    session.setAttribute("list_order", orderList);
                    request.getRequestDispatcher("domain_order_list.jsp").forward(request, response);
                    return;
                default:
                    return;
            }
        }
        else {
            orderList = order_listService.getall();
            Gson gson=new Gson();
            System.out.println(gson.toJson(orderList));
            response.getWriter().write(gson.toJson(orderList));
            return;
        }
    }
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }

}