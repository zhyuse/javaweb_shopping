package Dao;

import Entity.Order_list;

import java.util.List;

public interface Order_listDao {
    //order汇总管理员
    public List<Order_list> queryall();//查询全部汇总
    public List<Order_list> queryall(int status);//对应状态汇总

    //order汇总用户
    public List<Order_list> queryall(String userid);
    public List<Order_list> queryall(String userid,int status);

    //删除
    public void delete(int id);
}
