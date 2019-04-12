package Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.*;

/**
 * 工具类，c3p0链接mysql数据库，提供quert查询功能和caozuo操作数据库功能
 */
public class JdbcUtils {

    //强调:数据源只有一份就好了,初始化 放在静态代码块中，后面的泛型T只能为静态方法
    private static ComboPooledDataSource  dataSource = new ComboPooledDataSource();

    //经过测试如果不用调用函数的方法，而是使用构造函数，会出BUG
    public static void peizhi() {
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        //连接池相关配置，已经跟熟悉。。。
        dataSource.setJdbcUrl("jdbc:mysql://192.168.26.129:3306/javaweb?characterEncoding=UTF-8");
        dataSource.setUser("root");
        dataSource.setPassword("7885211");
        dataSource.setInitialPoolSize(3);
        dataSource.setMaxStatements(20);
        dataSource.setMinPoolSize(2);
        dataSource.setAcquireIncrement(5);
        dataSource.setMaxIdleTime(1000);
    }
    /**
     * 释放Connection连接
     */
    public static void releaseConnection(Connection connection) {

        try {
            if(connection != null){
                connection.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池连接
     */
    public static Connection getConnection() throws SQLException, PropertyVetoException {
        peizhi();
        return dataSource.getConnection();
    }

}
