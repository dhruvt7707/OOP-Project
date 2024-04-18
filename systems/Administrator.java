package systems;
import general_classes.*;

public class Administrator extends Employee {

    // Constructor
    Administrator (String name, String ID, String phoneNumber, String address, int age, 
    String category, double salary, double overTime, int daysMissed) {
    	// Calling constructor of Employee class
        super(name, ID, phoneNumber, address, age, category, salary, overTime, daysMissed);
    }

   // Admin exclusive methods
   public void displayEmployeeDetails(Employee[] emp) {
	   System.out.println("Employee(s) Detail(S) are: ");
	   for(Employee e: emp) {
		   if (e == null) continue;
		   e.printDetails();
		   System.out.println("");
	   }
   }
   
   public boolean removeEmployee(String ID) {
	   // Employee found
	   for (int i = 0 ; i < Employee_System.numberOfEmployees ; i++) {
		   if (Employee_System.librarians[i].getID().equals(ID)) {
			   for ( ; i < Employee_System.numberOfEmployees-1 ; i++) {
				   Employee_System.librarians[i] = Employee_System.librarians[i+1];
			   }
			   Employee_System.numberOfEmployees--;
			   return true;
		   }
	   }
	   // Employee not found
	   return false;
   }
   
   public boolean addEmployee(Employee e) {
	   // Checking if criteria met
	   if (e.getAge() >= 18 && Employee_System.numberOfEmployees < categoryDetails.MAX_TOTAL_EMPLOYEES) {
		   Employee_System.librarians[Employee_System.numberOfEmployees] = e;
		   Employee_System.numberOfEmployees++;
		   return true;
	   }
	   // Library at max capacity
	   return false;
   }
    
}
