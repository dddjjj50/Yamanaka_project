package product;

import java.util.List;

public class Main {	
	public static void main(String[] args) {
		//---商品を5つ追加してすべてを表示する---
		//追加するデータを配列で用意
		Product[] p = {
				new Product(1,"冷蔵庫",50000,10),
				new Product(2,"ソファ",30000,5),
				new Product(3,"米",2000,3),
				new Product(4,"小説",1500,4),
				new Product(5,"Tシャツ",1500,5)
		};
		
		//addProductメソッドを利用
		for(int i=0;i<p.length;i++) {
			ProductManager.addProduct(p[i]);
		}
		System.out.println("---商品を5つ追加してすべてを表示する---");
		ProductManager.printOut();
		System.out.println();	//改行
		
		//=================================================
		System.out.println("---商品を1つ削除してすべてを表示する---");
		ProductManager.removeProduct(1); 
		ProductManager.printOut();
		System.out.println();	//改行
		//=================================================
		System.out.println("---商品名「米」の情報を表示する---");
		ProductManager.getProductByName("米");
		System.out.println();	//改行
		//=================================================
		System.out.println("---商品名「ソファ」の情報と割引率30%の情報を表示する---");
		ProductManager sofa = new ProductManager();
		List<Product> sofaList = sofa.search("ソファ");
		
		double discountRate = 0.3;
		
		for(Product ps : sofaList) {
			DiscountedProduct dp = new DiscountedProduct(
					ps.getId(),ps.getName(),ps.getPrice(),ps.getStock(),discountRate
			);
			System.out.printf(
					", 割引率=%.1f, 割引後価格=%.0f%n",
			        discountRate , dp.calculateDiscountedPrice()
			);
		}
		System.out.println();	//改行
		//=================================================
		System.out.println("---商品名「Tシャツ」を検索して表示する---");
		Searchable searchable = new ProductManager();
		searchable.search("Tシャツ");
	}

}
