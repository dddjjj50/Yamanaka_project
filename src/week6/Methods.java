package week6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Methods {
	//★1.商品追加----------------------------------------
	public static void addItems() throws Exception{
		Scanner s = new Scanner(System.in);
		
		System.out.println("商品IDを入力してください：");
		int id = s.nextInt();
		s.nextLine();	//改行の吸収
		System.out.println("入力された商品ID：" + id);
		
		//=====商品名========
		System.out.println("商品名を入力してください：");
		String name = s.nextLine();
		
		if(name==null || name.trim().isEmpty()) {
			System.out.println("無効な入力です。入力された商品名：" + name);
			throw new Exception("無効な入力です。商品名を正しく入力してください。");
		}else {
			System.out.println("入力された商品名：" + name);
		}
		
		//=====価格========
		System.out.println("価格を入力してください：");
		int price = s.nextInt();
		
		if(price<0) {
			System.out.println("無効な入力です。入力された価格：" + price);
			throw new Exception("無効な入力です。価格を正しく入力してください。");
		}else {
			System.out.println("入力された価格：" + price);
		}
		
		//=====在庫数========
		System.out.println("在庫数を入力してください：");
		int stock = s.nextInt();
		
		if(stock<0) {
			System.out.println("無効な入力です。入力された在庫数：" + stock);
			throw new Exception("無効な入力です。在庫を正しく入力してください。");
		}else {
			System.out.println("入力された在庫数：" + stock);
		}
		
		//=====DB反映========
		String url = "jdbc:mysql://localhost:3306/product_management";
		String user = "root";
		String pass = "root";
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			String sql = 
					"INSERT INTO products (id, name, price, stock) VALUES (?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, price);
			pstmt.setInt(4, stock);
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				Item item = new Item(id, name, price, stock); // ← Itemオブジェクトを作る
				System.out.println(item + "を登録しました。");
			}else {
				System.out.println("商品登録に失敗しました。");
			}
			
			con.close();
			
		}catch(SQLException e) {
			System.out.println("失敗");
			System.out.println("原因：" + e.getMessage());
			e.printStackTrace();
		}
	}
	//★2.商品情報取得------------------------------------
	public static void getItemsInfo() {
		Scanner s = new Scanner(System.in);
		System.out.println("商品情報を取得する商品名を入力してください：");
		String keyword = s.nextLine();
		
		String url = "jdbc:mysql://localhost:3306/product_management";
		String user = "root";
		String pass = "root";
		
		ArrayList<Item> items = new ArrayList<>();
		
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			String sql = "SELECT * FROM products WHERE name LIKE ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int stock = rs.getInt("stock");
				
				Item item = new Item(id,name,price,stock);
				items.add(item);
				System.out.println(item);
			}
			con.close();
		}catch(SQLException e) {
			System.out.println("データベース接続失敗");
			System.out.println("原因：" + e.getMessage());
			e.printStackTrace();
		}
	}
	//★3.商品検索----------------------------------------
	public static void searchItems() {
		Scanner s = new Scanner(System.in);
		System.out.println("商品情報を取得する商品名を入力してください：");
		String keyword = s.nextLine();
		
		String url = "jdbc:mysql://localhost:3306/product_management";
		String user = "root";
		String pass = "root";
		
		ArrayList<Item> items = new ArrayList<>();
		
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			String sql = "SELECT * FROM products WHERE name LIKE ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int stock = rs.getInt("stock");
				
				Item item = new Item(id,name,price,stock);
				items.add(item);
				System.out.println(item);
			}
			con.close();
		}catch(SQLException e) {
			System.out.println("データベース接続失敗");
			System.out.println("原因：" + e.getMessage());
			e.printStackTrace();
		}
	}
	//★4.商品全て表示------------------------------------
	public static void allItems() {
		System.out.println("商品を全て表示します");
		String url = "jdbc:mysql://localhost:3306/product_management";
		String user = "root";
		String pass = "root";
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM products";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int stock = rs.getInt("stock");
				
				Item item = new Item(id,name,price,stock);
				System.out.println(item);
			}
			con.close();
		}catch(SQLException e) {
			System.out.println("データベース接続失敗");
			System.out.println("原因：" + e.getMessage());
			e.printStackTrace();
		}
	}
	//★5.商品削除----------------------------------------
	public static void deleteItems() {
		Scanner s = new Scanner(System.in);
		System.out.println("削除する商品のIDを入力してください：");
		int id = s.nextInt();
				
		String url = "jdbc:mysql://localhost:3306/product_management";
		String user = "root";
		String pass = "root";
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			String sql = "DELETE FROM products WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.printf("商品IDが%dの商品を削除しました\n",id);
			}else {
				System.out.printf("商品IDが%dの商品は存在しません\n",id);
			}
			pstmt.close();
			con.close();
		}catch(SQLException e) {
			System.out.println("データベース接続失敗");
			System.out.println("原因：" + e.getMessage());
			e.printStackTrace();
		}
	}

}
