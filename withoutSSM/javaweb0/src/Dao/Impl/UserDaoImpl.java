package Dao.Impl;

import Dao.Dao;
import Dao.UserDao;
import Utils.JdbcUtils;
import Entity.User;

public class UserDaoImpl extends Dao<User> implements UserDao {
    JdbcUtils jdbcUtils=new JdbcUtils();
    @Override
    public void insert(User user) {
        String sql="insert into javaweb.user values(?,?,?,?)";
        update(sql,user.getUserid(),user.getUsername(),user.getPassword(),user.getMail());
    }

    @Override
    public User query(String userid) {
        String sql="select * from user where userid=?";
        return get(sql,userid);
    }

    @Override
    public void update(User user) {
        String sql="update javaweb.user set username=?,password=?,mail=? where userid=?";
        update(sql,user.getUsername(),user.getPassword(),user.getMail(),user.getUserid());
    }

    @Override
    public User query(String userid, String password) {
        String sql="select * from user where userid=? and password=?";
        return get(sql,userid,password);
    }
}
