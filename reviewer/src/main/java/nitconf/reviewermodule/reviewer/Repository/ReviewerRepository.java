package nitconf.reviewermodule.reviewer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nitconf.reviewermodule.reviewer.Entity.Reviewer;

@Repository
public interface ReviewerRepository extends JpaRepository<Reviewer, Long> {
    Reviewer findByEmail(String email);
}
