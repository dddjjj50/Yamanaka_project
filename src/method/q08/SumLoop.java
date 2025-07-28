package method.q08;

import java.util.Scanner;

public class SumLoop {

	//メソッドを作成
	public static int sumLoop(int min, int max) {
		//結果を変数宣言・初期化
		int sum = 0;

		//最小値から最大値まで加算
		for (int i = min; i <= max; i++) {
			sum = sum + i;
		}
		
		//ループ抜けたときのsumの値を戻り値に。
		return sum;
	}

	public static void main(String[] args) {

		//Scannerクラスを使うための準備
		Scanner num = new Scanner(System.in);

		//最小値を取得
		System.out.print("最小値：");
		int min = num.nextInt();

		//最大値を取得
		System.out.print("最大値：");
		int max = num.nextInt();

		//入力された数値が最小値以下だった場合
		if (max <= min) {
			while (max <= min) {	//maxがmin以下なら繰り返す
				System.out.println("！最大値は最小値より大きい値を入力してください！");
				System.out.print("最大値：");
				max = num.nextInt();	//ループ抜けたときのmaxがちゃんとしたmax
			}	
		}
		
		//メソッドを使用
		System.out.printf("加算結果：%d",sumLoop(min,max));
		
		num.close();
	}

}
