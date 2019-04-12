package fangfa;

import java.sql.*;

public class connect {
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/javaweb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static String user = "root";
    public static String password = "7885211";
    public static Connection connection=null;
    public static Statement stat =null;
    public static ResultSet rs1 = null;
    public static int rs2 ;
    public static Connection getConnection(){
        try {
            //加载oracle驱动
            Class.forName(driver);
            //通过驱动获取数据库的连接
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("连接成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void caozuo(String sql) {
        Connection conn = getConnection();
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String sql){
        try {
            //通过刚才的getConnection方法获得一个连接的对象。
            connection = getConnection();
            //向数据库中发送你的sql语句
            stat = connection.createStatement();
            //获得所查询的结果，返回的是Resultset对象
            rs1 = stat.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs1;
    }

    public void close(){

        try {
            if(rs1!=null) {
                rs1.close();
            }
            if(stat!=null) {
                rs1.close();
            }
            //if(pstat!=null) {
            //    rs1.close();
            //}
            if(connection!=null) {
                rs1.close();
            }

        } catch (SQLException e) {
        }
    }

}
