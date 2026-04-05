package ooad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ooad.repository.EnrollmentRepository;
import ooad.model.Enrollment;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    EnrollmentRepository repo;

    public void enroll(Enrollment e){

        repo.save(e);

    }

    public List<Enrollment> getEnrollments(){

        return repo.findAll();

    }

}