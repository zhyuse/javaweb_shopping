package Service.Impl;

import Dao.Impl.ProductDaoImpl;
import Dao.ProductDao;
import Entity.Product;
import Service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public Product query(int id) {
        ProductDao productDao=new ProductDaoImpl();
        return productDao.query(id);
    }

    @Override
    public List<Product> query(String fenlei) {
        ProductDao productDao=new ProductDaoImpl();
        return productDao.query(fenlei);
    }

    @Override
    public List<Product> queryrand(int num) {
        ProductDao productDao=new ProductDaoImpl();
        return productDao.queryrand(num);
    }

    @Override
    public void update(Product product) {
        ProductDao productDao=new ProductDaoImpl();
}

    @Override
    public List<Product> queryabout(String keyword) {
        ProductDao productDao=new ProductDaoImpl();
        return productDao.queryabout(keyword);
    }
}
