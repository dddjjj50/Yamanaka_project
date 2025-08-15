package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductManager implements Searchable{

	//データをすべて表示するメソッド
	public static void printOut() {
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

				System.out.printf("Product: id=%d, name=%s, price=%d, stock=%d\n",
						id, name, price, stock);
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("データベース接続失敗");
			System.out.println("原因：" + e.getMessage());
			e.printStackTrace();
		}
	}

	//addProduct(Product product)：新たなproductを追加する
	public static void addProduct(Product product) {
		//まずDB接続の材料
		String url = "jdbc:mysql://localhost:3306/product_management";
		String user = "root";
		String pass = "root";
		try {
			//データベース接続
			Connection con = DriverManager.getConnection(url, user, pass);
			//これからSQL文を作るよ文
			Statement stmt = con.createStatement();
			// データをSQL文に埋め込む（※SQLインジェクションを避けるなら PreparedStatement がより安全だけど、今回はまず動くことを優先！）
			String sql = String.format(
					"INSERT INTO products (id, name, price, stock) VALUES (%d, '%s', %d, %d)",
					product.getId(), product.getName(), product.getPrice(), product.getStock());

			stmt.executeUpdate(sql); // ← INSERT には executeUpdate を使う！
			con.close();
		} catch (SQLException e) {
			System.out.println("データベース接続失敗");
			System.out.println("原因：" + e.getMessage());
			e.printStackTrace();
		}
	}

	//removeProduct(int id)：idを引数としてproductを削除する
	public static void removeProduct(int id) {
		String url = "jdbc:mysql://localhost:3306/product_management";
		String user = "root";
		String pass = "root";
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = String.format(
					"DELETE FROM products WHERE id = %d", id);
			stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			System.out.println("データベース接続失敗");
			System.out.println("原因：" + e.getMessage());
			e.printStackTrace();
		}
	}

	//getProductByName(String name)：
	//nameを引数としてproduct情報を取得する
	public static void getProductByName(String name) {
		String url = "jdbc:mysql://localhost:3306/product_management";
		String user = "root";
		String pass = "root";
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = String.format(
					"SELECT * FROM products WHERE name='%s'", name);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				name = rs.getString("name");
				int price = rs.getInt("price");
				int stock = rs.getInt("stock");
				System.out.printf("Product: id=%d, name=%s, price=%d, stock=%d%n",
						id, name, price, stock);
			}
		} catch (SQLException e) {
			System.out.println("データベース接続失敗");
			System.out.println("原因：" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	//searchメソッドの実装。商品名での検索機能の実装
	@Override
	public List<Product> search(String keyword) {
		List<Product> resultList = new ArrayList<>(); 
		String url = "jdbc:mysql://localhost:3306/product_management";
		String user = "root";
		String pass = "root";
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = String.format(
					"SELECT * FROM products WHERE name LIKE '%%%s%%'", keyword);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int stock = rs.getInt("stock");
				
				System.out.printf("Product: id=%d, name=%s, price=%d, stock=%d",
						id, name, price, stock);
				
				resultList.add(new Product(id, name, price, stock));

			}
		} catch (SQLException e) {
			System.out.println("データベース接続失敗");
			System.out.println("原因：" + e.getMessage());
			e.printStackTrace();
		}
		
		return resultList;
	}
}
