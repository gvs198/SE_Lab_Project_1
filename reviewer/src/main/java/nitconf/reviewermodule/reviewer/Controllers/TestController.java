package nitconf.reviewermodule.reviewer.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import nitconf.reviewermodule.reviewer.Entity.Reviewer;
import nitconf.reviewermodule.reviewer.Service.ReviewerService;

@Controller
public class TestController {

    @Autowired
    private ReviewerService reviewerService;

    @GetMapping("/test/register")
    public String testRegister() {
        return "testRegister";
    }

    @PostMapping("/test/register")
    public String testRegister(@RequestParam String email, @RequestParam String password, Model model) {
        Reviewer reviewer = new Reviewer();
        reviewer.setEmail(email);
        reviewer.setPassword(password);
        try {
            reviewerService.registerReviewer(reviewer);
            model.addAttribute("message", "Registration successful!");
        } catch (Exception e) {
            model.addAttribute("error", "Registration failed: " + e.getMessage());
        }
        return "testRegister";
    }

    @GetMapping("/test/find")
    public String testFind() {
        return "testFind";
    }

    @PostMapping("/test/find")
    public String testFind(@RequestParam String email, Model model) {
        Reviewer reviewer = reviewerService.findReviewerByEmail(email);
        if (reviewer != null) {
            model.addAttribute("result", "Found reviewer with email: " + reviewer.getEmail());
        } else {
            model.addAttribute("result", "No reviewer found with the provided email");
        }
        return "testFind";
    }
}
