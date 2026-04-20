package ooad.admin;

import ooad.model.Course;
import ooad.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// ISP: implements only ICourseAdmin
@Service
public class CourseAdminServiceImpl implements ICourseAdmin {

    private final CourseRepository courseRepository;

    public CourseAdminServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}