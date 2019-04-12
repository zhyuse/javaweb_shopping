package Dao;

import Entity.Product;

import java.util.List;

public interface ProductDao {
    //查找分类
    public List<Product> query(String fenlei);
    //指定查找
    public Product query(int id);
    //随机查找
    public List<Product> queryrand(int num);
    public List<Product> queryrand(int num,String fenlei);
    //模糊查找
    public List<Product> queryabout(String key);
}
