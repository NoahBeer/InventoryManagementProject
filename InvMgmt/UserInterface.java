/* 
 *  This class acts as the user interface for the program. It asks the user what he or she
 *  wants to do in the Inventory Management System and sends the tasks to the Inventory
 *  Management System.
 *  
 *  @Noah Beer
 */

import java.util.Scanner; // imports the Scanner class

public class UserInterface { // class
	private Scanner scan; // declares the Scanner object scan
	private InventoryManagement inventoryObject; // declares the InventoryManagement object inventoryObject
	
	public UserInterface() { // UserInterface constructor
		scan =  new Scanner(System.in); // initializes scan to new Scanner(System.in)
		inventoryObject = new InventoryManagement(); // initializes inventoryObject as a new InventoryManagement object
	}
	/*
	 * getUserInfo() runs the entire UserInterface. It calls each method within itself in order to operate each function. It declares the instance
	 * variable userInput which is then inputted by the user
	 */
	public void getUserInfo() { 
		int userInput; // declares userInput
		
		System.out.println("Please select a number from the following options:"); 
		System.out.println("1) Add new Stock Index Card"); 
		System.out.println("2) Remove Stock Index Card"); 
		System.out.println("3) Increase Stock by SIC-ID"); 
		System.out.println("4) Decrease Stock by SIC-ID"); 
		System.out.println("5) Display Stock Index Card by SIC-ID"); 
		System.out.println("6) Display Stock Index Card by Author"); 
		System.out.println("7) Display Stock Index Card by Title"); 
		System.out.println("8) Display All Stock Index Cards"); 
		System.out.println("9) Change Price"); 
		System.out.println("10) Quit"); 
		
		userInput = scan.nextInt(); // prompts user to input an integer based off what they want to do
		
		if(userInput == 1) { // checks to see if userInput is equal to 1
			addCard(); // calls addCard()
		}
		else if(userInput == 2) { // checks to see if userInput is equal to 2
			removeCard(); // calls removeCard()
		}
		else if(userInput == 3) { // checks to see if userInput is equal to 3
			increaseStock(); // calls increaseStock()
		}
		else if(userInput == 4) { // checks to see if userInput is equal to 4
			decreaseStock();  // calls decreaseStock()
		}
		else if(userInput == 5) { // checks to see if userInput is equal to 5
			displayByID();  // calls displayByID()
		}
		else if(userInput == 6) { // checks to see if userInput is equal to 6
			displayByAuthor();  // calls displayByAuthor()
		}
		else if(userInput == 7) { // checks to see if userInput is equal to 7
			displayByTitle();  // calls displayByTitle()
		}
		else if(userInput == 8) { // checks to see if userInput is equal to 8
			displayAll(); // calls displayAll()
		}
		else if(userInput == 9) { // checks to see if userInput is equal to 9
			changePrice(); // calls changePrice()
		}
		else if(userInput == 10) { // checks to see if userInput is equal to 10
			System.out.println("Thank you for using our invetory management system. Good bye"); // print statement
		}
		else {
			System.out.println("\nError! You must enter a number between 1 and 10. Please re-enter your command:\n"); //print statement
			getUserInfo(); // calls getUserInfo()
		}
	}
	/* 
	 * addCard() adds a StockIndexCard to inventoryArray.
	 * Declares the instance variables sic_idHolder, titleHolder, authorHolder, priceHolder, and quantityHolder then initializes those instance
	 * variables to whatever the user enters as an input
	 */
	private void addCard() { 
		int sic_idHolder; // declares sic_idHolder
		String titleHolder; // declares titleHolder
		String authorHolder; // declares authorHolder
		double priceHolder; // declares priceHolder
		int quantityHolder; // declares quantityHolder
		
		
		System.out.println("Making a new card:\nPlease enter the new SIC-ID: ");
		sic_idHolder = scan.nextInt(); // prompts user to input the ID
		scan.nextLine();
		
		if(inventoryObject.cardExists(sic_idHolder) != true) {
			System.out.println("Please enter the title of the book: ");
			titleHolder = scan.next(); // prompts user to input the title
			scan.nextLine();
			System.out.println("Please enter the author of the book");
			authorHolder = scan.next(); // prompts user to input the author
			scan.nextLine();
			System.out.println("Please enter the price of the book");
			priceHolder = scan.nextDouble(); // prompts user to input the price
			scan.nextLine();
		
			if(priceHolder < 0) { // checks to make sure priceHolder is positive
				System.out.println("ERROR! Price must be greater than or equal to 0:");
				getUserInfo();
		}
		
		System.out.println("Please enter the number of books in invetory");
		quantityHolder = scan.nextInt(); // prompts user to input the quantity
		scan.nextLine();
		
		if(quantityHolder <= 0) { // checks to make sure quantity isn't less than 1
			System.out.println("Error! Quantity must be greater than 0\n"); 
			getUserInfo();
		}
		inventoryObject.addStockIndexCard(sic_idHolder, titleHolder, authorHolder, priceHolder, quantityHolder); // calls addStockIndexCard from InventoryManagement
		getUserInfo();
		}
		else {
			System.out.println("ERROR: The ID you entered is already in the system\n");
			getUserInfo();
		}
	}
	
