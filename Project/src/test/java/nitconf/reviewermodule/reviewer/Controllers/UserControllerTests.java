package nitconf.reviewermodule.reviewer.Controllers;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import nitconf.reviewermodule.reviewer.Auth.AuthenticationRequest;
import nitconf.reviewermodule.reviewer.Auth.AuthenticationResponse;
import nitconf.reviewermodule.reviewer.Auth.AuthenticationService;
import nitconf.reviewermodule.reviewer.Auth.RegisterRequest;
import nitconf.reviewermodule.reviewer.Repositories.UserRepository;



public class UserControllerTests {
    
        @Mock
        private UserRepository userRepo;
    
        @InjectMocks
        private UserController userController;
    
        @Mock
        private Authentication authentication;

        @Mock
        private AuthenticationService authenticationService;
    
        @BeforeEach
        public void setUp() {
            MockitoAnnotations.initMocks(this);
        }
    
       

        @Test
        void testLogin() {
            AuthenticationRequest user = new AuthenticationRequest("test@test.com","samplePassword");
            doAnswer(i -> null).when(authenticationService).login(user);

            ResponseEntity<AuthenticationResponse> response = userController.login(user);
            assertEquals(HttpStatus.OK, response.getStatusCode());
        }

        @Test
        void testLogin_nullEmail() {
            AuthenticationRequest user = new AuthenticationRequest(null, "samplePassword");

            ResponseEntity<AuthenticationResponse> response = userController.login(user);
            assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
         }

         @Test
         void testRegisterUser_MissingFirstName() {
             RegisterRequest user = new RegisterRequest(null, "test@test.com", "samplePassword", null);
     
             ResponseEntity<AuthenticationResponse> response = userController.registerUser(user);
             assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
         }

         @Test
        void testRegisterUser_MissingEmail() {
            RegisterRequest user = new RegisterRequest("Test", null, "samplePassword", null);
    
            ResponseEntity<AuthenticationResponse> response = userController.registerUser(user);
            assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        }

       
}