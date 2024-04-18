package general_classes;

public interface categoryDetails {  
	
	// Interface containing all constant field values
	
	// max TOTAL EMPLOYEES in library
	int MAX_TOTAL_EMPLOYEES = 20;
	
	// MISSED DAYS for employees 		( check when applying for leave )
	int MAX_MISSED_ADMIN = 7;
	int MAX_MISSED_LIBRARIAN = 5;
		
	// SALARY for employees 			( check when making new Employee )
	int MAX_SALARY_ADMIN = 500000;
	int MAX_SALARY_LIBRARIAN = 100000;
		
	// max number of BOOKS ISSUED		( check when issuing books )
	int MAX_BOOKS_STUDENT = 2;
	int MAX_BOOKS_EMPLOYEE = 3;
	int MAX_BOOKS_FACULTY = 5;
	
	// max ISSUE period					( current date - issue date )
	int MAX_PERIOD_STUDENT = 1;
	int MAX_PERIOD_EMPLOYEE = 2;
	int MAX_PERIOD_FACULTY = 4;
	
}
