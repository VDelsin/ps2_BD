package br.mack.sp.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    String url = "jdbc:mysql//localhost:32782/ps2_p1";
    String user = "root";
    String psw = "root";

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url,user,psw);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

        return null;
    }



}
