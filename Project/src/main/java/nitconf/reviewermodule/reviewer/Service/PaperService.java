package nitconf.reviewermodule.reviewer.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nitconf.reviewermodule.reviewer.Entities.Paper;
import nitconf.reviewermodule.reviewer.Entities.ReviewedPapers;
import nitconf.reviewermodule.reviewer.Entities.User;
import nitconf.reviewermodule.reviewer.Repositories.PaperRepository;
import nitconf.reviewermodule.reviewer.Repositories.ReviewedPapersRepository;
import nitconf.reviewermodule.reviewer.Repositories.UserRepository;

@Service
public class PaperService {

    @Autowired
    private PaperRepository paperRepository;

    @Autowired
    private ReviewedPapersRepository reviewedPapersRepository;
    @Autowired
    private UserRepository userRepository;

    public List<ReviewedPapers> reviewedPapers(String userid)
    {
        User reviewer = userRepository.findByUserId(userid);
        return reviewedPapersRepository.findByReviewer(reviewer);


        
    }
    public List<Paper> assignedPapers(String userid) {
        List<Paper> allPapers = paperRepository.findAll(); 
        User reviewer = userRepository.findByUserId(userid);
        List<Paper> assignedPapers = new ArrayList<>();

        for (Paper paper : allPapers) {
           
            if (reviewedPapersRepository.findByReviewedPaperAndReviewer(paper,reviewer)==null) {
                assignedPapers.add(paper);
            }
        }

        return assignedPapers;
    }




}
