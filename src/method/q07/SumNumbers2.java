package method.q07;
import java.util.Scanner;

public class SumNumbers2 {
	
	//メソッドの作成
	public static int calculateSum(int num1,double num2) {
		return num1+(int)num2;		//型変換が必要なこと注意
	}
	
	public static void main(String[] args) {
		
		//インスタンス生成
		Scanner num = new Scanner(System.in);
		
		//第一引数
		System.out.print("第一引数（整数）：");
		int num1 = num.nextInt();
		
		//第二引数
		System.out.print("第二引数（実数）：");
		double num2 = num.nextDouble();
		
		//メソッドを使用して加算結果を出力
		System.out.printf("加算結果：%d",calculateSum(num1,num2));
		
		num.close();
	}
}
