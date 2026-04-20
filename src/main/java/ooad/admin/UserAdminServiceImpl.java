package ooad.admin;

import ooad.model.User;
import ooad.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// ISP: implements only IUserAdmin
@Service
public class UserAdminServiceImpl implements IUserAdmin {

    private final UserRepository userRepository;

    public UserAdminServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void activateUser(Long id) {
        userRepository.findById(id).ifPresent(user -> {
            user.setActive(!user.isActive()); // toggle active/inactive
            userRepository.save(user);
        });
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}