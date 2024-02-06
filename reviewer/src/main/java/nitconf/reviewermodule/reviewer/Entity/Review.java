package nitconf.reviewermodule.reviewer.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.Range;


@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String textualPart;
    
   
    private int numericalRating;
    public Review() {
    }
    public Review(User user, String textualPart, int numericalRating) {
        this.user = user;
        this.textualPart = textualPart;
        this.numericalRating = numericalRating;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getTextualPart() {
        return textualPart;
    }
    public void setTextualPart(String textualPart) {
        this.textualPart = textualPart;
    }
    public int getNumericalRating() {
        return numericalRating;
    }
    public void setNumericalRating(int numericalRating) {
        this.numericalRating = numericalRating;
    }

    // getters and setters
    
}
