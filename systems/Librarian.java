package systems;

public class Librarian extends Employee {

    // Constructor
    Librarian (String name, String ID, String phoneNumber, String address, int age, 
    String category, double salary, double overTime, int daysMissed) {
    	// Calling constructor of Employee class
        super(name, ID, phoneNumber, address, age, category, salary, overTime, daysMissed);
    }
    
}
