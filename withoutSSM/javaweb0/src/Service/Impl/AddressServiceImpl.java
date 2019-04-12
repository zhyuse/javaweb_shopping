package Service.Impl;

import Dao.AddressDao;
import Dao.Impl.AddressDaoImpl;
import Entity.Address;
import Service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    @Override
    public List<Address> getAddress(String userid) {
        AddressDao addressDao=new AddressDaoImpl();
        return addressDao.query(userid);
    }

    @Override
    public void update(Address address) {
        AddressDao addressDao=new AddressDaoImpl();
        addressDao.update(address);
    }

    @Override
    public Address choice(String userid, String address) {
        AddressDao addressDao=new AddressDaoImpl();
        return addressDao.query(userid,address);
    }
}
