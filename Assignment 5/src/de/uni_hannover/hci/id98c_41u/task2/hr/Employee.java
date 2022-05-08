package de.uni_hannover.hci.id98c_41u.task2.hr;

public abstract class Employee {
	/**
	 * Basic information for employees including name, rank, monthly payment and vacation
	 * */
	protected String firstName;
	protected String lastName;
	protected String rank;
	protected int monthlyPay;
	protected int vacation;
	
	
	/**
	 * Constructor for the class Employee
	 * 
	 * @param	firstName	Employee's first name
	 * @param	lastName	Employee's last name
	 * @param	rank		Employee's position in company
	 * @param	monthlyPay	Monthly salary
	 * @param	vacation	Vacation days in one year
	 * */
	public Employee (String firstName, String lastName, String rank, int monthlyPay, int vacation) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.rank = rank;
		this.monthlyPay = monthlyPay;
		this.vacation = vacation;
	}
	
	
	/**
	 * Return the basic information of employee in string format
	 * This method is meant to be overridden 
	 * 
	 * @return	Information in string
	 * */
	public String toString() {
		String str = this.lastName + ", " + this.firstName + " (" + this.rank + "): ";
		return str;
	}
}
