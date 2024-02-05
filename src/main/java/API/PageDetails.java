package API;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The {@code PageDetails} class represents information about a paper.
 * It is mapped to the "paperdetail" table in the database.
 *
 * @author Team1
 * @version 1.0
 */
@Entity
@Table(name = "paperdetail")
public class PageDetails {

    /**
     * The unique identifier for the paper.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long PaperID;

    /**
     * The domain of the paper.
     */
    @Column(name = "domain_of_paper", nullable = false)
    private String DomainOfPaper;

    /**
     * Default constructor for the {@code PageDetails} class.
     */
    public PageDetails() {
    }

    /**
     * Parameterized constructor for the {@code PageDetails} class.
     *
     * @param domainOfPaper The domain of the paper.
     */
    public PageDetails(String domainOfPaper) {
        DomainOfPaper = domainOfPaper;
    }

    /**
     * Get the paper's unique identifier.
     *
     * @return The unique identifier for the paper.
     */
    public long getPaperID() {
        return PaperID;
    }

    /**
     * Set the paper's unique identifier.
     *
     * @param paperID The unique identifier for the paper.
     */
    public void setPaperID(long paperID) {
        PaperID = paperID;
    }

    /**
     * Get the domain of the paper.
     *
     * @return The domain of the paper.
     */
    public String getDomainOfPaper() {
        return DomainOfPaper;
    }

    /**
     * Set the domain of the paper.
     *
     * @param domainOfPaper The domain of the paper.
     */
    public void setDomainOfPaper(String domainOfPaper) {
        DomainOfPaper = domainOfPaper;
    }
}
