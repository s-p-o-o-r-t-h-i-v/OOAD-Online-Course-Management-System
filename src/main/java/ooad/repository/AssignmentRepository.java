package ooad.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ooad.model.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByCourseId(Long courseId);
}