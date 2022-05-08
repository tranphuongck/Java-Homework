package de.uni_hannover.hci.id98c_41u.task2.hr;

public class Security extends Employee {
	/**
	 * Extended information for security personnel including number of early, late and night shifts
	 * */
	private int earlyShift;
	private int lateShift;
	private int nightShift;
	
	/**
	 * Constructor for the class Security
	 * 
	 * @param	firstName	Employee's first name
	 * @param	lastName	Employee's last name
	 * @param	earlyShift	Number of early shifts in the month
	 * @param	lateShift	Number of late shifts in the month
	 * @param	nightShift	Number of night shifts in the month
	 * */
	public Security(String firstName, String lastName, int earlyShift, int lateShift, int nightShift) {
		super(firstName, lastName, "Guard", 0, 20);
		this.earlyShift = earlyShift;
		this.lateShift = lateShift;
		this.nightShift = nightShift;
		super.monthlyPay = (earlyShift + lateShift) * 100 + nightShift * 160;
		double addVacation = (earlyShift + lateShift + nightShift)/4;
		int vacation = (int) Math.round(addVacation);
		super.vacation += vacation;
	}
	
	/**
	 * Return the information of security personnel in string format
	 * 
	 * @return	Information in string
	 * */
	@Override
	public String toString() {
		String str = super.lastName + ", " + super.firstName + " (" + super.rank + "): " + 
				"Shifts " + Integer.toString(this.earlyShift) + "/" + Integer.toString(this.lateShift) + "/" + Integer.toString(this.nightShift) + "; "
				+ "Monthly Salary = " + Integer.toString(super.monthlyPay) + " EUR; "
				+ Integer.toString(super.vacation) + " offdays";
		return str;
	}
}
