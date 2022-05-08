package de.uni_hannover.hci.id98c_41u.task2.hr;

public class Management extends Employee {
	/**
	 * Extended information for management personnel including succeeded projects
	 * */
	private int successProject;

	
	/**
	 * Constructor for the class IT_Personal
	 * 
	 * @param	firstName	Employee's first name
	 * @param	lastName	Employee's last name
	 * @param	rank		Employee's position in company
	 * @param	successProject	Number of projects the employee has succeeded
	 * */
	public Management(String firstName, String lastName, String rank, int successProject) {
		super(firstName, lastName, rank, 0, 20);
		this.successProject = successProject;
		if (rank.equals("PM")) {
			super.monthlyPay = 8000;
		}
		else if (rank.equals("CEO")) {
			super.monthlyPay = 10000;
		}
		double payModifier = super.monthlyPay * successProject * 0.1;
		int payIncrease = (int) Math.round(payModifier);
		super.monthlyPay += payIncrease;
		super.vacation += successProject * 2;
	}
	
	/**
	 * Return the information of management personnel in string format
	 * 
	 * @return	Information in string
	 * */
	@Override
	public String toString() {
		String str = super.lastName + ", " + super.firstName + " (" + super.rank + "): " 
				+ "Successful Projects: " + Integer.toString(this.successProject)
				+ "; Monthly Salary = " + Integer.toString(super.monthlyPay) + " EUR; "
				+ Integer.toString(super.vacation) + " offdays";
		return str;
	}
}
