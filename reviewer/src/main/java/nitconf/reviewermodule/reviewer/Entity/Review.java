package nitconf.reviewermodule.reviewer.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tectual_review", nullable= false)
    private String textualReview;

    @Column(name= "numerical_rating", nullable = false)
    private int numericalRating;

    @Column(name ="comments", nullable = true)
    private String comments;


    
    
    public Review() {
    }
    
    public Review(String textualReview, int numericalRating, String comments) {
        this.textualReview = textualReview;
        this.numericalRating = numericalRating;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTextualReview() {
        return textualReview;
    }
    public void setTextualReview(String textualReview) {
        this.textualReview = textualReview;
    }
    public int getNumericalRating() {
        return numericalRating;
    }
    public void setNumericalRating(int numericalRating) {
        this.numericalRating = numericalRating;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }

    


    
}
