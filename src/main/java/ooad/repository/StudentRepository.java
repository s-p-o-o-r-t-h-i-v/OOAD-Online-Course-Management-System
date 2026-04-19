package ooad.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ooad.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

}