package week6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("--メニュー--");
				System.out.println("1.商品追加");
				System.out.println("2.商品情報取得");
				System.out.println("3.商品検索");
				System.out.println("4.商品全て表示");
				System.out.println("5.商品削除");
				System.out.println("0.終了");
				
				System.out.println(); //改行
				
				
				System.out.println("メニューから操作を選択してください。");
				int menu = s.nextInt();
				
				//0～5以外の数字をブロックする
				while(menu>5) {
					System.out.println("メニュー一覧を参考に、半角数字で入力してください。");
					menu = s.nextInt();
				}
				
				//メニュー番号ごとにメソッドを呼び出す
				switch (menu) {
				case 1:
					try {
						Methods.addItems();
					}catch(Exception e) {
						e.printStackTrace();
					}
					break;
				case 2:
					Methods.getItemsInfo();
					break;
				case 3:
					Methods.searchItems();
					break;
				case 4:
					Methods.allItems();
					break;
				case 5:
					Methods.deleteItems();
					break;
				case 0:
					System.out.println("終了します");
					return;
				}
				
				System.out.println(); //改行
				System.out.println();
				
			}catch(Exception e) {
				//何も表示せずメニューに戻る
			}
		}
		
		
		
	}

}
