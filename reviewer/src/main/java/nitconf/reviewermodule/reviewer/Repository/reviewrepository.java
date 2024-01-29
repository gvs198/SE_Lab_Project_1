package nitconf.reviewermodule.reviewer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nitconf.reviewermodule.reviewer.Entity.Review;

public interface reviewrepository extends JpaRepository<Review, Long>{

    
} 
