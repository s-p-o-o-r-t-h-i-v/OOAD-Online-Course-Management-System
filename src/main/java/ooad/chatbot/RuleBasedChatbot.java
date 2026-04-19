package ooad.chatbot;

public class RuleBasedChatbot {

    public String findAnswer(String input) {

        String q = input.toLowerCase();

        // ENROLLMENT
        if (q.contains("enroll") || q.contains("join course") || q.contains("register course")) {
            return "To enroll: Go to Dashboard → click 'Courses' → find your course → click 'Enroll'.";
        }

        // ASSIGNMENT SUBMISSION
        else if (q.contains("submit assignment") || q.contains("upload assignment")
                || q.contains("how to submit") || q.contains("submit my assignment")) {
            return "To submit an assignment: Go to Dashboard → click 'Assignment' in the menu → upload your file → click Submit.";
        }

        // VIEW ASSIGNMENTS
        else if (q.contains("assignment") || q.contains("homework") || q.contains("task")) {
            return "To view assignments: Go to Dashboard → click 'Assignment'. You can see all assignments and submit your work there.";
        }

        // LOGIN
        else if (q.contains("login") || q.contains("sign in") || q.contains("log in")) {
            return "To login: Go to the Login page → enter your registered email and password → click Login.";
        }

        // REGISTER / SIGNUP
        else if (q.contains("register") || q.contains("sign up") || q.contains("create account")) {
            return "To register: Go to the Login page → click 'Register' → fill in your name, email and password → click Register.";
        }

        // FORGOT PASSWORD
        else if (q.contains("forgot password") || q.contains("reset password") || q.contains("change password")) {
            return "If you forgot your password, please contact your instructor or admin to reset it for you.";
        }

        // VIEW COURSES
        else if (q.contains("view course") || q.contains("see course") || q.contains("available course")
                || q.contains("all course")) {
            return "To view courses: Go to Dashboard → click 'Courses' in the menu to see all available courses.";
        }

        // COURSE MATERIALS / NOTES
        else if (q.contains("material") || q.contains("notes") || q.contains("resource")
                || q.contains("study material")) {
            return "To access course materials: Go to Dashboard → select your enrolled course → course materials will be listed there.";
        }

        // GRADES / MARKS
        else if (q.contains("grade") || q.contains("marks") || q.contains("score")
                || q.contains("result") || q.contains("evaluation")) {
            return "To check your grades: Go to Dashboard → click 'Submissions'. Your instructor evaluates submissions and updates your grade there.";
        }

        // SUBMISSIONS STATUS
        else if (q.contains("submission") || q.contains("submitted") || q.contains("my submission")) {
            return "To check your submissions: Go to Dashboard → click 'Submissions' to see the status and grade of your submitted assignments.";
        }

        // CONTACT INSTRUCTOR
        else if (q.contains("instructor") || q.contains("teacher") || q.contains("professor")
                || q.contains("contact")) {
            return "To contact your instructor: Go to Dashboard → open your enrolled course → you will find instructor details there.";
        }

        // CERTIFICATE
        else if (q.contains("certificate") || q.contains("completion") || q.contains("finish course")) {
            return "Certificates are issued after you complete all assignments in the course and receive passing grades from your instructor.";
        }

        // DASHBOARD NAVIGATION
        else if (q.contains("dashboard") || q.contains("home") || q.contains("main page")) {
            return "To go to the Dashboard: click 'Dashboard' in the left sidebar menu, or go to localhost:8080/instructor/dashboard.";
        }

        // CHAT HISTORY
        else if (q.contains("history") || q.contains("previous chat") || q.contains("past question")) {
            return "To view your chat history: click 'Chat History' in the left sidebar menu.";
        }

        // GREETING
        else if (q.contains("hello") || q.contains("hi") || q.contains("hey") || q.contains("help")) {
            return "Hello! I am your EduPortal course assistant 🤖. You can ask me about enrollment, assignments, grades, materials, or login.";
        }

        // THANK YOU
        else if (q.contains("thank") || q.contains("thanks") || q.contains("great") || q.contains("good")) {
            return "You're welcome! Feel free to ask if you have more questions 😊.";
        }

        // DEFAULT
        else {
            return "I'm sorry, I didn't understand that. You can ask me about: enrollment, assignments, grades, course materials, login, or submissions.";
        }
    }
}