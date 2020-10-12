package prototype;

import java.util.ArrayList;
import java.util.List;

public class BookShop implements Cloneable {
	
	private String shopName;
	List<Book> books = new ArrayList<Book>();
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public void loadBooksFromDB() {
		
		for(int i=0;i<5;i++) {
			Book book = new Book();
			book.setBookName("Book Name: "+i);
			book.setBookAuthor("Book Author: "+i);
			getBooks().add(i, book);
		}
	}
	
	@Override
	public String toString() {
		return "BookShop [shopName=" + shopName + ", books=" + books + "]";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
