package ooad.service;

import ooad.model.*;
import ooad.repository.*;
import ooad.service.grading.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InstructorService {

    private final CourseRepository courseRepo;
    private final CourseMaterialRepository materialRepo;
    private final AssignmentRepository assignmentRepo;
    private final SubmissionRepository submissionRepo;
    private GradingStrategy gradingStrategy;

    public InstructorService(CourseRepository courseRepo,
                             CourseMaterialRepository materialRepo,
                             AssignmentRepository assignmentRepo,
                             SubmissionRepository submissionRepo) {
        this.courseRepo      = courseRepo;
        this.materialRepo    = materialRepo;
        this.assignmentRepo  = assignmentRepo;
        this.submissionRepo  = submissionRepo;
        this.gradingStrategy = new ManualGradingStrategy();
    }

    public void setGradingStrategy(GradingStrategy strategy) {
        this.gradingStrategy = strategy;
    }

    public Course createCourse(Course course) { return courseRepo.save(course); }
    public List<Course> getAllCourses() { return courseRepo.findAll(); }

    public CourseMaterial uploadMaterial(CourseMaterial material) { return materialRepo.save(material); }
    public List<CourseMaterial> getAllMaterials() { return materialRepo.findAll(); }

    public Assignment createAssignment(Assignment assignment) { return assignmentRepo.save(assignment); }
    public List<Assignment> getAllAssignments() { return assignmentRepo.findAll(); }

    public List<Submission> getAllSubmissions() { return submissionRepo.findAll(); }

    public Submission evaluateSubmission(Long id, String strategyType,
                                         Integer manualGrade, String feedback) {
        Submission sub = submissionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Submission not found"));
        switch (strategyType.toUpperCase()) {
            case "AUTO"   -> setGradingStrategy(new AutoGradingStrategy());
            case "RUBRIC" -> setGradingStrategy(new RubricGradingStrategy());
            default       -> setGradingStrategy(new ManualGradingStrategy());
        }
        if ("MANUAL".equalsIgnoreCase(strategyType) && manualGrade != null) {
            sub.setGrade(manualGrade);
        }
        sub.setGrade(gradingStrategy.grade(sub));
        sub.setFeedback(feedback);
        sub.setGradingType(gradingStrategy.getStrategyName());
        return submissionRepo.save(sub);
    }
}