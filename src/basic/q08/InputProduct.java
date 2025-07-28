package basic.q08;
import java.util.Scanner; //Scannerクラスを使うよ宣言

public class InputProduct {

	public static void main(String[] args) {
		//Scannerクラスを使う準備としてインスタンス生成
		Scanner q08 = new Scanner(System.in);
		
		System.out.println("商品名を入力してください：");
		String item = q08.nextLine();
		
		System.out.println("価格を入力してください：");
		int price = q08.nextInt();
		
		System.out.printf("商品名は%sです。価格は%dです。",item,price);
		q08.close();

	}

}
