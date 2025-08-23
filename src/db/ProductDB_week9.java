package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductDB_week9 {

	public static void main(String[] args) {
		
		//＝＝＝データ取り込み＝＝＝＝＝＝＝＝＝＝＝＝＝＝
		Scanner s = new Scanner(System.in);
		//①
		System.out.println("----商品の価格と在庫を更新①");
		System.out.println("更新する商品のIDを入力してください：");
		int id1 = s.nextInt();
		System.out.println("更新後の価格を入力してください：");
		int price1 = s.nextInt();
		System.out.println("更新後の在庫数を入力してください：");
		int stock1 = s.nextInt();
		
		//②
		System.out.println("----商品の価格と在庫を更新②");
		System.out.println("更新する商品のIDを入力してください：");
		int id2 = s.nextInt();
		System.out.println("更新後の価格を入力してください：");
		int price2 = s.nextInt();
		System.out.println("更新後の在庫数を入力してください：");
		int stock2 = s.nextInt();
		
		//＝＝＝DB反映＝＝＝＝＝＝＝＝＝＝＝＝＝＝
		String url = "jdbc:mysql://localhost:3306/product_management";
		String user = "root";
		String pass = "root";
		int result1,result2;
		
		try(Connection con = DriverManager.getConnection(url,user,pass)){
			//オートコミットを無効化
			con.setAutoCommit(false);
			try {
				//①
				String sql1 = "UPDATE products SET price = ? , stock = ? WHERE id = ?";
				PreparedStatement pstmt1 = con.prepareStatement(sql1);
				pstmt1.setInt(1, price1);
				pstmt1.setInt(2, stock1);
				pstmt1.setInt(3, id1);
				result1 = pstmt1.executeUpdate();
				//②
				String sql2 = "UPDATE products SET price = ? , stock = ? WHERE id = ?";
				PreparedStatement pstmt2 = con.prepareStatement(sql2);
				pstmt2.setInt(1, price2);
				pstmt2.setInt(2, stock2);
				pstmt2.setInt(3, id2);
				result2 = pstmt2.executeUpdate();
				
				if ((result1+result2) == 2) {
					con.commit();
					System.out.println("コミット成功");
					System.out.println("更新成功件数： "+(result1+result2));
					System.out.println();//改行
					System.out.println("更新内容①");
					System.out.printf(
							"商品ID: %d, 価格 %d, 在庫数: %d\n",
							id1, price1, stock1
					);
					System.out.println();//改行
					System.out.println("更新内容②");
					System.out.printf(
							"商品ID: %d, 価格 %d, 在庫数: %d\n",
							id2, price2, stock2
					);
				} else {
					con.rollback();
					System.out.println("2件全ての更新に失敗しました。");
					System.out.printf("更新成功件数：%2d件\n",(result1+result2));
					System.out.println("ロールバックしました。");

				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}catch(SQLException e) {
			System.out.println("データベース接続失敗");
			e.printStackTrace();
		}
		s.close();
	}
}
