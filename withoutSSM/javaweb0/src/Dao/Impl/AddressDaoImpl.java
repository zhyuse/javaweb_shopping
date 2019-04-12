package Dao.Impl;

import Dao.*;
import Entity.Address;

import java.util.List;

public class AddressDaoImpl extends Dao<Address> implements AddressDao {

    @Override
    public List<Address> query(String userid) {
        String sql="select * from address where userid=?";
        return getForList(sql,userid);
    }

    @Override
    public Address query(String userid, String address) {
        String sql="select * from address where userid=? and address=?";
        return get(sql,userid,address);
    }

    @Override
    public void insert(Address address) {
        String sql="insert into address values(?,?,?,?,?)";
        update(sql,address.getId(),address.getUserid(),address.getAddress(),address.getReceiver(),address.getPhone());
    }

    @Override
    public void update(Address address) {
        String sql="update address set address=?,receiver=?,phone=? where id=? and userid=?";
        update(sql,address.getAddress(),address.getReceiver(),address.getPhone(),address.getId(),address.getUserid());
    }

    @Override
    public void delete(Address address) {

    }
}
