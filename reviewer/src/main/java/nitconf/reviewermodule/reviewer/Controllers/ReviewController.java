package nitconf.reviewermodule.reviewer.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nitconf.reviewermodule.reviewer.Entity.Review;
import nitconf.reviewermodule.reviewer.Service.ReviewService;

import java.util.List;
@RestController

public class ReviewController {
   
    @Autowired
    private ReviewService service;


    @PostMapping("/addReview")
    public Review addReview(@RequestBody Review review)
    {
        return service.saveReview(review);
    }
    @PostMapping("/addReviews")
    public List<Review> addReviews(@RequestBody List<Review> review)
    {
        return service.saveReviews(review);
    }

    @GetMapping("/reviews")
    public List <Review> findAllReviews()
    {
        return service.getReviews();
    }
    @GetMapping("/review/{id}")
    public Review findReviewsbyId(@PathVariable Long id)
    {
        return service.getReviewbyId(id);
    }
    @PutMapping("/update")
    public Review updatReview(@RequestBody Review review)
    {
        return service.updateReview(review);
    }

    @DeleteMapping("/delete {id}")
    public String deleteReview(@PathVariable Long id)
    {
        return service.deleteReview(id);
    }


    


    
    
}
