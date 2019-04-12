package Dao;

import Entity.Ad;

import java.util.List;

public interface AdDao {
    //查看
    public Ad query(int id);
    public List<Ad> queryrand(int num);
}
