package nitconf.reviewermodule.reviewer.Controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nitconf.reviewermodule.reviewer.Entity.Review;
import nitconf.reviewermodule.reviewer.Entity.User;
import nitconf.reviewermodule.reviewer.Repository.ReviewRepository;
import nitconf.reviewermodule.reviewer.Repository.UserRepository;

// ReviewController.java
@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dashboard")
    public String showReviewForm(Model model) {
        model.addAttribute("review", new Review());
        return "index";
    }

    @PostMapping("/submit")
    public String submitReview(@ModelAttribute Review review, Principal principal) {
        String userEmail = principal.getName();
        User user = userRepository.findByEmail(userEmail);
        review.setUser(user);
        reviewRepository.save(review);
        return "redirect:/reviews/submit?success=true"; 
    }
    

    @GetMapping("/all")
    public String showAllReviews(Model model, Principal principal) {
        String userEmail = principal.getName();
        User user = userRepository.findByEmail(userEmail);
        List<Review> userReviews = reviewRepository.findByUser(user);
        model.addAttribute("userReviews", userReviews);
        return "allReviews";
    }
}
