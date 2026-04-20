package ooad.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ooad.model.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    List<Submission> findByAssignmentId(Long assignmentId);
}