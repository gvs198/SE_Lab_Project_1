// package nitconf.reviewermodule.reviewer.Service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import nitconf.reviewermodule.reviewer.Entities.User;
// import nitconf.reviewermodule.reviewer.Repositories.UserRepository;

// @Service
// public class UserService {

// @Autowired
// private UserRepository userRepository;

//  @Autowired
// private PasswordEncoder passwordEncoder;


// public User save(User user) {
//     // Encode the password before saving
//     user.setPassword(passwordEncoder.encode(user.getPassword()));
//     return userRepository.save(user);
// }

// public User findUserbyemail(String email)
// {
//     return userRepository.findUserByemail(email);
// }


// public boolean authenticate(String email, String password) {
//     User user = userRepository.findUserByemail(email);
//     if (user != null && passwordEncoder.matches(password, user.getPassword())) {
//         return true; 
//     }
//     return false; 
// }




// }
