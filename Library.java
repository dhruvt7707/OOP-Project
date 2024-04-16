public class Library {
    public final String Library_name = "My_Library";
    private int numberOfBooks;
    public final int MAX_NUMBER_OF_BOOKS = 2000;
    private Book[] books;
    private int numberOfChemicalEngineeringBooks;
    private int numberOfMechanicalEngineeringBooks;
    private int numberOfComputerEngineeringBooks;
    private int numberOfFictionBooks;
    private int numberOfelectricalengineeringBooks;
    private ChemicalEngineeringBook[] chemicalEngineeringBooks;
    private MechanicalEngineeringBook[] mechanicalEngineeringBooks;
    private ComputerScienceBook[] computerScienceBooks;
    private FictionBook[] fictionBooks;
    private ElectricalEngineeringBook[] electricalEngineeringBooks;
    private Person[] Staff;
    private int numberOfStaffMembers;
    public final Integer MAX_NUMBER_OF_STAFF_MEMBERS = 20;

    Library() {
        this.numberOfBooks = 0;
        this.books = new Book[MAX_NUMBER_OF_BOOKS];
        this.Staff = new Person[MAX_NUMBER_OF_STAFF_MEMBERS];
        this.numberOfStaffMembers = 0;
        this.chemicalEngineeringBooks = new ChemicalEngineeringBook[MAX_NUMBER_OF_BOOKS];
        this.mechanicalEngineeringBooks = new MechanicalEngineeringBook[MAX_NUMBER_OF_BOOKS];
        this.fictionBooks = new FictionBook[MAX_NUMBER_OF_BOOKS];
        this.computerScienceBooks = new ComputerScienceBook[MAX_NUMBER_OF_BOOKS];
        this.electricalEngineeringBooks = new ElectricalEngineeringBook[MAX_NUMBER_OF_BOOKS];
        this.numberOfChemicalEngineeringBooks = 0;
        this.numberOfComputerEngineeringBooks = 0;
        this.numberOfFictionBooks = 0;
        this.numberOfMechanicalEngineeringBooks = 0;
        this.numberOfelectricalengineeringBooks = 0;
    }

    Library(int numberOfBooks, Book[] books, Person[] Staff, Person Librarian, int numberOfStaffMembers) {
        this.numberOfBooks = numberOfBooks;
        this.books = books;
        this.Staff = Staff;
        this.numberOfStaffMembers = numberOfStaffMembers;
        this.chemicalEngineeringBooks = new ChemicalEngineeringBook[MAX_NUMBER_OF_BOOKS];
        this.mechanicalEngineeringBooks = new MechanicalEngineeringBook[MAX_NUMBER_OF_BOOKS];
        this.fictionBooks = new FictionBook[MAX_NUMBER_OF_BOOKS];
        this.computerScienceBooks = new ComputerScienceBook[MAX_NUMBER_OF_BOOKS];
        this.electricalEngineeringBooks = new ElectricalEngineeringBook[MAX_NUMBER_OF_BOOKS];
        this.numberOfChemicalEngineeringBooks = 0;
        this.numberOfComputerEngineeringBooks = 0;
        this.numberOfFictionBooks = 0;
        this.numberOfMechanicalEngineeringBooks = 0;
        this.numberOfelectricalengineeringBooks = 0;
    }
    
    public void addBook(Book book) {
        if (this.numberOfBooks < MAX_NUMBER_OF_BOOKS)
            this.books[this.numberOfBooks++] = book;
        else
            System.out.println("Max book capacity reached");
    }

    public void removeBook(Book book) {
        if ( this.numberOfBooks == 0) {
            return; // Array is empty or null
        }

        int index = -1;
        for (int i = 0; i < this.numberOfBooks; i++) {
            if (this.books[i].getTitle().equals(book.getTitle())) {
                index = i;
                break; // Found the book, no need to continue searching
            }
        }

        if (index == -1) {
            return; // Book not found in the library
        }

        // Shift the elements after the removed book
        for (int i = index; i < this.numberOfBooks - 1; i++) {
            this.books[i] = this.books[i + 1];
        }

        // Set the last element to null to avoid duplication
        this.books[this.numberOfBooks - 1] = null;

        this.numberOfBooks--;
    }

    public String getName() {
        return Library_name;
    }

    public Person[] getStaff() {
        return this.Staff;
    }

    public int getNumberOfBooks() {
        return this.numberOfBooks;
    }

    public int getNumberOfStaffMembers() {
        return this.numberOfStaffMembers;
    }

   

    public void issueBook(Person borrower, Book preference) {
        if (borrower == null || preference == null)
            return;
        int index = -1;
        for (int i = 0; i < this.numberOfBooks; i++) {
            if (this.books[i].getTitle().equals(preference.getTitle()))
                index = i;
        }
        if (index == -1) {
            System.out.println("Sorry, the  book is not available.");
            return;
        }
        if (books[index].isIssued()) {
            System.out.println("Sorry the book is already issued to someone else.");
            return;
        }
        books[index].setIssued(true);
        System.out.println("Book issued successfully ");
    }

    public void returnBook(Person borrower, Book borrowedBook) {
        int index = -1;
        for (int i = 0; i < this.numberOfBooks; i++) {
            if (this.books[i].getTitle().equals(borrowedBook.getTitle())) {
                index = i;
                break;
            }
        }
        this.books[index].setIssued(false);
        System.out.println("Book returned successfully ");
    }

    public void sortBooks() {
        for (int i = 0; i < this.numberOfBooks; i++) {
            if (this.books[i] instanceof ChemicalEngineeringBook) {
                this.chemicalEngineeringBooks[this.numberOfChemicalEngineeringBooks++] = (ChemicalEngineeringBook) this.books[i];
            } else if (this.books[i] instanceof ComputerScienceBook) {
                this.computerScienceBooks[this.numberOfComputerEngineeringBooks++] = (ComputerScienceBook) this.books[i];
            } else if (this.books[i] instanceof FictionBook) {
                this.fictionBooks[this.numberOfFictionBooks++] = (FictionBook) this.books[i];
            } else if (this.books[i] instanceof ElectricalEngineeringBook) {
                this.electricalEngineeringBooks[this.numberOfelectricalengineeringBooks++] = (ElectricalEngineeringBook) this.books[i];
            } else if (this.books[i] instanceof MechanicalEngineeringBook) {
                this.mechanicalEngineeringBooks[this.numberOfMechanicalEngineeringBooks++] = (MechanicalEngineeringBook) this.books[i];
            }
        }
    }

    public Boolean search(Book book) {
        if (book instanceof ChemicalEngineeringBook) {
            for (int i = 0; i < this.numberOfChemicalEngineeringBooks; i++) {
                if (this.chemicalEngineeringBooks[i].getTitle().equals(book.getTitle()))
                    return true;
            }
        } else if (book instanceof FictionBook) {
            for (int i = 0; i < this.numberOfFictionBooks; i++) {
                if (this.fictionBooks[i].getTitle().equals(book.getTitle()))
                    return true;
            }
        } else if (book instanceof MechanicalEngineeringBook) {
            for (int i = 0; i < this.numberOfMechanicalEngineeringBooks; i++) {
                if (this.mechanicalEngineeringBooks[i].getTitle().equals(book.getTitle()))
                    return true;
            }
        } else if (book instanceof ComputerScienceBook) {
            for (int i = 0; i < this.numberOfComputerEngineeringBooks; i++) {
                if (this.computerScienceBooks[i].getTitle().equals(book.getTitle()))
                    return true;
            }
        } else if (book instanceof ElectricalEngineeringBook) {
            for (int i = 0; i < this.numberOfelectricalengineeringBooks; i++) {
                if (this.electricalEngineeringBooks[i].getTitle().equals(book.getTitle()))
                    return true;
            }
        }
        return false;
    }
}
