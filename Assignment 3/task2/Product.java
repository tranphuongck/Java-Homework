package task2;

/**
 * This class tracks the name of products and their respective prices.
 *
 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
 * @version	2021/4/30
 */
public class Product {
	/**Name and price of products in this class*/
	String name;
	int price;
	
	/**
	 * Constructor for the class
	 * 
	 * @param name	Name of product
	 * @param price	Price of product
	 * */
	public Product (String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	/**
	 * Getter for Product.name
	 * 
	 * @return	Name of product
	 * */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Setter for Product.name
	 * 
	 * @param name	Name of product
	 * */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter for Product.price
	 * 
	 * @return	Price of product
	 * */
	public int getPrice() {
		return this.price;
	}
	
	/**
	 * Setter for Product.price
	 * 
	 * @param	Price of product
	 * */
	public void setPrice(int price) {
		this.price = price;
	}
	
}
