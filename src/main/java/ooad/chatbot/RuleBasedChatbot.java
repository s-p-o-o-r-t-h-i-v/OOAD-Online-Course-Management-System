package ooad.chatbot;

public class RuleBasedChatbot {

    public String findAnswer(String input, String role) {

        String q = input.toLowerCase();
        boolean isInstructor = "INSTRUCTOR".equalsIgnoreCase(role);

        // ─────────────────────────────────────────
        // GREETING
        // ─────────────────────────────────────────
        if (q.contains("hello") || q.contains("hi") || q.contains("hey") || q.equals("help")) {
            if (isInstructor) {
                return "Hello Instructor! I can help you with creating courses, uploading materials, managing assignments, or evaluating submissions.";
            } else {
                return "Hello! I can help you with enrollment, assignments, grades, course materials, or login.";
            }
        }

        // ─────────────────────────────────────────
        // DASHBOARD / HOME
        // ─────────────────────────────────────────
        if (q.contains("dashboard") || q.contains("home") || q.contains("main page")) {
            if (isInstructor) {
                return "Your Dashboard is at the top of the left sidebar. It shows your total courses, materials, assignments, and submissions at a glance.";
            } else {
                return "Your Dashboard shows your enrolled courses. Click 'Dashboard' in the menu or go to /dashboard.";
            }
        }

        // ─────────────────────────────────────────
        // COURSE
        // ─────────────────────────────────────────
        if (q.contains("create course") || q.contains("add course") || q.contains("new course")) {
            if (isInstructor) {
                return "To create a course: Go to Dashboard → click 'Create Course' in the sidebar → fill in the title, category, and description → click Save.";
            } else {
                return "Students cannot create courses. You can view and enroll in available courses from the Courses page.";
            }
        }

        if (q.contains("view course") || q.contains("see course") || q.contains("available course")
                || q.contains("all course") || q.contains("course")) {
            if (isInstructor) {
                return "To view your courses: Go to Dashboard → scroll down to 'My Courses' section. All your created courses are listed there.";
            } else {
                return "To view courses: Go to Dashboard → click 'Courses' in the menu to see all available courses and enroll.";
            }
        }

        // ─────────────────────────────────────────
        // ENROLLMENT (student only)
        // ─────────────────────────────────────────
        if (q.contains("enroll") || q.contains("join course") || q.contains("register course")) {
            if (isInstructor) {
                return "Instructors don't enroll in courses. You can create courses from Dashboard → 'Create Course' in the sidebar.";
            } else {
                return "To enroll in a course: Go to Dashboard → click 'Courses' → find your course → click 'Enroll'.";
            }
        }

        // ─────────────────────────────────────────
        // MATERIALS
        // ─────────────────────────────────────────
        if (q.contains("upload material") || q.contains("add material") || q.contains("new material")) {
            if (isInstructor) {
                return "To upload material: Go to Dashboard → click 'Upload Material' in the sidebar → select the course → enter file name, type and URL → click Save.";
            } else {
                return "You cannot upload materials. Course materials are uploaded by your instructor. Go to Dashboard → open your enrolled course to view them.";
            }
        }

        if (q.contains("material") || q.contains("notes") || q.contains("resource")
                || q.contains("study material")) {
            if (isInstructor) {
                return "To manage materials: Go to Dashboard → click 'Upload Material' in the sidebar. Your uploaded materials are also listed on the Dashboard.";
            } else {
                return "To access course materials: Go to Dashboard → select your enrolled course → course materials will be listed there.";
            }
        }

        // ─────────────────────────────────────────
        // ASSIGNMENTS
        // ─────────────────────────────────────────
        if (q.contains("create assignment") || q.contains("add assignment") || q.contains("new assignment")) {
            if (isInstructor) {
                return "To create an assignment: Go to Dashboard → click 'Assignment' in the sidebar → select the course → fill in title, description, due date → click Save.";
            } else {
                return "Students cannot create assignments. To view and submit assignments: Go to Dashboard → click 'Assignment'.";
            }
        }

        if (q.contains("submit assignment") || q.contains("upload assignment")
                || q.contains("how to submit") || q.contains("submit my assignment")) {
            if (isInstructor) {
                return "Instructors don't submit assignments. To create one: Go to Dashboard → click 'Assignment' in the sidebar → fill in details → Save.";
            } else {
                return "To submit an assignment: Go to Dashboard → click 'Assignment' in the menu → upload your file → click Submit.";
            }
        }

        if (q.contains("assignment") || q.contains("homework") || q.contains("task")) {
            if (isInstructor) {
                return "To manage assignments: Go to Dashboard → click 'Assignment' in the sidebar to create new ones. All assignments are listed on your Dashboard.";
            } else {
                return "To view and submit assignments: Go to Dashboard → click 'Assignment' in the menu.";
            }
        }

        // ─────────────────────────────────────────
        // SUBMISSIONS
        // ─────────────────────────────────────────
        if (q.contains("evaluate") || q.contains("grade submission") || q.contains("review submission")) {
            if (isInstructor) {
                return "To evaluate submissions: Go to Dashboard → click 'Submissions' in the sidebar → click 'Evaluate' next to a submission → choose grading strategy → enter grade and feedback → Submit.";
            } else {
                return "Grading is done by your instructor. You can check your grades at Dashboard → click 'Submissions'.";
            }
        }

        if (q.contains("submission") || q.contains("submitted") || q.contains("my submission")) {
            if (isInstructor) {
                return "To view all submissions: Go to Dashboard → click 'Submissions' in the sidebar. You can evaluate each submission from there.";
            } else {
                return "To check your submissions: Go to Dashboard → click 'Submissions' to see the status and grade of your submitted assignments.";
            }
        }

        // ─────────────────────────────────────────
        // GRADES / MARKS
        // ─────────────────────────────────────────
        if (q.contains("grade") || q.contains("marks") || q.contains("score")
                || q.contains("result") || q.contains("evaluation")) {
            if (isInstructor) {
                return "To give grades: Go to Dashboard → click 'Submissions' → click 'Evaluate' → choose Auto, Manual, or Rubric grading → enter grade and feedback.";
            } else {
                return "To check your grades: Go to Dashboard → click 'Submissions'. Your instructor evaluates your work and updates your grade there.";
            }
        }

        // ─────────────────────────────────────────
        // LOGIN / REGISTER
        // ─────────────────────────────────────────
        if (q.contains("login") || q.contains("sign in") || q.contains("log in")) {
            return "To login: Go to the Login page → select your role (Student / Instructor / Admin) → enter your email and password → click Login.";
        }

        if (q.contains("register") || q.contains("sign up") || q.contains("create account")) {
            return "To register: Go to the Login page → click 'Create Account' → fill in your name, email and password → click Register.";
        }

        if (q.contains("forgot password") || q.contains("reset password") || q.contains("change password")) {
            return "If you forgot your password, please contact your admin to reset it for you.";
        }

        // ─────────────────────────────────────────
        // CERTIFICATE
        // ─────────────────────────────────────────
        if (q.contains("certificate") || q.contains("completion") || q.contains("finish course")) {
            if (isInstructor) {
                return "Certificates are managed by the Admin. As an instructor, ensure all assignments are graded so students can complete the course.";
            } else {
                return "Certificates are issued after you complete all assignments in the course and receive passing grades from your instructor.";
            }
        }

        // ─────────────────────────────────────────
        // CONTACT INSTRUCTOR
        // ─────────────────────────────────────────
        if (q.contains("instructor") || q.contains("teacher") || q.contains("professor")
                || q.contains("contact")) {
            if (isInstructor) {
                return "You are the instructor! If you need admin support, please contact your Admin.";
            } else {
                return "To contact your instructor: Go to Dashboard → open your enrolled course → you will find instructor details there.";
            }
        }

        // ─────────────────────────────────────────
        // CHAT HISTORY
        // ─────────────────────────────────────────
        if (q.contains("history") || q.contains("previous chat") || q.contains("past question")) {
            return "To view your chat history: click 'Chat History' in the left sidebar menu.";
        }

        // ─────────────────────────────────────────
        // THANK YOU
        // ─────────────────────────────────────────
        if (q.contains("thank") || q.contains("thanks") || q.contains("great") || q.contains("good")) {
            return "You're welcome! Feel free to ask if you have more questions 😊.";
        }

        // ─────────────────────────────────────────
        // DEFAULT
        // ─────────────────────────────────────────
        if (isInstructor) {
            return "I'm sorry, I didn't understand that. You can ask me about: creating courses, uploading materials, assignments, evaluating submissions, or grades.";
        } else {
            return "I'm sorry, I didn't understand that. You can ask me about: enrollment, assignments, grades, course materials, login, or submissions.";
        }
    }
}