package nitconf.reviewermodule.reviewer.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nitconf.reviewermodule.reviewer.Entity.Reviewer;
import nitconf.reviewermodule.reviewer.Service.ReviewerService;



@Controller
@RequestMapping("/auth")
public class ReviewerController {

    @Autowired
    private ReviewerService reviewerService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("reviewer", new Reviewer());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Reviewer reviewer, Model model) {
        try {
            reviewerService.registerReviewer(reviewer);
            return "redirect:/auth/login";
        } catch (RuntimeException e) {
            // Handle registration error (e.g., email already registered)
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
}
