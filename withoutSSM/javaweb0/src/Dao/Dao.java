package Dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import Utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


/**
 * 总结：
 * 在dbutils中，生成泛型T对象时，需要用到 T t=new T(),为此不能只够造一个构造函数
 * 当前DAO在JdbcUtils中获取数据库连接;
 * 整个DAO调用了dbutils的API接口
 * 这个调用方法需要保持实体类与数据库的字段名相一致，否则会出现空值NULL
 */
public class Dao<T> {

    private QueryRunner queryRunner = new QueryRunner();//AbstractQueryRunner的子类，具体功能没看，主要调用了下面的query功能

    private Class<T> clazz;

    public Dao() {
        //获取泛型父类的类型，getClass获取的是 子类的类型
        Type superClass = getClass().getGenericSuperclass();

        if(superClass instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) superClass;
            //获取真正的泛型的参数,返回的是一个Type类型的数组
            Type[] typeArgs =parameterizedType.getActualTypeArguments();
            //判断数组不为空 且长度大于0
            if(typeArgs != null && typeArgs.length > 0){
                //判断typeArgs[0]是否为Class 类型 ，即，泛型参数为一个类
                if(typeArgs[0] instanceof Class){
                    clazz = (Class<T>) typeArgs[0]; //赋值给clazz对象
                }
            }
        }
    }

    /**
     * 返回某一个字段的值，例如：返回某一条记录的username
     */
    public <E> E getForValue(String sql, Object... args) {

        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            return (E) queryRunner.query(connection, sql, new ScalarHandler(), args);

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JdbcUtils.releaseConnection(connection);
        }
        return null;
    }

    /**
     * 返回T 所对应的List
     */
    public List<T> getForList(String sql, Object... args) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();

            return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), args);

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JdbcUtils.releaseConnection(connection);
        }

        return null;
    }

    /**
     * 返回对应的T 的一个实体类的对象
     */
    public  T get(String sql, Object... args) {

        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<T>(clazz), args);

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JdbcUtils.releaseConnection(connection);
        }

        //System.out.println(clazz);
        return null;
    }

    /**
     * 该方法封装了 INSERT ,DELETE,UPDATE 操作
     */
    public void update(String sql, Object... ags){

        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            queryRunner.update(connection, sql, ags);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JdbcUtils.releaseConnection(connection);
        }
    }

}