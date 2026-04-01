package ooad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ooad.model.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

}