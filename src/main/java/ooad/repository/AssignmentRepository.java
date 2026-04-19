package ooad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ooad.model.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

import ooad.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByCourseId(Long courseId);
}