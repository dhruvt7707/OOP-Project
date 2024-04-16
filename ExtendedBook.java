public class ExtendedBook extends Book {

    private String genre; // The genre of the book
    private boolean isCourseBook; // Indicates whether the book is a course book or not

    public ExtendedBook(String title, String subject, String author, boolean isIssued, String genre,
            boolean isCourseBook) {
        super(title, subject, author, isIssued);
        this.genre = genre;
        this.isCourseBook = isCourseBook;
    }

    public ExtendedBook(int id, String title, String subject, String author, boolean isIssued, String genre,
            boolean isCourseBook) {
        super(id, title, subject, author, isIssued);
        this.genre = genre;
        this.isCourseBook = isCourseBook;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isCourseBook() {
        return isCourseBook;
    }

    /**
     * Generates a unique ID by appending the book ID with the first letter of the
     * genre,
     * and "CB" if it's a course book, or "NC" if it's not a course book.
     */
    public String generateUniqueID() {
        String uniqueID = String.valueOf(getBookId()) + genre.charAt(0);
        if (isCourseBook) {
            uniqueID += "CB";
        } else {
            uniqueID += "NC";
        }
        return uniqueID;
    }

}
