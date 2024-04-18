package systems;
import general_classes.*;

public class Employee_System implements categoryDetails {
	
	// Variables
	protected static Employee[] librarians;   
	protected static int numberOfEmployees;
	protected int[] penalties;
	Administrator admin;
	
	
	// Constructor
	Employee_System(Employee[] emps) {
		// First employee in array is Admin
		Employee e = emps[0];
		admin = new Administrator(e.getName(), e.getID(), e.getPhoneNumber(), e.getAddress(), e.getAge(), 
				e.getCategory(), e.getSalary(), e.getOverTime(), e.getDaysMissed());
		
		// Initialising 
		numberOfEmployees = emps.length;
		penalties = new int[numberOfEmployees-1];
		
		// Adding rest of employees as librarians to array
		for (int i = 0 ; i < numberOfEmployees-1 ; i++) {
			librarians[i] = emps[i+1];
		}
	}
	
	
	// Methods
	public boolean addEmployee(Employee e) {
		return admin.addEmployee(e);
	}
	
	public boolean removeEmployee(Employee e) {
		return admin.removeEmployee(e.getID());
	}
	
	// Employee of the Month is employee with most overtime
	public Employee employeeOfTheMonth() {
		double max = -1;
		Employee winner = null;
		// Claculating max overTime
		for (int i = 0 ; i < numberOfEmployees-1 ; i++) {
			if (librarians[i].getOverTime() > max) {
				winner = librarians[i];
				max = librarians[i].getOverTime();
			}
		}
		// Returning
		return winner;
	}
	
	// Calculating total Salary to be distributed
	public double salary() {
		// Admin Salary
		double money = admin.getSalary() + admin.calcExtraPay();
		// Librarians Salary
		for (int i = 0 ; i < numberOfEmployees-1 ; i++) {
			money += librarians[i].getSalary() + librarians[i].calcExtraPay() - penalties[i];   
		}
		// Returning
		return money;
	}
	
	// Marking attendance and calculating salary penalties for extra leaves
	public void markAttendance(String[] attendance) {
		// Iterating through all librarians
		for (int j = 0 ; j < numberOfEmployees-1 ; j++) {
			boolean isPresent = false;
			// Iterating through list of ID numbers marked for attendance
			for (int i = 0 ; i < attendance.length ; i++) {
				if(librarians[j].getID().equals(attendance[i])) {
					isPresent = true;
					break;
				}
			}
			// If librarian on leave and has exceeded max allowed leaves
			if (!isPresent && !librarians[j].leave()) penalties[j] += 500;
		}
	}
	
}
