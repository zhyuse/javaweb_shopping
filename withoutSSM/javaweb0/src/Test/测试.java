package Test;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

public class 测试 {
    public static void main(String[] args){
        test test=new test();
        try {
            test.getname();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
