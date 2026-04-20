package ooad.controller;

import ooad.admin.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final IUserAdmin userAdminService;
    private final ICourseAdmin courseAdminService;
    private final IReportAdmin reportAdminService;
    private final INotificationAdmin notificationService;

    public AdminController(UserAdminServiceImpl userAdminService,
            CourseAdminServiceImpl courseAdminService,
            ReportAdminServiceImpl reportAdminService,
            NotificationService notificationService) {
        this.userAdminService = userAdminService;
        this.courseAdminService = courseAdminService;
        this.reportAdminService = reportAdminService;
        this.notificationService = notificationService;
    }

    // ─── DASHBOARD ───────────────────────────────────────────────────────────
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("users", userAdminService.getAllUsers());
        model.addAttribute("courses", courseAdminService.getAllCourses());
        model.addAttribute("report", reportAdminService.generateReport());
        model.addAttribute("notifications", notificationService.getAllNotifications());
        return "admin/dashboard_admin";
    }

    // ─── MANAGE USERS ────────────────────────────────────────────────────────
    @GetMapping("/users")
    public String manageUsers(Model model) {
        model.addAttribute("users", userAdminService.getAllUsers());
        return "admin/manage-users";
    }

    @PostMapping("/users/{id}/toggle")
    public String toggleUser(@PathVariable Long id) {
        userAdminService.activateUser(id);
        return "redirect:/admin/users";
    }

    @PostMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userAdminService.deleteUser(id);
        return "redirect:/admin/users";
    }

    // ─── MANAGE COURSES ───────────────────────────────────────────────────────
    @GetMapping("/courses")
    public String manageCourses(Model model) {
        model.addAttribute("courses", courseAdminService.getAllCourses());
        return "admin/manage-courses";
    }

    @PostMapping("/courses/{id}/delete")
    public String deleteCourse(@PathVariable Long id) {
        courseAdminService.deleteCourse(id);
        return "redirect:/admin/courses";
    }

    // ─── REPORTS ──────────────────────────────────────────────────────────────
    @GetMapping("/reports")
    public String generateReports(Model model) {
        model.addAttribute("report", reportAdminService.generateReport());
        return "admin/reports";
    }

    // ─── NOTIFICATIONS ────────────────────────────────────────────────────────
    @GetMapping("/notifications")
    public String notificationsPage(Model model) {
        model.addAttribute("notifications", notificationService.getAllNotifications());
        return "admin/notifications";
    }

    @PostMapping("/notifications/send")
    public String sendNotification(@RequestParam String title,
            @RequestParam String message,
            @RequestParam String sentTo) {
        notificationService.sendNotification(title, message, sentTo);
        return "redirect:/admin/notifications";
    }
}