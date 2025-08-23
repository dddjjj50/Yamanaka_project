package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductDB_week8part1 { // パート1：データの追加

    public static void main(String[] args) {

        System.out.println("--商品の登録--");

        Scanner s = new Scanner(System.in);

        try {
            // =====商品名========
            System.out.print("商品名を入力してください：");
            String name = s.nextLine();

            // =====価格========
            System.out.print("価格を入力してください：");
            int price = s.nextInt();
            s.nextLine(); // 改行消費

            // =====在庫数========
            System.out.print("在庫数を入力してください：");
            int stock = s.nextInt();
            s.nextLine(); // 改行消費

            // =====カテゴリーID========
            System.out.print("カテゴリーIDを入力してください：");
            int category_id = s.nextInt();
            s.nextLine(); // 改行消費

            // =====DB反映========
            String url = "jdbc:mysql://localhost:3306/product_management";
            String user = "root";
            String pass = "root";

            String sql = "INSERT INTO products (name, price, stock, category_id) VALUES (?, ?, ?, ?)";

            try (
                Connection con = DriverManager.getConnection(url, user, pass);
                PreparedStatement pstmt = con.prepareStatement(sql)
            ) {
                pstmt.setString(1, name);
                pstmt.setInt(2, price);
                pstmt.setInt(3, stock);
                pstmt.setInt(4, category_id);

                int result = pstmt.executeUpdate();

                if (result > 0) {
                    System.out.println("登録成功件数： 1件");
                    System.out.println("登録内容：");
                    System.out.printf("商品名: %s, 価格: %d, 在庫数: %d, カテゴリーID: %d%n",
                            name, price, stock, category_id);
                } else {
                    System.out.println("商品登録に失敗しました。");
                }

            } catch (SQLException e) {
                System.out.println("データベースへの登録に失敗しました。");
                System.out.println("原因：" + e.getMessage());
                e.printStackTrace();
            }

        } finally {
            s.close(); // Scannerは必ず閉じる
        }
    }
}