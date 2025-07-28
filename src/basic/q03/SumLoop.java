package basic.q03;

public class SumLoop {

	public static void main(String[] args) {
		int sum = 0;	//最初は0
		for(int i=1;i<=100;i++) { //足し算だけ繰り返す
			sum = sum + i;
		}
		System.out.println(sum); //最後に合計を表示

	}

}
