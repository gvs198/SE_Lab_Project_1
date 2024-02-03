package nitconf.reviewermodule.reviewer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nitconf.reviewermodule.reviewer.Entity.Reviewer;
import nitconf.reviewermodule.reviewer.Repository.ReviewerRepository;

@Service
public class ReviewerService {

    @Autowired
    private ReviewerRepository reviewerRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public void registerReviewer(Reviewer reviewer) {
        // Check if the email is already registered
        if (reviewerRepository.findByEmail(reviewer.getEmail()) != null) {
            throw new RuntimeException("Email is already registered");
        }

        // Hash the password before storing it in the database
        String hashedPassword = passwordEncoder.encode(reviewer.getPassword());
        reviewer.setPassword(hashedPassword);

        reviewerRepository.save(reviewer);
    }

    public Reviewer findReviewerByEmail(String email) {
        return reviewerRepository.findByEmail(email);
    }
}
