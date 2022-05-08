package de.uni_hannover.hci.id98c_41u.task2.hr;

public class IT_Personal extends Employee {
	/**
	 * Extended information for IT personnel including work hours in the week and year joined
	 * */
	private int weekHour;
	private int yearJoined;

	/**
	 * Constructor for the class IT_Personal
	 * 
	 * @param	firstName	Employee's first name
	 * @param	lastName	Employee's last name
	 * @param	rank		Employee's position in company
	 * @param	yearJoined	The year the employee joined
	 * @param	weekHour	Work hours in the week
	 * */
	public IT_Personal(String firstName, String lastName, String rank, int yearJoined, int weekHour) {
		super(firstName, lastName, rank, 0, 22);
		this.weekHour = weekHour;
		this.yearJoined = yearJoined;
		int hourWage = 0;
		int yearWorked = 2021 - this.yearJoined;
		if (rank.equals("Junior")) hourWage = 25;
		else if (rank.equals("Senior")) {
			hourWage = 32 + yearWorked;
			if (yearWorked / 3 <= 5) super.vacation += yearWorked / 3;
			else super.vacation += 5;
		}
		super.monthlyPay = hourWage * weekHour * 4;
	}
	
	/**
	 * Return the information of IT personnel in string format
	 * 
	 * @return	Information in string
	 * */
	@Override
	public String toString() {
		String str = super.lastName + ", " + super.firstName + " (" + super.rank + " Developer): " 
				+ "Weekhours = " + Integer.toString(this.weekHour)
				+ "; Monthly Salary = " + Integer.toString(super.monthlyPay) + " EUR; "
				+ Integer.toString(super.vacation) + " offdays";
		return str;
	}
}
