package basic.q05;

public class FizzBuzz {

	public static void main(String[] args) {
		//まず繰り返し文
		for(int i=1;i<=100;i++) {
			
			//3の倍数かつ5の倍数なら
			if(i%3==0 && i%5==0) System.out.println("FizzBuzz");
			
			//3の倍数なら
			else if(i%3==0) System.out.println("Fizz");
			
			//5の倍数なら
			else if(i%5==0) System.out.println("Buzz");
			
			//3の倍数でも5の倍数でもないなら
			else System.out.println(i);
		}

	}

}
