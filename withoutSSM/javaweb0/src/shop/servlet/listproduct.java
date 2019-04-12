package shop.servlet;

import Entity.Product;
import Entity.Ad;
import Service.AccountService;
import Service.AdService;
import Service.Impl.AccountServiceImpl;
import Service.Impl.AdServiceImpl;
import Service.Impl.ProductServiceImpl;
import Service.ProductService;
import com.google.gson.Gson;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
public class listproduct extends HttpServlet {
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

        //          声明相关变量用于判断
        String userid = (String) session.getAttribute("userid");//检查是否登录
        String productid = request.getParameter("productid"); //判断是主页还是单个商品
        String fenlei = request.getParameter("fenlei");  //分类查询
        String search = request.getParameter("search");//搜索查询
        String search_info=request.getParameter("search_info");
        String quit=request.getParameter("quit");

        //          声明相关变量用于存值
        List<Product> productList =null;  //创建list对象，传值
        Product product=null;
        List<Ad> adList =null;

        //调用服务层接口
        ProductService productService = new ProductServiceImpl();
        AdService adService = new AdServiceImpl();

        //返回
        if(search_info!=null){  //ajax查询商品数据
            List<String> str=new ArrayList<String>();
            productList=productService.queryabout(search_info);
            if(productList.size()>0){
                for(int i=0;i<productList.size();i++) {
                    str.add(productList.get(i).getName());
                }
            }
            Gson gson=new Gson();
            String json=gson.toJson(str);
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(json);
            return;
        }
        if(productid==null) {
            if(search==null){
                if(quit!=null){
                    session.removeAttribute("user");
                    session.removeAttribute("userid");
                    Cookie newCookie=new Cookie("cook_userid",null);      //假如要删除名称为username的Cookie
                    newCookie.setMaxAge(0);             //立即删除型
                    response.addCookie(newCookie);     //重新写入，将覆盖之前的
                }
                productList = productService.queryrand(8);
                adList = adService.getrand(3);
                session.setAttribute("list_product", productList);
                session.setAttribute("list_ad", adList);
                response.sendRedirect("shangcheng.jsp");
                return;
            }
            else {
                productList=productService.queryabout(search);
                adList = adService.getrand(3);
                session.setAttribute("list_product", productList);
                session.setAttribute("list_ad", adList);
                response.sendRedirect("shangcheng.jsp");
                return;
            }
        }
        else {
            product=productService.query(Integer.parseInt(productid));
            request.setAttribute("product",product);
            request.getRequestDispatcher("product.jsp").forward(request,response);
            return;
        }

    }
}
