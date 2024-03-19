package nitconf.reviewermodule.reviewer.Controllers;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nitconf.reviewermodule.reviewer.Entities.Review;
import nitconf.reviewermodule.reviewer.Repositories.PaperRepository;
import nitconf.reviewermodule.reviewer.Repositories.ReviewRepository;
import nitconf.reviewermodule.reviewer.Service.ReviewService;



@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
   
    @PostMapping("/submitreview/{paperid}/{userid}")
    public ResponseEntity<String> submitReview(@PathVariable String userid ,@PathVariable int paperid, @RequestBody String reviewBody)

    {
        boolean creationSuccessful = reviewService.createReviewForPaper(reviewBody, paperid, userid);
        if(creationSuccessful)
        {
            return new ResponseEntity<>("Review submitted successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Failed to submit review", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update/{paperId}/{userid}")
    public ResponseEntity<String> updateReview(@PathVariable String userid,@PathVariable int paperId, @RequestBody String reviewBody) {
        boolean updateSuccessful = reviewService.updateReviewForPaper(reviewBody, paperId,userid);

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

    






}
