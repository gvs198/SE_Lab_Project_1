package nitconf.reviewermodule.reviewer.Services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import nitconf.reviewermodule.reviewer.Entities.Paper;
import nitconf.reviewermodule.reviewer.Entities.ReviewedPapers;
import nitconf.reviewermodule.reviewer.Entities.User;
import nitconf.reviewermodule.reviewer.Repositories.PaperRepository;
import nitconf.reviewermodule.reviewer.Repositories.ReviewedPapersRepository;
import nitconf.reviewermodule.reviewer.Repositories.UserRepository;
import nitconf.reviewermodule.reviewer.Service.PaperService;

public class PaperServiceTests {

    @Mock
    private PaperRepository paperRepository;

    @Mock
    private ReviewedPapersRepository reviewedPapersRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private PaperService paperService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void reviewedPapers_UserNotFound_ReturnsEmptyList() {
        // Arrange
        when(userRepository.findByUserId(anyString())).thenReturn(null);

        // Act
        List<ReviewedPapers> results = paperService.reviewedPapers("user123");

        // Assert
        assertTrue(results.isEmpty());
    }

    @Test
    void reviewedPapers_Success_ReturnsReviewedPapers() {
        // Arrange
        User reviewer = new User();
        when(userRepository.findByUserId(anyString())).thenReturn(reviewer);
        List<ReviewedPapers> expectedReviewedPapers = new ArrayList<>();
        when(reviewedPapersRepository.findByReviewer(reviewer)).thenReturn(expectedReviewedPapers);

        // Act
        List<ReviewedPapers> results = paperService.reviewedPapers("user123");

        // Assert
        assertEquals(expectedReviewedPapers, results);
    }

    @Test
    void assignedPapers_UserNotFound_ReturnsEmptyList() {
        // Arrange
        when(userRepository.findByUserId(anyString())).thenReturn(null);

        // Act
        List<Paper> results = paperService.assignedPapers("user123");

        // Assert
        assertTrue(results.isEmpty());
    }

    @Test
    void assignedPapers_Success_ReturnsAssignedPapers() {
        // Arrange
        User reviewer = new User();
        when(userRepository.findByUserId(anyString())).thenReturn(reviewer);
        List<Paper> allPapers = new ArrayList<>();
        allPapers.add(new Paper());
        when(paperRepository.findAll()).thenReturn(allPapers);
        when(reviewedPapersRepository.findByReviewedPaperAndReviewer(any(), any())).thenReturn(null); // No reviewed papers

        // Act
        List<Paper> results = paperService.assignedPapers("user123");

        // Assert
        assertEquals(allPapers, results);
    }

    
}

