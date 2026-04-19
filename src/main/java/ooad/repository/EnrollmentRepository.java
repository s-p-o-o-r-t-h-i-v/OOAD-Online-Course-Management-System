package ooad.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ooad.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long>{

}