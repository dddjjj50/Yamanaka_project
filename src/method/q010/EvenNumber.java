package method.q010;

public class EvenNumber {
	
	/*メソッドを作成。
	戻り値：配列内の偶数の個数
	引数：整数値が格納された配列
	*/
	
	public static int getEvenNumbers(int num[]) {
		
		//個数を変数宣言
		int count = 0;
		
		//ループで変数の個数を数える。
		for(int i=0;i<num.length;i++) {
			if(num[i]%2==0) {
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		
		//配列宣言
		int num[] = {3, 2, 5, 6, 7, 25, 10, 51, 88, 98};
		
		//ループで配列を表示
		System.out.print("[");
		for(int i=0;i<num.length;i++) {
			//[]の中の「,」の調整
			System.out.print(num[i]);
			if(i!=(num.length-1)) {
				System.out.print(",");
			}
		}
		System.out.printf("]には、偶数が%d個あります。",getEvenNumbers(num));

	}

}
