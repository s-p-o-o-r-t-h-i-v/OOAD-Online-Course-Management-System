package ooad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ooad.model.User;
import ooad.repository.UserRepository;

@Service
public class AuthService {

@Autowired
UserRepository repo;

// REGISTER USER
public void register(User user){
    repo.save(user);
}

// LOGIN USER
public User login(String email,String password){

    User user = repo.findByEmail(email);

    if(user != null && user.getPassword().equals(password)){
        return user;
    }

    return null;
}

// FIND USER BY EMAIL (for duplicate check)
public User findByEmail(String email){
    return repo.findByEmail(email);
}

}