package shop.servlet;

import Entity.Address;
import Entity.Cart;
import Entity.Product;
import Service.AddressService;
import Service.CartService;
import Service.Impl.AddressServiceImpl;
import Service.Impl.CartServiceImpl;
import Service.Impl.ProductServiceImpl;
import Service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class cart extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        // 相关设置
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);

        //声明判断变量
        String userid= (String) session.getAttribute("userid");
        String id_add=request.getParameter("add_id");
        String num_add=request.getParameter("add_num");
        String id_del=request.getParameter("id_del");
        String jiesuan=request.getParameter("jiesuan");

        //声明存值变量
        List<Cart> cartList=null;
        Cart cart=null;
        double total=0;
        List<Address> addressList=null;

        //调用接口
        CartService cartService=new CartServiceImpl();
        ProductService productService=new ProductServiceImpl();
        AddressService addressService=new AddressServiceImpl();

        //返回
        if(id_add!=null){    //增加
            cartService.insert(userid,Integer.parseInt(id_add),Integer.parseInt(num_add));
            cartList=cartService.getCart(userid);
            total=cartService.getprice(userid);
            session.setAttribute("list_cart",cartList);
            session.setAttribute("total",total);
            response.sendRedirect("myinfo.jsp");
            return;
        }
        else if(id_del!=null){  //删除单个
            cart=cartService.query(userid,Integer.parseInt(id_del));
            cartService.delete(cart);
            cartList=cartService.getCart(userid);
            total=cartService.getprice(userid);
            if(cartList==null||cartList.size()==0){
                request.setAttribute("msg_cart","当前您的购物车还没有任何商品~~");
                request.getRequestDispatcher("cart.jsp").forward(request,response);
                return;
            }
            else {
                session.setAttribute("list_cart",cartList);
                session.setAttribute("total",total);
                response.sendRedirect("cart.jsp");
                return;
            }
        }
        else{               //查询
            cartList=cartService.getCart(userid);
            total=cartService.getprice(userid);
            session.setAttribute("list_cart",cartList);
            session.setAttribute("total",total);
            if(jiesuan!=null) {
                response.sendRedirect("jiesuan.jsp");
                addressList=addressService.getAddress(userid);
                System.out.println(addressList);
                session.setAttribute("list_address",addressList);
                return;
            }
            else {
                if(cartList==null||cartList.size()==0){
                    request.setAttribute("msg_cart","当前您的购物车还没有任何商品~~");
                }
                request.getRequestDispatcher("cart.jsp").forward(request,response);
                return;
            }
        }
    }
}
