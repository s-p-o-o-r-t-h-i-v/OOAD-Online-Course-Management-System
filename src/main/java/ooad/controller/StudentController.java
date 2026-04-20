package ooad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import ooad.service.StudentService;
import ooad.model.Enrollment;
import ooad.model.Assignment;
import ooad.repository.AssignmentRepository;
import ooad.repository.NotificationRepository;

import java.util.List;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;

@Controller
public class StudentController {

    @Autowired
    StudentService service;

    @Autowired
    AssignmentRepository assignmentRepository;

    @Autowired
    NotificationRepository notificationRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model){

        List<Enrollment> courses = service.getEnrollments();

        model.addAttribute("courses", courses);
        model.addAttribute("notifications",
                notificationRepository.findBySentToInOrderBySentAtDesc(Arrays.asList("ALL", "STUDENTS")));

        return "dashboard";
    }

    @GetMapping("/courses")
    public String coursesPage(){
        return "courses";
    }

    @PostMapping("/enroll")
    public String enroll(Enrollment enrollment){

        service.enroll(enrollment);

        return "redirect:/dashboard";
    }

    // OPEN ASSIGNMENT PAGE
    @GetMapping("/assignment")
    public String assignmentPage(){
        return "submit-assignment";
    }

    // SUBMIT ASSIGNMENT
    @PostMapping("/submit-assignment")
public String submitAssignment(@RequestParam String studentName,
                               @RequestParam MultipartFile file) throws IOException {

    String uploadDir = System.getProperty("user.dir") + "/uploads/";

    File dir = new File(uploadDir);

    if (!dir.exists()) {
        dir.mkdirs();   // creates uploads folder
    }

    String fileName = file.getOriginalFilename();

    File destination = new File(uploadDir + fileName);

    file.transferTo(destination);

    Assignment a = new Assignment();
    a.setStudentName(studentName);
    a.setFileName(fileName);

    assignmentRepository.save(a);

    return "redirect:/dashboard";
}

}