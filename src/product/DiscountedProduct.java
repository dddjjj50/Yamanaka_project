package product;

public class DiscountedProduct extends Product {
	
	//属性の追加
	private double discountRate;
	
	//コンストラクタの呼び出し
	public DiscountedProduct(int id,String name,int price,int stock,double discountRate) {
		super(id,name,price,stock);
		this.discountRate = discountRate;
	}
	
	//追加するメソッド（割引価格を計算するメソッド）
	public double calculateDiscountedPrice() {
		return getPrice() * (1-discountRate);
	}
	

}
