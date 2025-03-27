package managment.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseUtil {
    private static Connection myConnection = null;
    public static Connection getConnection() {
        if (myConnection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                myConnection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:33306/project2", "root", "mysqlpass");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return myConnection;

    }



}
