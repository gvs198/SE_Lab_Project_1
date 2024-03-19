package nitconf.reviewermodule.reviewer.Entities;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Papers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paper {
    @Id
    ObjectId id;
    int paperid;
    private String title;
    private List<String> authors;
    private String abstractLink;
    private LocalDateTime deadLine;
    


    

    



    
    

    



}
