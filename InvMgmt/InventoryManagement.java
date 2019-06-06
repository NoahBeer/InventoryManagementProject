/*
 * Manages all of StockIndexCards. 
 * Stores them in an array.
 * Allows them to be changed by user in methods
 * 
 * @Noah Beer
 */

import java.util.ArrayList; // imports the ArrayList class

public class InventoryManagement { // class
	
	private ArrayList<StockIndexCard> inventoryArray; // declares the private ArrayList inventoryArray called StockIndexCard
	
	public InventoryManagement() { // constructor
		 inventoryArray = new ArrayList<StockIndexCard>(); // initializes inventoryArray
	}
	
	/*
	 * takes in sic_idHolder, titleHolder, authorHolder, Price Holder, and quantityHolder and adds a SIC to inventoryArray
	 */
	public void addStockIndexCard(int sic_idHolder, String titleHolder, String authorHolder, double priceHolder, int quantityHolder) {
		StockIndexCard sic; // declares sic
		sic = new StockIndexCard(sic_idHolder, titleHolder, authorHolder, priceHolder, quantityHolder); // initializes sic with the following parameters from addStockIndexCard()
		inventoryArray.add(sic); // adds sic to invetoryArray
	}
		
	/*
	 * takes in id and removes the specified SIC from inventoryArray
	 */
	public void removeStockIndexCard(int id) {
		for(int i = 0; i < inventoryArray.size(); i++) { // loops through inventoryArray
			if(id == inventoryArray.get(i).getSICID()) { // checks to see if id is equal to the id at the position of index i
				inventoryArray.remove(i); // removes the SIC at index i from inventoryArray
			}
		}
	}
	
	/*
	 * takes in id and increasedBY and increases the quantity of the specified SIC from inventoryArray
	 */
	public String increaseStock(int id, int increaseBy) { 
		for(int i = 0; i < inventoryArray.size(); i++) { // loops through inventoryArray
			if(id == inventoryArray.get(i).getSICID()) { // checks to see if id is equal to the id at the position of index i
				inventoryArray.get(i).addStockBy(inventoryArray.get(i).getQuantity() + increaseBy); // adds increaedBy to the  current quantity
				return "Stock Increased\n";
			}
		}
		return "There is not a SIC with the ID you entered.";
	}
	
	public void decreaseStock(int id, int decreaseBy) { // takes in id and decreasedBy and decreases the quantity of the specified SIC from inventoryArray
		for(int i = 0; i < inventoryArray.size(); i++) { // loops through inventoryArray
			if(id == inventoryArray.get(i).getSICID()) {  // checks to see if id is equal to the id at the position of index i
			inventoryArray.get(i).decreaseStockBy(inventoryArray.get(i).getQuantity() - decreaseBy); // subtracts decreasedBy from the current quantity
			}
		}
	}
	/*
	 * takes in id and displays the SIC with that id
	 */
	public String displayBySICID(int id) { 
		for(int i = 0; i < inventoryArray.size(); i++) { // loops through inventoryArray
			if(id == inventoryArray.get(i).getSICID()) { // checks to see if id is equal to the id at the position of index i
				return inventoryArray.get(i).toString(); // returns the toString method to show the values of SIC
			} 
		}
		return "There is not a card with the SICID you entered\n"; // returns this statement if the card with the entered id doesn't exist
	}
	
	/*
	 *  // takes in author and displays the SIC with that author
	 */
	public String displayByAuthor(String author) {
		String authorHolder; // declares authorHolder
		authorHolder = ""; // initializes authorHolder as an empty String
		
		for(int i = 0; i < inventoryArray.size(); i++) { // loops through inventoryArray
			if(author.equals(inventoryArray.get(i).getAuthor())) { // checks to see if id is equal to the id at the position of index i
				authorHolder = authorHolder + inventoryArray.get(i).toString(); // authorHolder gets whatever was previously in authorHolder and the values of the current index in the invetoryArray through toString()
				return authorHolder; // returns authorHolder
			}
		}
		return "There is not a card with the author you entered\n"; // returns a statement letting the user know there's not a card with the author they typed in if that is the case
	}
	
	/*
	 * takes in title and displays the SIC with that author
	 */
	public String displayByTitle(String title) { 
		String titleHolder; // declares titleHolder
		titleHolder = ""; // initializes titleHolder as an empty String
		
		for(int i = 0; i < inventoryArray.size(); i++) { // loops through inventoryArray
			if(title.equals(inventoryArray.get(i).getTitle())) { // checks to see if id is equal to the id at the position of index i
				titleHolder = titleHolder + inventoryArray.get(i).toString(); // titleHolder gets whatever was previously in titleHolder and the values of the current index in the invetoryArray through toString()
				return titleHolder; // returns titleHolder
			}
		}
		return "There is not a card with the author you entered\n"; // returns a statement letting the user know there's not a card with the title they typed in if that is the case
	}
	
	/*
	 * displays all the StockIndexCards in inventoryArray
	 */
	public String displayAll() {
		String sicHolder; // declares sicHolder
		sicHolder = ""; // initializes sicHolder as an empty String
		
		for(int i = 0; i < inventoryArray.size(); i++) { // loops through inventoryArray
			sicHolder = sicHolder + inventoryArray.get(i).toString();
		}
		return sicHolder;
	}
	
	/*
	 * changes the price of the specified StockIndexCard
	 */
	public void changePrice(int id, double price) {
		for(int i = 0; i < inventoryArray.size(); i++) { // loops through inventoryArray
			if(id == inventoryArray.get(i).getSICID()) { // checks to see if there's a SIC with the inputed ID
				inventoryArray.get(i).changePrice(price); // changes prices
			}
		}
	}
	
	/*
	 * displays the total number of cards in inventoryArray
	 */
	public int totalNumCards() { 
		return inventoryArray.size(); // returns the total number of cards
	}
	
	/*
	 * checks to see whether a card with the entered in ID exists
	 */
	public boolean cardExists(int id) {
		for(int i = 0; i < inventoryArray.size(); i++) { // loops through inventoryArray
			if(id == inventoryArray.get(i).getSICID()) { // checks to see if SIC exists
				return true; // returns true if true
			}
		}
		return false; // returns false if false
	}
	
	/*
	 * returns the quantity of the SIC with the entered in ID
	 */
	public int quantitySize(int id) {
		int idHolder; // declares idHolder
		idHolder = 0; // initializes idHolder to 0
		for(int i = 0; i < inventoryArray.size(); i++) { // loops through inventoryArray
			if(id == inventoryArray.get(i).getSICID()) { // checks to see if ID equals the ID of a stored SIC
				idHolder = inventoryArray.get(i).getSICID(); 
			}
		}
		return idHolder; // returns idHolder
	}
} // end of class InventoryManagement
	