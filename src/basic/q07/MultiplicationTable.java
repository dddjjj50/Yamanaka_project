package basic.q07;

public class MultiplicationTable {

	public static void main(String[] args) {
		for(int num1=1;num1<=9;num1++) { //縦
			for(int num2=1;num2<=9;num2++) {//横
				System.out.printf("%3d",num1*num2);
			}
			System.out.println(); //num1の段終わったら改行
		}

	}

}
