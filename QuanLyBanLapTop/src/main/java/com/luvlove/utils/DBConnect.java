package com.luvlove.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    public static Connection getConnecttion() {
        Connection cons = null;
        try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			cons = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=shop", "sa", "1234");
//                        System.out.println("Thành công");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=shop";
            String user = "sa";
            String password = "1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cons = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("dsa");
            System.out.println(e.getMessage());
        }
        return cons;
    }

    public static void main(String[] args) {
        System.out.println(getConnecttion());
    }

}
