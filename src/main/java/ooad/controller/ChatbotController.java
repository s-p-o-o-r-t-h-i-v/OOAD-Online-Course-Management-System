package ooad.controller;

import jakarta.servlet.http.HttpSession;
import ooad.service.ChatbotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chatbot")
public class ChatbotController {

    @Autowired
    ChatbotService chatbotService;

    @GetMapping
    public String chatbotPage(HttpSession session, Model model) {
        String loggedInName = (String) session.getAttribute("loggedInName");
        if (loggedInName == null) return "redirect:/";

        model.addAttribute("studentName", loggedInName);
        // ✅ Pass role to the page
        model.addAttribute("loggedInRole", session.getAttribute("loggedInRole"));
        return "chatbot/chatbot";
    }

    @PostMapping("/ask")
    public String askQuestion(HttpSession session,
                              @RequestParam String question,
                              Model model) {

        String loggedInName = (String) session.getAttribute("loggedInName");
        if (loggedInName == null) return "redirect:/";

        String role = (String) session.getAttribute("loggedInRole");
        String answer = chatbotService.askQuestion(loggedInName, question, role);

        model.addAttribute("studentName", loggedInName);
        model.addAttribute("question", question);
        model.addAttribute("answer", answer);
        // ✅ Pass role to the page
        model.addAttribute("loggedInRole", role);
        return "chatbot/chatbot";
    }

    @GetMapping("/history")
    public String viewHistory(HttpSession session, Model model) {
        String loggedInName = (String) session.getAttribute("loggedInName");
        if (loggedInName == null) return "redirect:/";
    
        model.addAttribute("messages", chatbotService.getHistory(loggedInName));
        model.addAttribute("studentName", loggedInName);
        // ✅ Pass role
        model.addAttribute("loggedInRole", session.getAttribute("loggedInRole"));
        return "chatbot/chat-history";
    }
}