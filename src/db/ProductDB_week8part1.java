package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductDB_week8part1 { //パート1：データの追加

	public static void main(String[] args) {

		System.out.println("--商品の登録--");

		Scanner s = new Scanner(System.in);

		//=====商品名========
		System.out.println("商品名を入力してください：");
		String name = s.nextLine();

		//=====価格========
		System.out.println("価格を入力してください：");
		int price = s.nextInt();

		//=====在庫数========
		System.out.println("在庫数を入力してください：");
		int stock = s.nextInt();

		//=====カテゴリーID========
		System.out.println("カテゴリーIDを入力してください：");
		int category_id = s.nextInt();

		//=====DB反映========
		String url = "jdbc:mysql://localhost:3306/product_management";
		String user = "root";
		String pass = "root";
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			String sql = "INSERT INTO products (name, price, stock,category_id) VALUES (?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			pstmt.setInt(3, stock);
			pstmt.setInt(4, category_id);
			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("登録成功件数： 1件");
				System.out.println("登録内容：");
				System.out.printf(
						"商品名: %s, 価格: %d, 在庫数: %d, カテゴリーID: %d",
						name, price, stock,category_id
				);
			} else {
				System.out.println("商品登録に失敗しました。");
			}
			s.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("失敗");
			System.out.println("原因：" + e.getMessage());
			e.printStackTrace();
		}
	}

}
