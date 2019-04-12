package Dao;

import Entity.Address;

import java.util.List;

public interface AddressDao {
    //查询
    public List<Address> query(String userid);//全部
    public Address query(String userid,String address);//单个
    //增加
    public void insert(Address address);
    //修改
    public void update(Address address);
    //删除
    public void delete(Address address);
}
