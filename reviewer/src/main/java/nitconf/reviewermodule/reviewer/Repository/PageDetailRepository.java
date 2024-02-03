package nitconf.reviewermodule.reviewer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nitconf.reviewermodule.reviewer.Entity.PageDetails;

public class PageDetailRepository {
   public interface InnerpageDetailRepository extends JpaRepository<PageDetails,long> {
   
    
   } 
}