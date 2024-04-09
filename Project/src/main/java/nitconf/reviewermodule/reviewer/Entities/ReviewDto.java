package nitconf.reviewermodule.reviewer.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewDto {
    private String reviewBody;
    private int rating;
}
