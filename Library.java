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

    public final Integer MAX_NUMBER_OF_STAFF_MEMBERS = 20;

    Library() {
        this.numberOfBooks = 0;
        this.books = new Book[MAX_NUMBER_OF_BOOKS];
       
        
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

    public ChemicalEngineeringBook[] getChemicalEngineeringBooks() {
        return chemicalEngineeringBooks;
    }

    public ElectricalEngineeringBook[] getElectricalEngineeringBooks() {
        return electricalEngineeringBooks;
    }

    public MechanicalEngineeringBook[] getMechanicalEngineeringBooks() {
        return mechanicalEngineeringBooks;
    }

    public ComputerScienceBook[] getComputerScienceBooks() {
        return this.computerScienceBooks;
    }

    public FictionBook[] getFictionBooks() {
        return this.fictionBooks;
    }

    class BookBank {
        final int quota = 200;
        int number_of_book_bank_books;
        Book[] book_bank_books;
        int number_of_books_allocated;
        Person[] Borrower;
        Book[] borrowedBooks;
        final int max_number_of_borrowers = 20;

        BookBank() {
            this.number_of_books_allocated = 0;
            this.book_bank_books = new Book[this.quota];
            this.borrowedBooks = new Book[this.quota];
            this.Borrower = new Person[this.max_number_of_borrowers];
            this.number_of_book_bank_books = 0;
        }

        public void setBookBankBooks(Book... books) {
            for (int i = 0; i < books.length; i++) {
                this.book_bank_books[i] = books[i];
            }
            this.number_of_book_bank_books = books.length;
        }

        public void giveBook(Person student, Book preference) {
            int index = -1;
            for (int i = 0; i < this.book_bank_books.length; i++) {
                if (this.book_bank_books[i] == null)
                    break;
                if (this.book_bank_books[i].getTitle().equals(preference.getTitle())) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("Sorry Book not available");
                return;
            }
            for (int i = index; i < this.number_of_book_bank_books - 1; i++) {
                this.book_bank_books[i] = this.book_bank_books[i + 1];
            }
            this.book_bank_books[this.number_of_book_bank_books - 1] = null;
            this.borrowedBooks[this.number_of_books_allocated++] = preference;
            System.out.println("Book successfully allocated");
        }

        public void returnBook(Person student, Book book) {
            boolean found = false;
            int i;
            int index = 0;
            for (i = 0; i < this.borrowedBooks.length; i++) {
                if (this.borrowedBooks[i] == null)
                    break;
                if (this.borrowedBooks[i].getTitle().equals(book.getTitle())) {
                    found = true;
                    index = i;
                    break;
                }
            }
            if (found) {
                book_bank_books[number_of_book_bank_books++] = borrowedBooks[index];
                while (index < this.number_of_books_allocated) {
                    borrowedBooks[index] = borrowedBooks[++index];
                }
                number_of_books_allocated--;
            }
        }
    }

    public void addBook(Book book) {
        if (this.numberOfBooks < MAX_NUMBER_OF_BOOKS)
            this.books[this.numberOfBooks++] = book;
        else
            System.out.println("Max book capacity reached");
    }

    public void removeBook(Book book) {
        if (this.numberOfBooks == 0) {
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



    public int getNumberOfBooks() {
        return this.numberOfBooks;
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
