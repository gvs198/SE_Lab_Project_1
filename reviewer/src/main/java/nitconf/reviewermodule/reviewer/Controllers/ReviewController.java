package nitconf.reviewermodule.reviewer.Controllers;

import java.security.Principal;

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

    @GetMapping("/submit")
    public String showReviewForm(Model model) {
        model.addAttribute("review", new Review());
        return "reviewForm";
    }

    @PostMapping("/submit")
    public String submitReview(@ModelAttribute Review review, Principal principal) {
        // Retrieve the logged-in user by email
        String userEmail = principal.getName();
        User user = userRepository.findByEmail(userEmail);

        // Associate the user with the review
        review.setUser(user);

        // Save the review to the database
        reviewRepository.save(review);

        return "redirect:/reviews/submit?success";
    }
}
