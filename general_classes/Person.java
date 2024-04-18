package general_classes;

public abstract class Person {
	
	// Variables
    private String name;
    private String ID;
    private String phoneNumber;
    private String address;
    private int age;
    private String category;
    private int booksIssued;

 
    // Constructor
    public Person(String name, String ID, String phoneNumber, String address, int age, String category, int booksIssued) {
        this.name = name;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.age = age;
        this.category = category;
        this.booksIssued = booksIssued;
    }

 // Method to print details
    public void printDetails() {
    	System.out.println("-------------------------------------------");
        System.out.println("Details of Person: " + name + " are: ");
        System.out.println("ID: " + ID);
        System.out.println("Address: " + address);
        System.out.println("Age: " + age);
        System.out.println("Category: " + category);
        System.out.println("Books Issued: " + booksIssued);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("-------------------------------------------");
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }
    
    public String getPhoneNumber() {
    	return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getCategory() {
        return category;
    }

    public int getBooksIssued() {
        return booksIssued;
    }
    
    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public void setPhoneNumber(String phoneNumber) {
    	this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBooksIssued(int booksIssued) {
        this.booksIssued = booksIssued;
    }

}

