package method.q06;
import java.util.Scanner;

public class Circle {
	
	//メソッドの作成
	public static double getCircleArea(double r) {
		return r*r*3.14;
	}
	
	//メソッドの使用
	public static void main(String[] args) {
		
		//半径をコンソールに入力させる
		Scanner r2 = new Scanner(System.in);
		System.out.print("円の半径：");
		double r = r2.nextDouble();
		
		//メソッドを使用して面積を出力
		System.out.printf("円の面積：%.1f",getCircleArea(r));
		
		r2.close();
	}
}
