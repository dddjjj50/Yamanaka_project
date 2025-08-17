package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductDB_part1 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/product_management";
		String user = "root";
		String pass = "root";
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			System.out.println("DB接続成功");
			con.close();
			
		}catch(SQLException e) {
			System.out.println("DB接続失敗");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
