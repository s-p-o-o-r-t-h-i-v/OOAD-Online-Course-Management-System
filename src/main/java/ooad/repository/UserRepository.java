package ooad.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ooad.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

User findByEmail(String email);

}