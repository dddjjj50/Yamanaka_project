package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductDB_week8part2 {

	public static void main(String[] args) {

		System.out.println("--商品の価格と在庫を更新--");

		Scanner s = new Scanner(System.in);
		
		//====商品ID========
		System.out.println("更新する商品のIDを入力してください：");
		int id = s.nextInt();
		
		//=====価格========
		System.out.println("更新後の価格を入力してください：");
		int price = s.nextInt();

		//=====在庫数========
		System.out.println("更新後の在庫数を入力してください：");
		int stock = s.nextInt();

		//=====DB反映========
		String url = "jdbc:mysql://localhost:3306/product_management";
		String user = "root";
		String pass = "root";
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			String sql = "UPDATE products SET price = ? , stock = ? WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, price);
			pstmt.setInt(2, stock);
			pstmt.setInt(3, id);
			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("更新成功件数： 1件");
				System.out.println("更新内容：");
				System.out.printf(
						"商品ID: %d, 価格: %d, 在庫数: %d",
						id, price, stock
				);
			} else {
				System.out.println("更新成功件数： 0件");
				System.out.println("更新失敗");
			}
			s.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("データベース接続失敗");
			System.out.println("原因：" + e.getMessage());
			e.printStackTrace();
		}

	}

}
