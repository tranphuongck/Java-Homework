package task2;

/**
 * The main class of money calculator programm.
 *
 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
 * @version	2021/4/30
 */
public class Main {

	public static void main(String[] args) {
		EuroDenomination[] allPayOpt = EuroDenomination.values();
		
		/**List of available products and their prices*/
		Product products[] = new Product[10];
		products[0] = new Product("Cheese", 230);
		products[1] = new Product("Bread", 110);
		products[2] = new Product("Egg", 90);
		products[3] = new Product("IceCream", 399);
		products[4] = new Product("Beer", 249);
		products[5] = new Product("Milk", 174);
		products[6] = new Product("Ham", 349);
		products[7] = new Product("Pringles", 524);
		products[8] = new Product("Pasta", 99);
		products[9] = new Product("Butter", 124);
		
		/**List of product names*/
		String[] prodName = new String[products.length];
		for (int i = 0; i < prodName.length; i++) {
			prodName[i] = products[i].getName();
		}
		
		/**List of available payment options*/
		String[] money = {"EURO_200", "EURO_100", "EURO_50", "EURO_20", "EURO_10", "EURO_5", "EURO_2", "EURO_1", 
				"CENT_50", "CENT_20", "CENT_10", "CENT_5", "CENT_2", "CENT_1"};
		
		/**Customer's purchase and their payment*/
		String[] choice = ConsoleInput.getMultipleChoices(prodName, "Available products: ");	
		String[] payment = ConsoleInput.getMultipleChoices(money, "Choose your payment: ");
		
		/**Customer's payment in EuroDenomination format*/
		EuroDenomination[] edPayment = new EuroDenomination[payment.length];
		for (int i = 0; i < payment.length; i++) {
			for (int j = 0; j < allPayOpt.length; j++) {
				if (payment[i].equals(allPayOpt[j].name())) {
					edPayment[i] = allPayOpt[j];
				}
			}
		}
		
		/**Price of the purchase in cent*/
		int price = 0;
		
		for (int j = 0; j < choice.length; j++) {
			for (int i = 0; i < products.length; i++) {
				if (products[i].getName().equals(choice[j])) {
					price += products[i].getPrice();
				}
			}
		}
		
		/**Calculate and give back changes*/
		EuroCalculator transaction = new EuroCalculator(edPayment, price);
		transaction.Change();
	}
}
