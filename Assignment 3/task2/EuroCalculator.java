package task2;

/**
 * This class provides Methods to calculate payment and give back changes.
 *
 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
 * @version	2021/4/30
 */
public class EuroCalculator {
	/**Array of payment in EuroDenomination format*/
	EuroDenomination[] payment;
	/**Payment after calculated to cent*/
	int paymentInt;
	/**Cost of the purchase*/
	int cost;
	
	/**Constructor method for the class
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @param payment	Payment in EuroDenomination format
	 * @param cost	Cost of the purchase
	 */
	public EuroCalculator(EuroDenomination[] payment, int cost) {
		this.payment = payment;
		this.cost = cost;
		for (int j = 0; j < payment.length; j++) {
			this.paymentInt += payment[j].CentValue();
		}
		if (this.paymentInt < this.cost) {
			System.out.println("Payment not enough. Exitting....");
			System.exit(1);
		}
	}
	
	/**
	 * This method returns the amount of changes a customer would receive after a transaction.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com> 
	 * */
	public void Change() {
		int value = this.paymentInt - this.cost;
		EuroDenomination[] change = new EuroDenomination[100];
		int i = 0;
		while (value >= 1) {
			if (value >= 20000) {
				change[i] = EuroDenomination.EURO_200;
				value -= 20000;
			}
			else if (value >= 10000) {
				change[i] = EuroDenomination.EURO_100;
				value -= 10000;
			}
			else if (value >= 5000) {
				change[i] = EuroDenomination.EURO_50;
				value -= 5000;
			}
			else if (value >= 2000) {
				change[i] = EuroDenomination.EURO_20;
				value -= 2000;
			}
			else if (value >= 1000) {
				change[i] = EuroDenomination.EURO_10;
				value -= 1000;
			}
			else if (value >= 500) {
				change[i] = EuroDenomination.EURO_5;
				value -= 500;
			}
			else if (value >= 200) {
				change[i] = EuroDenomination.EURO_2;
				value -= 200;
			}
			else if (value >= 100) {
				change[i] = EuroDenomination.EURO_1;
				value -= 100;
			}
			else if (value >= 50) {
				change[i] = EuroDenomination.CENT_50;
				value -= 50;
			}
			else if (value >= 20) {
				change[i] = EuroDenomination.CENT_20;
				value -= 20;
			}
			else if (value >= 10) {
				change[i] = EuroDenomination.CENT_10;
				value -= 10;
			}
			else if (value >= 5) {
				change[i] = EuroDenomination.CENT_5;
				value -= 5;
			}
			else if (value >= 2) {
				change[i] = EuroDenomination.CENT_2;
				value -= 2;
			}
			else {
				change[i] = EuroDenomination.CENT_1;
				value -= 1;
			}
			i += 1;
		}
		
		//Copy change to new array
		EuroDenomination[] result = new EuroDenomination[i];
		for (int j = 0; j < result.length; j++) {
			result[j] = change[j];
		}
		
		System.out.printf("Total price: %d (Cents) \n", this.cost);
		System.out.printf("Total payment: %d (Cents) \n", this.paymentInt);
		System.out.printf("Changes: %d (Cents) \n", this.paymentInt - this.cost);
		//Print out this new array
		System.out.print(EuroDenomination.Payment(result));
	}
		
}
