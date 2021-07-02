package task2;

/**
 * This enum simulates all the currently available Euro bills.
 *
 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
 * @version	2021/4/30
 */
public enum EuroDenomination {
	/**All the simulated Euro bills in the format NAME(Value in Cent).*/
	CENT_1(1), CENT_2(2), CENT_5(5), CENT_10(10), CENT_20(20), CENT_50(50), 
	EURO_1(100), EURO_2(200), EURO_5(500), EURO_10(1000), EURO_20(2000), EURO_50(5000), EURO_100(10000), EURO_200(20000);
	
	/**Represents the value in cents of the constant.*/
	public final int value;
	
	/**Constructor for enum
	 * @author Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @param value Value of the enum
	 */
	EuroDenomination(int value) {
		this.value = value;
	}
	
	/**This Method returns the value of enum in Cents.
	 * @author Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @return	Cent value
	 */
	public int CentValue() {
		return this.value;
	}
	
	/**This Method returns the Payment in String format.
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @param payment	The array of payment to be converted to String
	 * @return	String format of payment
	 * */
	public static String Payment(EuroDenomination[] payment) {
		String str = "Give back change: ";
		for (int a = 0; a < payment.length; a++) {
			str += payment[a].name();
			if (a < payment.length - 1) str += ", ";
		}
		str += "\n";
		return str;
	}

}
