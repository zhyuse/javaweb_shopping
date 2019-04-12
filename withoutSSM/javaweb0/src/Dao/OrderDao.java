package Dao;

import Entity.Order;

import java.util.List;

public interface OrderDao {
    //查询订单
    public List<Order> queryall(String userid,int status);
    public List<Order> queryall(int status);
    public List<Order> queryall(String userid);
    public List<Order> queryall();
   // public Order query(int id);
    public List<Order> query(int id);

    //查询金额
    public double queryprice(int id);
    //改变订单状态
    public void update(Order order,int status);
    //删除订单
    public  void insert(Order order);
    //查询订单数
    public int getId();
}
