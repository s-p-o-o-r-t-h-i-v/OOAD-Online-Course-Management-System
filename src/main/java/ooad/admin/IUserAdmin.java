package ooad.admin;

import ooad.model.User;
import java.util.List;

// ISP: only user-management methods here
public interface IUserAdmin {
    List<User> getAllUsers();

    void activateUser(Long id);

    void deleteUser(Long id);
}