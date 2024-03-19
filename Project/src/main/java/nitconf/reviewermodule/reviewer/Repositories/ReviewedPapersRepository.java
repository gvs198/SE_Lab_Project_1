package nitconf.reviewermodule.reviewer.Repositories;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import nitconf.reviewermodule.reviewer.Entities.Paper;
import nitconf.reviewermodule.reviewer.Entities.ReviewedPapers;
import nitconf.reviewermodule.reviewer.Entities.User;

public interface ReviewedPapersRepository extends MongoRepository<ReviewedPapers, ObjectId>{
    
    List<ReviewedPapers> findByReviewer(User reviewer);
    ReviewedPapers findByReviewedPaperAndReviewer(Paper reviewedPaper, User reviewer);
    ReviewedPapers findByReviewedPaper(Paper reviewedPaper);

}
