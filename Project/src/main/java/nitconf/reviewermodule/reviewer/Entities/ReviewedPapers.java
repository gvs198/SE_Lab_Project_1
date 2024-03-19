package nitconf.reviewermodule.reviewer.Entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "ReviewedPapers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewedPapers {
    @Id
    private ObjectId id;
    private Paper reviewedPaper;
    @DBRef
    private User reviewer;
    @DBRef
    private Review review;
    public ReviewedPapers(Paper reviewedPaper, User reviewer, Review review) {
        this.reviewedPaper = reviewedPaper;
        this.reviewer = reviewer;
        this.review = review;
    }
    





}
