package nitconf.reviewermodule.reviewer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nitconf.reviewermodule.reviewer.Entity.Reviewer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewerRepository extends JpaRepository<Reviewer, Long> {

    Reviewer findByEmail(String email);
}

