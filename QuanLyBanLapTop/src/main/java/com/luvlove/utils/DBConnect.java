package com.luvlove.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnecttion() {
		Connection cons = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cons = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useUnicode=yes&characterEncoding=UTF-8", "root", "1234");
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