	/*
	 * removeCard() removes the specified card from inventoryArray that is inputed by the user and stored as int sic_idHolder
	 */
	private void removeCard() {
		int sic_idHolder; // declares sic_idHolder
		
		System.out.println("Please enter the SIC ID number you'd like to remove:");
		sic_idHolder = scan.nextInt(); // prompts user to input sic_idHolder
		scan.nextLine();
		
		inventoryObject.removeStockIndexCard(sic_idHolder); //calls removeStockIndexCard from InventoryManagement
		getUserInfo();
	}
	
	/*
	 * increaseStock() increases the quantity by int increaseBy of the specified card from inventoryArray that is inputed by 
	 * the user and stored as int sic_idHolder
	 */
	private void increaseStock() {
		int increaseBy; // declares declares increaseBy
		int sic_idHolder; // declares sic_idHolder
		
		System.out.println("Please enter the SIC-ID of the card you wish to edit:");
		sic_idHolder = scan.nextInt();
		scan.nextLine();
		
		if(inventoryObject.cardExists(sic_idHolder)) { // checks to see if the card with the inputed ID exists
			System.out.println("Please enter the amount you wish to increase the stock by:");
			increaseBy = scan.nextInt();
			if(increaseBy <= 0) {
				System.out.println("Error! You must increase the stock by 1 or more\n");
				getUserInfo();
			}
			
			inventoryObject.increaseStock(sic_idHolder, increaseBy); // calls increaseStock in InventoryManagement
			getUserInfo();
		}
		else {
			System.out.println("There are no cards with the ID you entered\n");
			getUserInfo();
		}
		
		
	}
	
	/*
	 * decreaseStock() decreases the quantity by int decreaseBy of the specified card from inventoryArray that is inputed by 
	 * the user and stored as int sic_idHolder
	 */
	private void decreaseStock() {
		int decreaseBy; // declares decreaseBy
		int sic_idHolder; // declares sic_idHolder
		
		System.out.println("Please enter the SIC-ID of the card you wish to edit:");
		sic_idHolder = scan.nextInt();
		scan.nextLine();

		if(inventoryObject.cardExists(sic_idHolder)) { // checks to see if the card with the inputed ID exists
		System.out.println("Please enter the amount you wish to decrease the stock by (Note: This should be a positive number):");
		decreaseBy = scan.nextInt();
		scan.nextLine();
		
		if(decreaseBy <= 0) { //checks to see is decrease by is negative
			System.out.println("Error! You must decrease the stock by 1 or more\n");
			getUserInfo();
		}
		if(inventoryObject.quantitySize(sic_idHolder) - decreaseBy < 0 ) { // checks to see if the current quantity minus decreasedBy is negative
			System.out.println("Error. Quantity can not be reduced to a negative number\n");
			getUserInfo();
		}
		inventoryObject.decreaseStock(sic_idHolder, decreaseBy); // calls decreaseStock in InventoryManagement
		getUserInfo();
		}
		else {
			System.out.println("There are no cards with the ID you entered\n");
			getUserInfo();
		}
	}
	
	/*
	 * Displays the StockIndexCard of the inputed sic_idHolder
	 */
	private void displayByID() { 
		int sic_idHolder; // declares sic_idHolder
		
		System.out.println("Please enter the SIC-ID of the book you would like displayed:");
		sic_idHolder = scan.nextInt();
		scan.nextLine();
		System.out.println(inventoryObject.displayBySICID(sic_idHolder));
		getUserInfo();
	}
	
	/*
	 * Displays the StockIndexCard of the inputed author
	 */
	private void displayByAuthor() {
		String authorHolder; // declares authorHolder
		
		System.out.println("Please enter author of the book you would like displayed:");
		authorHolder = scan.next();
		scan.nextLine();
		System.out.println(inventoryObject.displayByAuthor(authorHolder));
		getUserInfo();
	}
	
	/*
	 * Displays the StockIndexCard of the inputed title
	 */
	private void displayByTitle() {
		String titleHolder; // declares titleHolder
		
		System.out.println("Please enter title of the book you would like displayed:");
		titleHolder = scan.next();
		scan.nextLine();
		System.out.println(inventoryObject.displayByTitle(titleHolder));
		getUserInfo();
	}
	
	/*
	 * Displays all StockIndexCards
	 */
	private void displayAll() {
		if(inventoryObject.totalNumCards() == 0) { // checks to see if there are 0 StockIndexCards
			System.out.println("The Inventory is empty\n");
			getUserInfo();
		}
		else {
		System.out.println(inventoryObject.displayAll());
		getUserInfo();
		}
	}
	
	/*
	 * Changes the price of the specified StockIndexCard by sic_idHolder
	 */
	private void changePrice() {
		int sic_idHolder; // declares sic_idHolder
		double priceHolder; // declares priceHolder
		
		System.out.println("Please enter the SIC-ID of the book you'd like to change the price of:");
		sic_idHolder = scan.nextInt();
		scan.nextLine();
		
		if(inventoryObject.cardExists(sic_idHolder)) { // checks to see if card exists
			System.out.println("Please enter the new price of the book:");
			priceHolder = scan.nextDouble();
			scan.nextLine();
			if(priceHolder < 0) { // checks to see if priceHolder is negative
				System.out.println("The price cannot be below zero\n");
				getUserInfo();
			}
			inventoryObject.changePrice(sic_idHolder, priceHolder);
			getUserInfo();
		}
		else {
			System.out.println("The ID you entered does not exist\n");
			getUserInfo();
		}
	}
} // class end

	
	

