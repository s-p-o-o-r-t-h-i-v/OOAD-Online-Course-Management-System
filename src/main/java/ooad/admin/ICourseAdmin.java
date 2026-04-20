package ooad.admin;

import ooad.model.Course;
import java.util.List;

// ISP: only course-management methods here
public interface ICourseAdmin {
    List<Course> getAllCourses();

    void deleteCourse(Long id);
}