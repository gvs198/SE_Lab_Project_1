package nitconf.reviewermodule.reviewer.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// MainController.java
@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

     @PostMapping("/submit")
     public String home() {
         return "reviewForm";
     }
    
    
}
