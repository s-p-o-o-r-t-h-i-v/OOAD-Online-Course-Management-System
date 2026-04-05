package ooad.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ooad.model.Submission;

public interface SubmissionRepository extends JpaRepository<Submission,Long>{

}