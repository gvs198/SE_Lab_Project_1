package nitconf.reviewermodule.reviewer.Services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import nitconf.reviewermodule.reviewer.Entities.Paper;
import nitconf.reviewermodule.reviewer.Entities.Review;
import nitconf.reviewermodule.reviewer.Entities.ReviewedPapers;
import nitconf.reviewermodule.reviewer.Entities.User;
import nitconf.reviewermodule.reviewer.Repositories.PaperRepository;
import nitconf.reviewermodule.reviewer.Repositories.ReviewRepository;
import nitconf.reviewermodule.reviewer.Repositories.ReviewedPapersRepository;
import nitconf.reviewermodule.reviewer.Repositories.UserRepository;
import nitconf.reviewermodule.reviewer.Service.ReviewService;

public class ReviewServiceTests {
    @Mock
    private PaperRepository paperRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private ReviewedPapersRepository reviewedPapersRepository;

    @InjectMocks
    private ReviewService reviewService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createReviewForPaper_PaperNotFound_ReturnsFalse() {
       
        when(paperRepository.findByPaperid(anyInt())).thenReturn(null);
        
       
        boolean result = reviewService.createReviewForPaper("Review Body", 1, "user123");
        
       
        assertFalse(result);
    }

    @Test
    void createReviewForPaper_UserNotFound_ReturnsFalse() {
        
        when(paperRepository.findByPaperid(anyInt())).thenReturn(new Paper());
        when(userRepository.findByUserId(anyString())).thenReturn(null);
        
        
        boolean result = reviewService.createReviewForPaper("Review Body", 1, "user123");
        
       
        assertFalse(result);
    }

    @Test
    void createReviewForPaper_DeadlinePassed_ReturnsFalse() {
       
        Paper paper = new Paper();
        paper.setDeadLine(LocalDateTime.now().minusDays(1)); 
        when(paperRepository.findByPaperid(anyInt())).thenReturn(paper);
        when(userRepository.findByUserId(anyString())).thenReturn(new User());
        
      
        boolean result = reviewService.createReviewForPaper("Review Body", 1, "user123");
        
        
        assertFalse(result);
    }

    @Test
    void createReviewForPaper_Success_ReturnsTrue() {
       
        Paper paper = new Paper();
        paper.setDeadLine(LocalDateTime.now().plusDays(1)); 
        when(paperRepository.findByPaperid(anyInt())).thenReturn(paper);
        when(userRepository.findByUserId(anyString())).thenReturn(new User());
        
        
        boolean result = reviewService.createReviewForPaper("Review Body", 1, "user123");
        
      
        assertTrue(result);
        
    }
    @Test
void updateReviewForPaper_PaperNotFound_ReturnsFalse() {
    
    when(paperRepository.findByPaperid(anyInt())).thenReturn(null);

    
    boolean result = reviewService.updateReviewForPaper("Updated Review Body", 1, "user123");

    
    assertFalse(result);
}

@Test
void updateReviewForPaper_UserNotFound_ReturnsFalse() {
    
    when(paperRepository.findByPaperid(anyInt())).thenReturn(new Paper());
    when(userRepository.findByUserId(anyString())).thenReturn(null);

   
    boolean result = reviewService.updateReviewForPaper("Updated Review Body", 1, "user123");

    
    assertFalse(result);
}

@Test
void updateReviewForPaper_PaperNotReviewedByUser_ReturnsFalse() {
    
    Paper paper = new Paper();
    when(paperRepository.findByPaperid(anyInt())).thenReturn(paper);
    when(userRepository.findByUserId(anyString())).thenReturn(new User());
    when(reviewedPapersRepository.findByReviewedPaperAndReviewer(any(), any())).thenReturn(null);

   
    boolean result = reviewService.updateReviewForPaper("Updated Review Body", 1, "user123");

    
    assertFalse(result);
}

@Test
void updateReviewForPaper_Success_ReturnsTrue() {
    // Arrange
    Paper paper = new Paper();
    when(paperRepository.findByPaperid(anyInt())).thenReturn(paper);
    when(userRepository.findByUserId(anyString())).thenReturn(new User());

    
    Review review = new Review();
    

    ReviewedPapers reviewedPaper = mock(ReviewedPapers.class);
    when(reviewedPaper.getReview()).thenReturn(review);
    when(reviewedPapersRepository.findByReviewedPaperAndReviewer(any(), any())).thenReturn(reviewedPaper);

   
    boolean result = reviewService.updateReviewForPaper("Updated Review Body", 1, "user123");

    assertTrue(result);
    
}






}
