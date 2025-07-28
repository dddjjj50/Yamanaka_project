package method.q09;

public class Even {
	
	//メソッド作成
	public static boolean checkEven(int num) {
		if(num%2==0) return true;	//偶数の場合はtrue
		else return false;	//奇数の場合はfalse
	}
	
	public static void main(String[] args) {
		
		//判定する変数を宣言
		int num = 5;
		
		//判定結果
		System.out.printf("%dは",num);
		
		if(checkEven(num)==true) {
			System.out.println("偶数です。");
		}
		else {
			System.out.println("奇数です。");
		}
	}

}
