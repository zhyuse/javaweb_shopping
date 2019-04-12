package Dao.Impl;

import Dao.*;
import Entity.Order_list;

import java.util.List;

public class Order_listDaoImpl extends Dao<Order_list> implements Order_listDao {
    @Override
    public List<Order_list> queryall() {
        String sql="select id,time,userid,productname,count(num) as num,sum(price) as price,address,receiver,status,phone from javaweb.order  group by id ";
        return getForList(sql);
    }

    @Override
    public List<Order_list> queryall(int status) {
        String sql="select id,time,userid,productname,count(num) as num,sum(price) as price,address,receiver,status,phone from javaweb.order where status=? group by id ";
        return getForList(sql,status);
    }

    @Override
    public List<Order_list> queryall(String userid) {
        String sql="select id,time,userid,productname,count(num) as num,sum(price) as price,address,receiver,status,phone from javaweb.order where userid=?  group by id ";
        return getForList(sql,userid);
    }

    @Override
    public List<Order_list> queryall(String userid, int status) {
        String sql="select id,time,userid,productname,count(num) as num,sum(price) as price,address,receiver,status,phone from javaweb.order where status=? and userid=? group by id  ";
        return getForList(sql,status,userid);
    }

    @Override
    public void delete(int id) {

    }
}
