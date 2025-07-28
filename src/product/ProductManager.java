package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductManager {
	/*
	//addProduct(Product product)：新たなproductを追加する
	public static void addProduct(Product product) {
		//まずDB接続
		String url = "jdbc:mysql://localhost:3306/product_management";
		String user = "root";
		String pass = "root";
		//Connection con = DriverManager.getConnection(url,user,pass);
	}

	//removeProduct(int id)：idを引数としてproductを削除する
	public static void removeProduct(int id) {

	}

	//getProductByName(String name)：
	//nameを引数としてproduct情報を取得する
	public static void getProductByName(String name) {

	}

	//データをすべて表示するメソッド
	public static void printOut() {
		//Product: id=1,name=冷蔵庫,price=50000,stock=10
		String url = "jdbc:mysql://localhost:3306/product_management";
		String user = "root";
		String pass = "root";
		//Connection con = DriverManager.getConnection(url,user,pass);
	}*/

	public static void test() {
		String url = "jdbc:mysql://localhost:3306/product_management";
		String user = "root";
		String pass = "root";
		
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			System.out.println("データベース接続成功");
			con.close();
		}catch(SQLException e) {
			System.out.println("データベース接続失敗");
			System.out.println("原因：" +e.getMessage());
			e.printStackTrace();
		}
			
		
		
	}

}
