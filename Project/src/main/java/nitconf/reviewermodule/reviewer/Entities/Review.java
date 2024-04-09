package nitconf.reviewermodule.reviewer.Entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Reviews")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Review {

    @Id
    private ObjectId id;

    private String content;
    private int starRating;


    @DBRef
    private User reviewer;

    @DBRef
    private Paper paper;

    

    public Review(String content) {
        this.content = content;
    }



    public Review(String content, User reviewer) {
        this.content = content;
        this.reviewer = reviewer;
    }




    public Review(String content, User reviewer, Paper paper) {
        this.content = content;
        this.reviewer = reviewer;
        this.paper = paper;
    }

    


    public Review(String content, int starRating, User reviewer, Paper paper) {
        this.content = content;
        this.starRating = starRating;
        this.reviewer = reviewer;
        this.paper = paper;
    }



    public void setStarRating(int starRating) {
    if (starRating < 1 || starRating > 5) {
      throw new IllegalArgumentException("Star rating must be between 1 and 5");
    }
    this.starRating = starRating;
  }
    

    

    
    
    




}
