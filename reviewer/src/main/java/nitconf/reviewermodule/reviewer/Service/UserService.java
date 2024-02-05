package nitconf.reviewermodule.reviewer.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import nitconf.reviewermodule.reviewer.Entity.User;
import nitconf.reviewermodule.reviewer.web.Dto.UserRegistrationDto;



public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}