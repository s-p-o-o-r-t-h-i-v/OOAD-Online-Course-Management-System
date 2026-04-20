package ooad.admin;

import ooad.repository.*;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

// ISP: implements only IReportAdmin
@Service
public class ReportAdminServiceImpl implements IReportAdmin {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final SubmissionRepository submissionRepository;
    private final NotificationRepository notificationRepository;

    public ReportAdminServiceImpl(UserRepository userRepository,
            CourseRepository courseRepository,
            EnrollmentRepository enrollmentRepository,
            SubmissionRepository submissionRepository,
            NotificationRepository notificationRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.submissionRepository = submissionRepository;
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Map<String, Object> generateReport() {
        Map<String, Object> report = new LinkedHashMap<>();
        report.put("totalUsers", userRepository.count());
        report.put("totalCourses", courseRepository.count());
        report.put("totalEnrollments", enrollmentRepository.count());
        report.put("totalSubmissions", submissionRepository.count());
        report.put("totalNotifications", notificationRepository.count());
        return report;
    }
}