package Dao.Impl;

import Dao.CartDao;
import Dao.Dao;
import Entity.Cart;

import java.util.List;

public class CartDaoImpl extends Dao<Cart> implements CartDao {
    @Override
    public Cart query(String userid, int productid) {
        String sql="select * from cart where userid=? and productid=?";
        return get(sql,userid,productid);
    }

    @Override
    public List<Cart> query(String userid) {
        String sql="select * from cart where userid=?";
        return getForList(sql,userid);
    }

    @Override
    public double calute(String userid) {
        String sql="select * from cart where userid=?";
        List<Cart> cartList=getForList(sql,userid);
        double sum=0;
        if(cartList==null||cartList.size()==0){
            return 0;
        }
        for(int i=0;i<cartList.size();i++){
            sum+=cartList.get(i).getPrice();
        }
        return sum;
    }

    @Override
    public void insert(Cart cart) {
        String sql="insert into cart values(?,?,?,?,?,?,?)";
        update(sql,cart.getUserid(),cart.getProductid(),cart.getProductname(),cart.getNum(),cart.getDanjia(),cart.getPrice(),cart.getImage());
    }

    @Override
    public void delete(Cart cart) {
        String sql="delete from cart where userid=? and productid=?";
        update(sql,cart.getUserid(),cart.getProductid());
    }

    @Override
    public void deleteall(String userid) {
        String sql="delete from cart where userid=? ";
        update(sql,userid);
    }

    @Override
    public void update(Cart cart) {
        String sql="update cart set num=?,price=? where productid=? and userid=?";
        update(sql,cart.getNum(),cart.getPrice(),cart.getProductid(),cart.getUserid());
    }
}
