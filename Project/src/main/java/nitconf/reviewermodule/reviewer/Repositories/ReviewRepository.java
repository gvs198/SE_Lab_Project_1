package nitconf.reviewermodule.reviewer.Repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import nitconf.reviewermodule.reviewer.Entities.Review;

public interface ReviewRepository extends MongoRepository<Review, ObjectId>{

}
