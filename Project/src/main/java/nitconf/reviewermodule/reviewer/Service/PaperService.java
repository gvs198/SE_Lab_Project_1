package nitconf.reviewermodule.reviewer.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    
    /** 
     * @param userid
     * @return List<ReviewedPapers>
     */
    public List<ReviewedPapers> reviewedPapers(String userid)
    {
        User reviewer = userRepository.findByUserId(userid);
        return reviewedPapersRepository.findByReviewer(reviewer);


        
    }
    
    /** 
     * @param userid
     * @return List<Paper>
     */
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

    
    /** 
     * @param paperid
     * @param title
     * @param authors
     * @param abstractLink
     * @param deadLine
     */
    public void addPapers(int paperid, String title, String authors,String abstractLink,LocalDate deadLine)
    {
        Paper newPaper = new Paper(paperid, title, authors, abstractLink, deadLine);
        paperRepository.save(newPaper);


    }




}
