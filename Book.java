import java.util.Scanner;

public abstract class Book {

    private int bookId;
    private String title;
    private String subject;
    private String author;
    private boolean isIssued;

    private static int currentIdNumber = 1;

    public Book(String title, String subject, String author, boolean isIssued) {
        this.bookId = currentIdNumber++;
        this.title = title;
        this.subject = subject;
        this.author = author;
        this.isIssued = isIssued;
    }

    public Book(int id, String title, String subject, String author, boolean isIssued) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid book ID");
        }
        this.bookId = id;
        this.title = title;
        this.subject = subject;
        this.author = author;
        this.isIssued = isIssued;
        currentIdNumber = Math.max(currentIdNumber, id + 1);
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    public void returnBook() {
        this.isIssued = false;
    }

    public abstract String getGenre();

    public abstract String generateUniqueID();

    public void updateBookInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter new title:");
        this.title = scanner.nextLine();

        System.out.println("Enter new subject:");
        this.subject = scanner.nextLine();

        System.out.println("Enter new author:");
        this.author = scanner.nextLine();

        System.out.println("Is the book issued? (true/false):");
        this.isIssued = scanner.nextBoolean();

        // Consume newline character after reading boolean input
        scanner.nextLine();

        // Close the scanner to release resources
        scanner.close();
    }

}
