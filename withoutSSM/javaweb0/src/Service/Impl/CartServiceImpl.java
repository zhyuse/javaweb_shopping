package Service.Impl;

import Dao.CartDao;
import Dao.Impl.CartDaoImpl;
import Dao.Impl.ProductDaoImpl;
import Dao.ProductDao;
import Entity.Cart;
import Entity.Product;
import Service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {
    @Override
    public Cart query(String userid, int productid) {
        CartDao cartDao=new CartDaoImpl();
        return cartDao.query(userid,productid);
    }

    @Override
    public void insert(String userid, int productid, int num) {
        ProductDao productDao=new ProductDaoImpl();
        CartDao cartDao=new CartDaoImpl();
        Product product=productDao.query(productid);
        Cart cart=cartDao.query(userid,productid);
        if(cart==null){
            cartDao.insert(new Cart(userid,productid,product.getName(),num,product.getPrice(),
                    num*product.getPrice(),product.getImage())
            );
        }
        else {
            cartDao.update(new Cart(userid,productid,product.getName(),cart.getNum()+num,product.getPrice(),
                    (num+cart.getNum())*product.getPrice(),product.getImage())
            );
        }
    }

    @Override
    public void delete(String userid) {
        CartDao cartDao=new CartDaoImpl();
        cartDao.deleteall(userid);
    }

    @Override
    public void delete(Cart cart) {
        CartDao cartDao=new CartDaoImpl();
        cartDao.delete(cart);
    }

    @Override
    public List<Cart> getCart(String userid) {
        CartDao cartDao=new CartDaoImpl();
        return cartDao.query(userid);
    }

    @Override
    public double getprice(String userid) {
        CartDao cartDao=new CartDaoImpl();
        return cartDao.calute(userid);
    }
}
