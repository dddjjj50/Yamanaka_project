package product;

public class Product {
	
	//フィールド
	private int id;
	private String name;
	private int price;
	private int stock;
	
	//コンストラクタ。
	//フィールドにいたずらに代入しないようにthisステートメント
	public Product(int id,String name,int price,int stock) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
		
	//ゲッター。値を取得
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getStock () {
		return stock;
	}
	
	//セッター。
	public void setInt(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	//データベースの中身を表示するメソッド
	public void print() {
		System.out.printf("id=%d, name=%s, price=%d, stock=%d\n",
				id,name,price,stock);
	}
}
