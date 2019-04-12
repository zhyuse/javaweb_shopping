package Dao.Impl;

import Dao.Dao;
import Entity.Order;
import Dao.OrderDao;

import java.util.List;

public class OrderDaoImpl extends Dao<Order> implements OrderDao {

    @Override
    public List<Order> queryall(String userid,int status) {
        String sql="select * from javaweb.order where userid=? and status=?";
        return getForList(sql,userid,status);
    }

    @Override
    public List<Order> queryall(int status) {
        String sql="select * from javaweb.order where status=?";
        return getForList(sql,status);
    }

    @Override
    public List<Order> queryall(String userid) {
        String sql="select * from javaweb.order where userid=?";
        return getForList(sql,userid);
    }

    @Override
    public List<Order> queryall() {
        String sql="select * from javaweb.order ";
        return getForList(sql);
    }

    @Override
    public List<Order> query(int id) {
        String sql="select * from javaweb.order where id=?";
        return getForList(sql,id);
    }

    /**
    @Override
    public Order query(int id) {
        String sql="select * from javaweb.order where id=?";
        return get(sql,id);
    }
     */

    @Override
    public double queryprice(int id) {
        String sql="select * from javaweb.order where id=?";
        List<Order> orderList=getForList(sql,id);
        double sum=0;
        if(orderList==null||orderList.size()==0){
            return 0;
        }
        for(int i=0;i<orderList.size();i++){
            sum+=orderList.get(i).getPrice();
        }
        return sum;
    }

    @Override
    public void update(Order order, int status) {
        String sql="update javaweb.order set status=? where id=? and userid=?";
        update(sql,status,order.getId(),order.getUserid());
    }

    @Override
    public void insert(Order order) {
        String sql="insert into javaweb.order values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        update(sql,order.getId(),order.getTime(),order.getUserid(),order.getProductid(),
                order.getProductname(),order.getNum(),order.getDanjia(),order.getPrice(),
                order.getImage(),order.getAddress(),order.getReceiver(),order.getStatus(),order.getPhone());
    }

    @Override
    public int getId() {
        String sql="SELECT * FROM javaweb.order order by id desc";
        if(getForList(sql).size()==0||getForList(sql)==null)
            return 0;
        else {
            return getForList(sql).get(0).getId();
        }
    }
}
