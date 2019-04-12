package Dao.Impl;

import Dao.Dao;
import Dao.ProductDao;
import Utils.JdbcUtils;
import Entity.Product;

import java.util.List;

public class ProductDaoImpl extends Dao<Product> implements ProductDao {
    JdbcUtils jdbcUtils = new JdbcUtils();

    @Override
    public List<Product> query(String fenlei) {
        String sql = "select * from javaweb.product where fenlei=?";
        return getForList(sql, fenlei);
    }

    @Override
    public Product query(int id) {
        String sql = "select * from javaweb.product where id=?";
        return get(sql, id);
    }

    @Override
    public List<Product> queryrand(int num) {
        String sql = "select * from javaweb.product order by rand() limit " + num + "";
        return getForList(sql);
    }

    @Override
    public List<Product> queryrand(int num, String fenlei) {
        String sql = "select * from javaweb.product where fenlei=? order by rand() limit " + num + "";
        return getForList(sql, fenlei);
    }

    @Override
    public List<Product> queryabout(String key) {
        String sql = "SELECT * FROM javaweb.product where name like '%" + key + "%'";
        return getForList(sql);
    }
}

