package method.q02;

public class Introduce {
	
	//メソッドの作成
	public static void selfIntroduce(String name) {
		System.out.printf("私の名前は%sです。",name);
	}

	public static void main(String[] args) {
		//メソッドの使用
		selfIntroduce("山田");
	}

}
