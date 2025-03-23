package fr.ensai.library;

/**
 * Represents a magazine.
 */
public class Magazine extends Item {

    // Attributes
    private String issn;
    private int issueNumber;

    /**
     * Constructs a new Book object.
     */
    public Magazine(String issn, String title, int issueNumber, int year, int pageCount) {
        super(title, year, pageCount);
        this.issueNumber = issueNumber;
        this.issn = issn;
    }

    @Override
    public String toString() {
        return "Magazine " + title + " issue number " + issueNumber ;
    }
}
