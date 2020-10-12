package prototype;

public class Demo {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		BookShop shop1 = new BookShop();
		shop1.loadBooksFromDB();
		shop1.setShopName("Shop 1");
		System.out.println(shop1);
		
		
		// If we want to create another book shop obj,
		//calling loadBookFromDB would be costly operation as the same init data gets loaded from DB.
		//Instead we can use the prototype pattern, clone the obj and set additonal properties to cloned obj
		
		BookShop shop2 = (BookShop) shop1.clone();
		shop2.setShopName("Shop 2");
		System.out.println(shop2);
		//we implemented clone method in bookshop 2 class, shallow cloning is used, instead use deep cloning.
	}

}
