package nitconf.reviewermodule.reviewer.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nitconf.reviewermodule.reviewer.Entity.Review;
import nitconf.reviewermodule.reviewer.Entity.User;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByUser(User user);
}
