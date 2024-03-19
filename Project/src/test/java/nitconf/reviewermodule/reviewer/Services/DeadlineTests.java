package nitconf.reviewermodule.reviewer.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import nitconf.reviewermodule.reviewer.Service.ReviewService;

public class DeadlineTests {
    @Mock
    private ReviewService reviewService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this); // Initialize mocks
    }

    @Test 
    void checkBeforeDeadline() {
        LocalDateTime current = LocalDateTime.now();
        LocalDateTime deadline = LocalDateTime.of(current.getYear(), 12, 31, 23, 59, 59);

        when(reviewService.checkdeadLine(any(LocalDateTime.class), any(LocalDateTime.class))).thenReturn(1);

        Integer result = reviewService.checkdeadLine(current, deadline);

        assertEquals(1, result);
    }


}
