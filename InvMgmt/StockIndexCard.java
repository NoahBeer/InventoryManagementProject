/*
 * This class creates the StockIndexCard object for UserInterface to use. It creates public get methods
 * so that InventoryManagement is able to access the variables
 * 
 * @Noah Beer
 */
public class StockIndexCard { // class
	private int sic_id; // declares sic_id which will store an integer ID number for each book
	private String title; // declares title which will store the title for each book
	private String author; // declares author which will store the author for each book
	private double price; // declares price which will store the price for each book
	private int quantity; // declares quantity which will store how many of each book exists
	
	
	public StockIndexCard(int SICID1, String title1, String author1, double price1, int quantity1) { // constru
		sic_id = SICID1; // sic_id gets the value of SICID1 from the constructor
		title = title1; // title gets the value of title1 from the constructor
		author = author1; // author gets the value of author1 from the constructor
		price = price1; // price gets the value of price 1 from the constructor
		quantity = quantity1; // quantity gets the value of quantity1 from the constructor
	}
	
	/*
	 * returns sic_id
	 */
	public int getSICID() { 
		return sic_id; 
	}
	
	/*
	 * returns title
	 */
	public String getTitle() { 
		return title; 
	}
	
	/*
	 * returns author
	 */
	public String getAuthor() {
		return author; 
	}
	
	/*
	 * returns price
	 */
	public double getPrice() { 
		return price;
	}
	
	/*
	 * returns quantity
	 */
	public int getQuantity() { 
		return quantity; 
	}
	
	/*
	 * returns the parameters of StockIndexCard in a String
	 */
	public String toString() { 
		return ("\nStock Index Card: " + sic_id + "\n\tTitle: " + title + "\n\tAuthor: " + author + "\n\tPrice: " + price + "\n\tQuantity: " + quantity + "\n"); 
	}
	
	/*
	 * changes the price of the specified SIC
	 */
	public void changePrice(double priceHolder) { 
		price = priceHolder; 
	}
	
	/*
	 * adds the entered in stock to the current value of stock for the specified SIC
	 */
	public void addStockBy(int stock) { 
		quantity = stock; 
	}
	
	/*
	 * decreases the entered in stock from the current value of stock for the specified SIC
	 */
	public void decreaseStockBy(int stock) { 
		quantity = stock; 
	}
} // class end
