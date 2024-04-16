public class FictionBook extends ExtendedBook {
    public FictionBook(String title, String subject, String author, boolean isIssued) {
        super(title, subject, author, isIssued, "Fiction", false);
    }
}