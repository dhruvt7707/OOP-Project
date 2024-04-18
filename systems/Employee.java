package systems;
import general_classes.*;

public class Employee extends Person implements categoryDetails{
	
	// Variables common to each Employee
    private double salary;
    private double overTime;
    private int daysMissed;
    boolean onLeave; // set to true at start of each new day
    
    
    // Constructor 
	public Employee(String name, String ID, String phoneNumber, String address, int age, 
	String category, double salary, double overTime, int daysMissed) {
		// Calling constructor of Person class
		super(name, ID, phoneNumber, address, age, category, 0);
		// Initializing variables
		this.salary = salary;
        this.overTime = overTime;
        this.daysMissed = daysMissed;
	}
	
	
	// Methods common to all Employees
	public double calcExtraPay() {
		if (this instanceof Administrator) {
			if (overTime*1000 + salary <= categoryDetails.MAX_SALARY_ADMIN) return overTime*1000;
			else return categoryDetails.MAX_SALARY_ADMIN-salary;
		}
		else {
			if (overTime*500 + salary <= categoryDetails.MAX_SALARY_LIBRARIAN) return overTime*500;
			else return categoryDetails.MAX_SALARY_LIBRARIAN-salary;
		}
	}
	
	public boolean leave(){
		this.daysMissed++;
		if (this instanceof Administrator && this.daysMissed <= categoryDetails.MAX_MISSED_ADMIN) return true;
		else if (this.daysMissed <= categoryDetails.MAX_MISSED_LIBRARIAN) return true;
		return false;
	}
	
	// Getter and Setter methods for employee-specific attributes
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getOverTime() {
        return overTime;
    }

    public void setOverTime(double overTime) {
        this.overTime = overTime;
    }

    public int getDaysMissed() {
        return daysMissed;
    }

    public void setDaysMissed(int daysMissed) {
        this.daysMissed = daysMissed;
    }
	
}
