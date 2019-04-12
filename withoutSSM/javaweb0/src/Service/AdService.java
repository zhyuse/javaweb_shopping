package Service;

import Entity.Ad;

import java.util.List;

public interface AdService {
    //随机抽选广告
    public List<Ad> getrand(int num);
}
