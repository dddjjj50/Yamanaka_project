package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductDB_week8part3 {

	public static void main(String[] args) {
		
		System.out.println("--商品の削除--");

		Scanner s = new Scanner(System.in);
		
		//====カテゴリーID========
		System.out.println("削除するカテゴリーIDを入力してください：");
		int category_id = s.nextInt();
		
		//=====DB反映========
		String url = "jdbc:mysql://localhost:3306/product_management";
		String user = "root";
		String pass = "root";
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			String sql = "DELETE FROM products WHERE category_id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, category_id);
			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.printf("削除成功件数： %d件\n",result);
				System.out.printf(
						"カテゴリーID %d の商品を削除しました。",
						category_id
				);
			} else {
				System.out.println("削除成功件数： 0件");
				System.out.println("削除失敗");
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
