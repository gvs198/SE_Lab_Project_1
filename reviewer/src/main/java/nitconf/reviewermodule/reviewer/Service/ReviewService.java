package nitconf.reviewermodule.reviewer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nitconf.reviewermodule.reviewer.Entity.Review;
import nitconf.reviewermodule.reviewer.Repository.reviewrepository;

@Service
public class ReviewService {
    @Autowired
    private reviewrepository repository;
    public Review saveReview(Review review)
    {
        return repository.save(review);

    }
    public List<Review> saveReviews(List<Review> reviews)
    {
        return repository.saveAll(reviews);

    }
    public List<Review> getReviews()
    {
        return repository.findAll();
    }
    public Review getReviewbyId(Long id)
    {
        return repository.findById(id).orElse(null);
    }
    public String deleteReview(Long id)
    {
        repository.deleteById(id);
        return "Review successfully deleted!" + id;
    }
   
    public Review updateReview(Review review)
    {
        Review existingReview = repository.findById(review.getId()).orElse(null);
        existingReview.setComments(review.getComments());
        existingReview.setNumericalRating(review.getNumericalRating());
        existingReview.setComments(review.getComments());
        return repository.save(existingReview);


    }

    
    
}
