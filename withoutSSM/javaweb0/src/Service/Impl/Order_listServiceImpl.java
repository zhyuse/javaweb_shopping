package Service.Impl;

import Dao.Impl.Order_listDaoImpl;
import Dao.Order_listDao;
import Entity.Order_list;
import Service.Order_listService;

import java.util.List;

public class Order_listServiceImpl implements Order_listService {
    @Override
    public List<Order_list> getall() {
        Order_listDao order_listDao=new Order_listDaoImpl();
        List<Order_list> order_listList=order_listDao.queryall();
        if(order_listList.size()==0){
            return order_listList;
        }
        else {
            for (int i=0;i<order_listList.size();i++){
                String productname=order_listList.get(i).getProductname();
                int num=order_listList.get(i).getNum();
                if(order_listList.get(i).getNum()>1){
                    order_listList.get(i).setProductname(productname+"等(共计"+num+"种商品)");
                }
            }
            return order_listList;
        }
    }

    @Override
    public List<Order_list> getall(String userid) {
        Order_listDao order_listDao=new Order_listDaoImpl();
        List<Order_list> order_listList=order_listDao.queryall(userid);
        if(order_listList.size()==0){
            return order_listList;
        }
        else {
            for (int i=0;i<order_listList.size();i++){
                String productname=order_listList.get(i).getProductname();
                int num=order_listList.get(i).getNum();
                if(order_listList.get(i).getNum()>1){
                    order_listList.get(i).setProductname(productname+"等(共计"+num+"种商品)");
                }
            }
            return order_listList;
        }
    }

    @Override
    public List<Order_list> getall_pay() {
        Order_listDao order_listDao=new Order_listDaoImpl();
        List<Order_list> order_listList=order_listDao.queryall(1);
        if(order_listList.size()==0){
            return order_listList;
        }
        else {
            for (int i=0;i<order_listList.size();i++){
                String productname=order_listList.get(i).getProductname();
                int num=order_listList.get(i).getNum();
                if(order_listList.get(i).getNum()>1){
                    order_listList.get(i).setProductname(productname+"等(共计"+num+"种商品)");
                }
            }
            return order_listList;
        }
    }

    @Override
    public List<Order_list> getall_pay(String userid) {
        Order_listDao order_listDao=new Order_listDaoImpl();
        List<Order_list> order_listList=order_listDao.queryall(userid,1);
        if(order_listList.size()==0){
            return order_listList;
        }
        else {
            for (int i=0;i<order_listList.size();i++){
                String productname=order_listList.get(i).getProductname();
                int num=order_listList.get(i).getNum();
                if(order_listList.get(i).getNum()>1){
                    order_listList.get(i).setProductname(productname+"等(共计"+num+"种商品)");
                }
            }
            return order_listList;
        }
    }

    @Override
    public List<Order_list> getall_deliver() {
        Order_listDao order_listDao=new Order_listDaoImpl();
        List<Order_list> order_listList=order_listDao.queryall(2);
        if(order_listList.size()==0){
            return order_listList;
        }
        else {
            for (int i=0;i<order_listList.size();i++){
                String productname=order_listList.get(i).getProductname();
                int num=order_listList.get(i).getNum();
                if(order_listList.get(i).getNum()>1){
                    order_listList.get(i).setProductname(productname+"等(共计"+num+"种商品)");
                }
            }
            return order_listList;
        }
    }

    @Override
    public List<Order_list> getall_deliver(String userid) {
        Order_listDao order_listDao=new Order_listDaoImpl();
        List<Order_list> order_listList=order_listDao.queryall(userid,2);
        if(order_listList.size()==0){
            return order_listList;
        }
        else {
            for (int i=0;i<order_listList.size();i++){
                String productname=order_listList.get(i).getProductname();
                int num=order_listList.get(i).getNum();
                if(order_listList.get(i).getNum()>1){
                    order_listList.get(i).setProductname(productname+"等(共计"+num+"种商品)");
                }
            }
            return order_listList;
        }
    }

    @Override
    public List<Order_list> getall_receiver() {
        Order_listDao order_listDao=new Order_listDaoImpl();
        List<Order_list> order_listList=order_listDao.queryall(3);
        if(order_listList.size()==0){
            return order_listList;
        }
        else {
            for (int i=0;i<order_listList.size();i++){
                String productname=order_listList.get(i).getProductname();
                int num=order_listList.get(i).getNum();
                if(order_listList.get(i).getNum()>1){
                    order_listList.get(i).setProductname(productname+"等(共计"+num+"种商品)");
                }
            }
            return order_listList;
        }
    }

    @Override
    public List<Order_list> getall_receiver(String userid) {
        Order_listDao order_listDao=new Order_listDaoImpl();
        List<Order_list> order_listList=order_listDao.queryall(userid,3);
        if(order_listList.size()==0){
            return order_listList;
        }
        else {
            for (int i=0;i<order_listList.size();i++){
                String productname=order_listList.get(i).getProductname();
                int num=order_listList.get(i).getNum();
                if(order_listList.get(i).getNum()>1){
                    order_listList.get(i).setProductname(productname+"等(共计"+num+"种商品)");
                }
            }
            return order_listList;
        }
    }
}
