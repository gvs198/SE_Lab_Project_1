package nitconf.reviewermodule.reviewer.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nitconf.reviewermodule.reviewer.Entity.Reviewer;
import nitconf.reviewermodule.reviewer.Repository.ReviewerRepository;

@RestController
@RequestMapping()
public class ReviewerController {

    @Autowired
    private ReviewerRepository reviewerRepository;

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Reviewer reviewer) {
        // Perform validation and password comparison here
        Reviewer foundReviewer = reviewerRepository.findByEmail(reviewer.getEmail());
        if (foundReviewer != null) {
            // Generate and return a token or session information
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Reviewer reviewer) {
        // Perform validation and password hashing here
        reviewerRepository.save(reviewer);
        return ResponseEntity.ok("Reviewer registered successfully");
    }
}
