package API;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The {@code Review} class represents a review for a particular entity.
 * It is mapped to the "reviews" table in the database.
 *
 * @author Team1
 * @version 1.0
 */
@Entity
@Table(name = "reviews")
public class Review {

    /**
     * The unique identifier for the review.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The textual content of the review.
     */
    @Column(name = "textual_review", nullable = false)
    private String textualReview;

    /**
     * The numerical rating assigned to the entity in the review.
     */
    @Column(name = "numerical_rating", nullable = false)
    private int numericalRating;

    /**
     * Additional comments provided in the review.
     */
    @Column(name = "comments", nullable = true)
    private String comments;

    /**
     * Default constructor for the {@code Review} class.
     */
    public Review() {
    }

    /**
     * Parameterized constructor for the {@code Review} class.
     *
     * @param textualReview   The textual content of the review.
     * @param numericalRating The numerical rating assigned to the entity in the review.
     * @param comments        Additional comments provided in the review.
     */
    public Review(String textualReview, int numericalRating, String comments) {
        this.textualReview = textualReview;
        this.numericalRating = numericalRating;
        this.comments = comments;
    }

    /**
     * Get the unique identifier for the review.
     *
     * @return The unique identifier for the review.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique identifier for the review.
     *
     * @param id The unique identifier for the review.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the textual content of the review.
     *
     * @return The textual content of the review.
     */
    public String getTextualReview() {
        return textualReview;
    }

    /**
     * Set the textual content of the review.
     *
     * @param textualReview The textual content of the review.
     */
    public void setTextualReview(String textualReview) {
        this.textualReview = textualReview;
    }

    /**
     * Get the numerical rating assigned to the entity in the review.
     *
     * @return The numerical rating assigned to the entity in the review.
     */
    public int getNumericalRating() {
        return numericalRating;
    }

    /**
     * Set the numerical rating assigned to the entity in the review.
     *
     * @param numericalRating The numerical rating assigned to the entity in the review.
     */
    public void setNumericalRating(int numericalRating) {
        this.numericalRating = numericalRating;
    }

    /**
     * Get additional comments provided in the review.
     *
     * @return Additional comments provided in the review.
     */
    public String getComments() {
        return comments;
    }

    /**
     * Set additional comments provided in the review.
     *
     * @param comments Additional comments provided in the review.
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
}

