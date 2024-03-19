package nitconf.reviewermodule.reviewer.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import nitconf.reviewermodule.reviewer.Auth.AuthenticationRequest;
import nitconf.reviewermodule.reviewer.Auth.AuthenticationResponse;
import nitconf.reviewermodule.reviewer.Auth.AuthenticationService;
import nitconf.reviewermodule.reviewer.Auth.RegisterRequest;
import nitconf.reviewermodule.reviewer.Entities.User;
import nitconf.reviewermodule.reviewer.Repositories.UserRepository;


/**
 * Controller class for handling user registration and login.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class UserController {
    
    private final AuthenticationService service;

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody RegisterRequest user) {
        if (user.getEmail() == null || user.getPassword() == null || user.getName() == null)
            return ResponseEntity.badRequest().build();

        Optional<User> userExists = userRepo.findByEmail(user.getEmail());

        if (userExists.isPresent())
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(service.register(user));
    }

   
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest user) {
        if (user.getEmail() == null || user.getPassword() == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(service.login(user));
    }
}