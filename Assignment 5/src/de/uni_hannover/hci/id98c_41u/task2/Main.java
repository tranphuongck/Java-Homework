package de.uni_hannover.hci.id98c_41u.task2;
import java.util.Scanner;
import de.uni_hannover.hci.id98c_41u.task2.hr.*;

public class Main {

	public static void main(String[] args) {
		
		Employee[] list = new Employee[100];
		String[] it = {"Junior", "Senior"};
		String[] manager = {"PM", "CEO"};
		int index = 0;
		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter command (new_guard/it/manager, show, or quit): ");
			String[] str = scan.nextLine().split("_");
			if (str[0].equals("new")) {
				if (str[1].equals("guard")) {
					System.out.println("Firstname: ");
					String firstName = scan.nextLine();
					System.out.println("Lastname: ");
					String lastName = scan.nextLine();
					System.out.println("Night shifts (per month): ");
					int nightShift = scan.nextInt();
					System.out.println("Early shifts (per month): ");
					int earlyShift = scan.nextInt();
					System.out.println("Late shifts (per month): ");
					int lateShift = scan.nextInt();
					list[index] = new Security(firstName, lastName, earlyShift, lateShift, nightShift);
					System.out.printf("Added %s, %s to the company. \n", firstName, lastName);
					index += 1;
				}
				else if (str[1].equals("it")) {
					System.out.println("Firstname: ");
					String firstName = scan.nextLine();
					System.out.println("Lastname: ");
					String lastName = scan.nextLine();
					String rank = ConsoleInput.getChoice(it, "Rank (Junior or Senior): ");
					System.out.println("Year joined: ");
					int year = scan.nextInt();
					System.out.println("Weekhours: ");
					int weekHr = scan.nextInt();
					list[index] = new IT_Personal(firstName, lastName, rank, year, weekHr);
					System.out.printf("Added %s, %s to the company. \n", firstName, lastName);
					index += 1;
				}
				else if (str[1].equals("manager")) {
					System.out.println("Firstname: ");
					String firstName = scan.nextLine();
					System.out.println("Lastname: ");
					String lastName = scan.nextLine();
					String rank = ConsoleInput.getChoice(manager, "Rank (PM - Project Manager or CEO): ");
					System.out.println("Project succeeded: ");
					int project = scan.nextInt();
					list[index] = new Management(firstName, lastName, rank, project);
					System.out.printf("Added %s, %s to the company. \n", firstName, lastName);
					index += 1;
				}
				else System.out.println("Invalid rank");
			}			
			else if (str[0].equals("show")) {
				Employee[] printedList = new Employee[index];
				for (int i = 0; i < printedList.length; i++) {
					printedList[i] = list[i];
				}
				for (int i = 0; i < printedList.length; i++) {
					System.out.println(printedList[i].toString());
				}
			}
			else if (str[0].equals("quit")) {
				System.out.println("Exitting programm....");
				scan.close();
				System.exit(1);
			}
			else System.out.println("Invalid input");
		}
	}
}
