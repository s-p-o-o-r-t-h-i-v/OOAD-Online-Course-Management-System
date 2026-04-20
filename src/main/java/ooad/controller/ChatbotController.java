package ooad.controller;

import jakarta.servlet.http.HttpSession;
import ooad.service.ChatbotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// GRASP CONTROLLER - single entry point for all chatbot requests
@Controller
@RequestMapping("/chatbot")
public class ChatbotController {

    // DIP - depends on interface, not implementation
    @Autowired
    ChatbotService chatbotService;

    @GetMapping
    public String chatbotPage(HttpSession session, Model model) {

        String loggedInName = (String) session.getAttribute("loggedInName");

        // If not logged in, redirect to login page
        if (loggedInName == null) {
            return "redirect:/";
        }

        // Pass the name to the page so we can display it
        model.addAttribute("studentName", loggedInName);
        return "chatbot/chatbot";
    }

    @PostMapping("/ask")
    public String askQuestion(HttpSession session,
                              @RequestParam String question,
                              Model model) {

        String loggedInName = (String) session.getAttribute("loggedInName");

        // If not logged in, redirect to login page
        if (loggedInName == null) {
            return "redirect:/";
        }

        String answer = chatbotService.askQuestion(loggedInName, question);

        model.addAttribute("studentName", loggedInName);
        model.addAttribute("question", question);
        model.addAttribute("answer", answer);

        return "chatbot/chatbot";
    }

    @GetMapping("/history")
    public String viewHistory(HttpSession session, Model model) {

        String loggedInName = (String) session.getAttribute("loggedInName");

        // If not logged in, redirect to login page
        if (loggedInName == null) {
            return "redirect:/";
        }

        // Automatically load only THIS user's history
        model.addAttribute("messages", chatbotService.getHistory(loggedInName));
        model.addAttribute("studentName", loggedInName);

        return "chatbot/chat-history";
    }
}