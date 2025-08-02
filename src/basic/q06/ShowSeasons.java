package basic.q06;

public class ShowSeasons {

	public static void main(String[] args) {
		//月を意味する変数を宣言
		int month=1;
		
		//switch文
		switch(month) {
		case 1:
		case 2:
		case 12:
			System.out.printf("%d月は冬です",month);
			break;
		case 3:
		case 4:
		case 5:
			System.out.printf("%d月は春です",month);
			break;
		case 6:
		case 7:
		case 8:
			System.out.printf("%d月は夏です",month);
			break;
		case 9:
		case 10:
		case 11:
			System.out.printf("%d月は秋です",month);
			break;
		default:
			System.out.printf("%d月は存在しないです。",month);
			break;
		}
	}
}
