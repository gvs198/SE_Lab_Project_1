    package nitconf.reviewermodule.reviewer.Service;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.util.List;
    import java.util.Optional;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.mongodb.core.MongoTemplate;
    import org.springframework.stereotype.Service;

    import nitconf.reviewermodule.reviewer.Entities.Paper;
    import nitconf.reviewermodule.reviewer.Entities.Review;
    import nitconf.reviewermodule.reviewer.Entities.ReviewedPapers;
    import nitconf.reviewermodule.reviewer.Entities.User;
    import nitconf.reviewermodule.reviewer.Repositories.PaperRepository;
    import nitconf.reviewermodule.reviewer.Repositories.ReviewRepository;
    import nitconf.reviewermodule.reviewer.Repositories.ReviewedPapersRepository;
    import nitconf.reviewermodule.reviewer.Repositories.UserRepository;



    @Service
    public class ReviewService {


        @Autowired
        private ReviewRepository reviewRepository;

        @Autowired
        private PaperRepository paperRepository;

        @Autowired
        private ReviewedPapersRepository reviewedPapersRepository;

        @Autowired
        private UserRepository userRepository;


    

        


        @Autowired
        private MongoTemplate mongoTemplate;



        public int checkdeadLine(LocalDate currentDateTime, LocalDate deadLine)
        {
            if(currentDateTime.isAfter(deadLine))
            {
                return 0;

            }
            else
            {
                return 1;
            }

        }


        public boolean createReviewForPaper(String reviewBody, int rating, int paperId, String userid) {
            Paper paperToBeReviewed = paperRepository.findByPaperid(paperId);
            User reviewer = userRepository.findByUserId(userid);
            if (paperToBeReviewed == null) {
            return false;
            }
            if(reviewer==null)
            {
                return false;
            }
        ReviewedPapers reviewedPapers= reviewedPapersRepository.findByReviewedPaperAndReviewer(paperToBeReviewed, reviewer);
        if(reviewedPapers!=null)
        {
            return false;
        }
        
            LocalDate currentDateTime = LocalDate.now();
            LocalDate deadline = paperToBeReviewed.getDeadLine();
        
            if (checkdeadLine(currentDateTime, deadline) == 0) {
            return false;
            }
        
            // Create the review
            Review review = new Review(reviewBody,rating, reviewer, paperToBeReviewed);
            reviewRepository.save(review);
        
        
            //Add the Paper to the reviewed papers database
            ReviewedPapers reviewedPaper = new ReviewedPapers(paperToBeReviewed, reviewer, review);
            reviewedPapersRepository.save(reviewedPaper);
        
            return true;
        }
        
        public boolean updateReviewForPaper(String reviewBody, int rating, int paperid, String userid)
        {
            Paper papertobeupdated= paperRepository.findByPaperid(paperid);
            User reviewer = userRepository.findByUserId(userid);
            if(papertobeupdated==null)
            {
                return false;
            }
            if(reviewer==null)
            {
                
                return false;
            }
        

            
            ReviewedPapers reviewedPaper = reviewedPapersRepository.findByReviewedPaperAndReviewer(papertobeupdated, reviewer);
            if (reviewedPaper == null) {
            return false; // Paper not reviewed by this user
            }

        
            
            Review existingReview = reviewedPaper.getReview();
            if (existingReview == null) {
                return false;
            }
            existingReview.setContent(reviewBody);
            existingReview.setStarRating(rating);
        
            reviewRepository.save(existingReview);
        
            return true;

            





        }

        public boolean deleteReviewForPaper(int paper_id, String userid)
        {
            Paper papertobeunreviewed = paperRepository.findByPaperid(paper_id);
            User reviewer = userRepository.findByUserId(userid);
            if(papertobeunreviewed==null)
            {
                return false;
            }
            ReviewedPapers reviewedPaper = reviewedPapersRepository.findByReviewedPaperAndReviewer(papertobeunreviewed, reviewer);
            if(reviewedPaper==null)
            {
                return false;
            }



            LocalDate currentDateTime = LocalDate.now();
            LocalDate deadLine = papertobeunreviewed.getDeadLine();
            if(checkdeadLine(currentDateTime, deadLine)==0)
            {
                return false;

            }

            Review existingReview = reviewedPaper.getReview();
            reviewRepository.delete(existingReview);
            reviewedPapersRepository.delete(reviewedPaper);
        
            return true;
        

            

        }


    public Review getReviewForPaper(int paper_id, String userid)
    {
        Paper paper = paperRepository.findByPaperid(paper_id);
        if(paper==null)
        {
            return null;
        }
        User reviewer = userRepository.findByUserId(userid);
        ReviewedPapers reviewedPaper = reviewedPapersRepository.findByReviewedPaperAndReviewer(paper, reviewer);
            if(reviewedPaper==null)
            {
                return null;
            }
        return reviewedPaper.getReview();

    }




    }
