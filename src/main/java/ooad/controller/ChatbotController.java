package ooad.controller;

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
    public String chatbotPage() {
        return "chatbot/chatbot";
    }

    @PostMapping("/ask")
    public String askQuestion(@RequestParam String studentName,
                              @RequestParam String question,
                              Model model) {

        String answer = chatbotService.askQuestion(studentName, question);

        model.addAttribute("studentName", studentName);
        model.addAttribute("question", question);
        model.addAttribute("answer", answer);

        return "chatbot/chatbot";
    }
    
    // View chat history
    @GetMapping("/history")
    public String viewHistory(@RequestParam(required = false) String studentName,
                              Model model) {
                            
        if (studentName != null && !studentName.isEmpty()) {
            model.addAttribute("messages", chatbotService.getHistory(studentName));
            model.addAttribute("studentName", studentName);
        }
    
        return "chatbot/chat-history";
    }
}