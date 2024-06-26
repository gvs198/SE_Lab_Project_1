package nitconf.reviewermodule.reviewer.Controllers;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nitconf.reviewermodule.reviewer.Entities.Review;
import nitconf.reviewermodule.reviewer.Entities.ReviewDto;
import nitconf.reviewermodule.reviewer.Repositories.PaperRepository;
import nitconf.reviewermodule.reviewer.Repositories.ReviewRepository;
import nitconf.reviewermodule.reviewer.Service.ReviewService;



@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
   
    
    /** 
     * @param userid
     * @param paperid
     * @param reviewBody
     * @return ResponseEntity<String>
     */
    @PostMapping("/submitreview/{paperid}/{userid}")
    public ResponseEntity<String> submitReview(@PathVariable String userid, @PathVariable int paperid, @RequestBody ReviewDto reviewDto) {
        boolean creationSuccessful = reviewService.createReviewForPaper(reviewDto.getReviewBody(), reviewDto.getRating(), paperid, userid);
        if (creationSuccessful) {
            return new ResponseEntity<>("Review submitted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("A review already exists for this paper. Kindly click the update review button in case you wish to change the contents of your review.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update/{paperId}/{userid}")
    public ResponseEntity<String> updateReview(@PathVariable String userid, @PathVariable int paperId, @RequestBody ReviewDto reviewDto) {
        boolean updateSuccessful = reviewService.updateReviewForPaper(reviewDto.getReviewBody(), reviewDto.getRating(), paperId, userid);

        if (updateSuccessful) {
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update review", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/delete/{paperId}/{userid}")
    public ResponseEntity<String> deleteReview(@PathVariable String userid, @PathVariable int paperId) {
        boolean deletionSuccessful = reviewService.deleteReviewForPaper(paperId, userid);

        if (deletionSuccessful) {
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete review", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getreview/{paperId}/{userId}")
    public ResponseEntity<String> getReview(@PathVariable String userId, @PathVariable int paperId)
    {
        Review reviewForPaper = reviewService.getReviewForPaper(paperId, userId);
        if(reviewForPaper==null)
        {
            return new ResponseEntity<>("No review exists for the paper", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else{
            return new ResponseEntity<>(reviewForPaper.getContent(), HttpStatus.OK);
        }
    }

    @GetMapping("/getrating/{paperId}/{userId}")
    public ResponseEntity<Integer> getRating(@PathVariable String userId, @PathVariable int paperId) {
        Review reviewForPaper = reviewService.getReviewForPaper(paperId, userId);
        if (reviewForPaper == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // Use NOT_FOUND for missing resource
        } else {
            return new ResponseEntity<>(reviewForPaper.getStarRating(), HttpStatus.OK);
        }
    }
    

   
    

}

    

    
    







