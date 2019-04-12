package Service.Impl;

import Dao.CartDao;
import Dao.Impl.CartDaoImpl;
import Dao.Impl.OrderDaoImpl;
import Dao.Impl.ProductDaoImpl;
import Dao.OrderDao;
import Dao.ProductDao;
import Entity.Address;
import Entity.Cart;
import Entity.Order;
import Service.CartService;
import Service.OrderService;
import Service.ProductService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public int submit(String userid , Address address) {   //提交全部
        OrderDao orderDao=new OrderDaoImpl();
        CartDao cartDao=new CartDaoImpl();
        ProductDao productDao=new ProductDaoImpl();

        int id=orderDao.getId()+1;
        Date getDate = Calendar.getInstance().getTime();
        String nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getDate);

        List<Cart> cartList=null;
        cartList=cartDao.query(userid);//取出用户购物车信息
        cartDao.deleteall(userid);//清空购物车

        for(int i=0;i<cartList.size();i++){
            Order order=new Order(id,nowtime,userid,cartList.get(i).getProductid(),cartList.get(i).getProductname(),
                    cartList.get(i).getNum(),cartList.get(i).getDanjia(),cartList.get(i).getPrice(),cartList.get(i).getImage(),
                    address.getAddress(),address.getReceiver(),1,address.getPhone());
            System.out.println(order);
            orderDao.insert(order);
        }
        return id;
    }

    @Override
    public double getprice(int id) {
        OrderDao orderDao=new OrderDaoImpl();
        return orderDao.queryprice(id);
    }

    @Override
    public List<Order> getorders(int id) {
        OrderDao orderDao=new OrderDaoImpl();
        return orderDao.query(id);
    }

    @Override
    public List<Order> getall() {
        OrderDao orderDao=new OrderDaoImpl();
        return orderDao.queryall();
    }

    @Override
    public List<Order> getall(String userid) {
        OrderDao orderDao=new OrderDaoImpl();
        return orderDao.queryall(userid);
    }

    @Override
    public List<Order> get_paying(String userid) {
        OrderDao orderDao=new OrderDaoImpl();
        return orderDao.queryall(userid,1);
    }

    @Override
    public List<Order> get_paying() {
        OrderDao orderDao=new OrderDaoImpl();
        return orderDao.queryall(1);
    }

    @Override
    public void pay(String userid, int id_order) {

    }


    @Override
    public List<Order> get_delivering(String userid) {
        return null;
    }

    @Override
    public List<Order> get_delivering() {
        OrderDao orderDao=new OrderDaoImpl();
        return orderDao.queryall(2);
    }

    @Override
    public void deliver(String userid, int id_order) {

    }


    @Override
    public List<Order> get_receiveing(String userid) {
        return null;
    }

    @Override
    public List<Order> get_receiveing() {
        OrderDao orderDao=new OrderDaoImpl();
        return orderDao.queryall(3);
    }

    @Override
    public void receive(String userid, int id_order) {

    }

    @Override
    public List<Order> get_commenting(String userid) {
        return null;
    }

    @Override
    public void comment(String userid, int id_order) {

    }


}
