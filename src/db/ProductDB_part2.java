package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDB_part2 {

	public static void main(String[] args) {
		
		System.out.println("--productsテーブル全ての商品情報を表示--");
		System.out.println(); //改行
		
		String url = "jdbc:mysql://localhost:3306/product_management";
		String user = "root";
		String pass = "root";
		
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM products";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int stock = rs.getInt("stock");
				int category_id = rs.getInt("category_id");
				
				System.out.println("id: " + id);
				System.out.println("name: " + name);
				System.out.println("price: " + price);
				System.out.println("stock: " + stock);
				System.out.println("category_id: " + category_id);
				System.out.println(); //改行
			}
			
			con.close();
			
		} catch (SQLException e) {
			System.out.println("DB接続失敗");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}