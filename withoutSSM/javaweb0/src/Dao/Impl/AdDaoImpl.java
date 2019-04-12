package Dao.Impl;

import Dao.*;
import Entity.Ad;

import java.util.List;

public class AdDaoImpl extends Dao<Ad> implements AdDao{
    @Override
    public Ad query(int id) {
        String sql="select * from ad where id=?";
        return get(sql,id);
    }

    @Override
    public List<Ad> queryrand(int num) {
        String sql="select * from ad order by rand() limit "+num+"";
        return getForList(sql);
    }
}
