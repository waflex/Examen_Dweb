package cn.dweb.database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DbConnect {
    
    private static Connection connection = null;

    public static Connection getConnection() throws ClassNotFoundException,SQLException{
        if(connection == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen","root","admin");
        }
        return connection;
    }
}