package Test;

import Dao.*;
import Dao.Impl.*;
import Service.*;
import Entity.*;
import Service.Impl.*;
import Utils.JdbcUtils;
import snnu.zhyuse.mymail.MyMail;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class test  {

    public void  getname() throws PropertyVetoException, SQLException {
        JdbcUtils jdbcUtils=new JdbcUtils();
        Connection connection=jdbcUtils.getConnection();
        ResultSet result=connection.createStatement().executeQuery("select * from user where userid='41612234'");
        result.next();
        System.out.println(result.getString("username"));
        //cartDao.insert(cart);
        //System.out.println(orderList.toString());
        //System.out.println(orderList.get(0).getProductname());
    }
}
/**
 *         ComboPooledDataSource dataSource = new ComboPooledDataSource();
 *
 *         // 设置连接参数：url, 驱动，用户名，密码
 *         dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
 *         dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/javaweb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
 *         dataSource.setUser("root");
 *         dataSource.setPassword("7885211");
 *
 *         dataSource.setInitialPoolSize(3);
 *         dataSource.setMaxStatements(20);
 *         dataSource.setMinPoolSize(2);
 *         dataSource.setAcquireIncrement(5);
 *         dataSource.setMaxIdleTime(1000);
 *
 *         // 从连接池对象中，获取连接对象
 *         Connection con = dataSource.getConnection();
 *         // 执行更新
 *         ResultSet result=con.createStatement().executeQuery("select * from user where id='41612234'");
 *         result.next();
 *         System.out.println(result.getString("name"));
 *         // 关闭
 *         con.close();
 *         // 官方文档的写法
 *         DataSources.destroy(dataSource);
 */
