package method.q04;
import java.util.Scanner;

public class SumNumbers {
	
	//メソッドの作成
	public static int calculateSum(int num1,int num2) {
		return num1+num2;
		
	}
	public static void main(String[] args) {
		
		//引数の取り込み
		Scanner num = new Scanner(System.in);
		System.out.print("第一引数：");
		int num1 = num.nextInt();
		System.out.print("第二引数：");
		int num2 = num.nextInt();
		//メソッドの使用
		System.out.printf("加算結果：%d",calculateSum(num1,num2));
		num.close();
		

	}

}
