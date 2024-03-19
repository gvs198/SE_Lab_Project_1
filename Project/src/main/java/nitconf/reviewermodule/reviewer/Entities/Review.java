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

    @DBRef
    private User reviewer;

    

    public Review(String content) {
        this.content = content;
    }



    public Review(String content, User reviewer) {
        this.content = content;
        this.reviewer = reviewer;
    }
    

    

    
    
    




}
