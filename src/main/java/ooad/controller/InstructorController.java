package ooad.controller;

import ooad.model.*;
import ooad.repository.NotificationRepository;
import ooad.service.InstructorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

    private final InstructorService service;
    private final NotificationRepository notificationRepository;

    public InstructorController(InstructorService service, NotificationRepository notificationRepository) {
        this.service = service;
        this.notificationRepository = notificationRepository;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("courses", service.getAllCourses());
        model.addAttribute("materials", service.getAllMaterials());
        model.addAttribute("assignments", service.getAllAssignments());
        model.addAttribute("submissions", service.getAllSubmissions());
        model.addAttribute("notifications",
                notificationRepository.findBySentToInOrderBySentAtDesc(Arrays.asList("ALL", "INSTRUCTORS")));
        return "instructor/dashboard";
    }

    @GetMapping("/course/new")
    public String newCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "instructor/create-course";
    }

    @PostMapping("/course/save")
    public String saveCourse(@ModelAttribute Course course) {
        service.createCourse(course);
        return "redirect:/instructor/dashboard";
    }

    @GetMapping("/material/new")
    public String newMaterialForm(Model model) {
        model.addAttribute("material", new CourseMaterial());
        model.addAttribute("courses", service.getAllCourses());
        return "instructor/upload-material";
    }

    @PostMapping("/material/save")
    public String saveMaterial(@ModelAttribute CourseMaterial material) {
        service.uploadMaterial(material);
        return "redirect:/instructor/dashboard";
    }

    @GetMapping("/assignment/new")
    public String newAssignmentForm(Model model) {
        model.addAttribute("assignment", new Assignment());
        model.addAttribute("courses", service.getAllCourses());
        return "instructor/create-assignment";
    }

    @PostMapping("/assignment/save")
    public String saveAssignment(@ModelAttribute Assignment assignment) {
        service.createAssignment(assignment);
        return "redirect:/instructor/dashboard";
    }

    @GetMapping("/submissions")
    public String viewSubmissions(Model model) {
        model.addAttribute("submissions", service.getAllSubmissions());
        return "instructor/submissions";
    }

    @GetMapping("/submission/{id}/evaluate")
    public String evaluateForm(@PathVariable Long id, Model model) {
        model.addAttribute("submission", service.getAllSubmissions()
                .stream().filter(s -> s.getId().equals(id))
                .findFirst().orElseThrow());
        return "instructor/evaluate";
    }

    @PostMapping("/submission/{id}/evaluate")
    public String doEvaluate(@PathVariable Long id,
                             @RequestParam String strategyType,
                             @RequestParam(required = false) Integer manualGrade,
                             @RequestParam(required = false) String feedback) {
        service.evaluateSubmission(id, strategyType, manualGrade, feedback);
        return "redirect:/instructor/submissions";
    }
}