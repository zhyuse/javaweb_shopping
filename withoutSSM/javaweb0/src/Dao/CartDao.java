package Dao;

import Entity.Cart;

import java.util.List;

public interface CartDao {
    //查找cart
    public Cart query(String userid,int productid);
    //查看
    public List<Cart> query(String userid);
    public double calute(String userid);
    //增加
    public void insert(Cart cart);
    //删除
    public void delete(Cart cart);
    public void deleteall(String userid);
    //修改
    public void update(Cart cart);
}
