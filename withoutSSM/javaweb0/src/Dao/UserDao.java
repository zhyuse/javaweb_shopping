package Dao;

import Entity.User;

public interface UserDao {
    //注册增加
    public void insert(User user);

    //通过id查找User
    public User query(String userid);

    //修改
    public void update(User user);

    //判断登录
    public User query(String userid,String password);
}
