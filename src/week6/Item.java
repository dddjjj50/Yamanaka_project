package week6;

public class Item {
	
	private int id;
	private String name;
	private int price;
	private int stock;
	
	public Item(int id,String name,int price,int stock) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	public int getId() { return id; }
	public String getName() { return name; }
	public int getPrice() { return price; }
	public int getStock() { return stock; }
	
	@Override //ObjectクラスのtoString()メソッドをオーバーライド
	public String toString() {
		return 
			"Product: id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock;
	}
}
