package Service.Impl;

import Dao.AdDao;
import Dao.Impl.AdDaoImpl;
import Entity.Ad;
import Service.AdService;

import java.util.List;

public class AdServiceImpl implements AdService {
    @Override
    public List<Ad> getrand(int num) {
        AdDao adDao=new AdDaoImpl();
        return adDao.queryrand(num);
    }
}
