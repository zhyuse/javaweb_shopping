package Service.Impl;

import Dao.*;
import Dao.Impl.UserDaoImpl;
import Entity.User;
import Service.AccountService;

public class AccountServiceImpl implements AccountService {
    @Override
    public Boolean register(User user) {
        UserDao userDao=new UserDaoImpl();
        if(userDao.query(user.getUserid())!=null){
            return false;
        }
        else {
            userDao.insert(user);
            return true;
        }
    }

    @Override
    public String login(String id, String password) {
        UserDao userDao=new UserDaoImpl();
        if(userDao.query(id)!=null){
            if (userDao.query(id,password)!=null){
                return "登录成功！";
            }
            else {
                return "密码错误！";
            }
        }
        else {
            return "该用户不存在";
        }
    }

    @Override
    public User getUser(String id) {
        UserDao userDao=new UserDaoImpl();
        return userDao.query(id);
    }

    @Override
    public void update(User user) {
        UserDao userDao=new UserDaoImpl();
        userDao.update(user);
    }

    @Override
    public boolean yanzheng(String userid) {
        UserDao userDao=new UserDaoImpl();
        if(userDao.query(userid)!=null){
            return true;
        }
        else {
            return false;
        }
    }
}
