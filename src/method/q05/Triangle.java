package method.q05;
import java.util.Scanner;

public class Triangle {
	
	//メソッドの作成
	public static int getTriangleArea(int teihen,int high) {
		return teihen * high /2;
	}

	public static void main(String[] args) {
		
		//取り込みの準備
		Scanner num = new Scanner(System.in);
		
		//底辺
		System.out.print("底辺：");
		int teihen = num.nextInt();
		
		//高さ
		System.out.print("高さ：");
		int high = num.nextInt();
		
		//面積＝メソッド使用
		System.out.print("三角形の面積：" +getTriangleArea(teihen,high));
		
		
		num.close();

	}

}
