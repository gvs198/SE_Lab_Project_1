package nitconf.reviewermodule.reviewer.Repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import nitconf.reviewermodule.reviewer.Entities.Paper;

public interface PaperRepository extends MongoRepository<Paper,ObjectId> {
    Paper findByAuthors(List<String> authors);
    Paper findByPaperid(int paper_id);
    


}
