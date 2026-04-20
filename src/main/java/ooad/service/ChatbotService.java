package ooad.service;

import ooad.model.ChatMessage;
import java.util.List;

// DEPENDENCY INVERSION PRINCIPLE
public interface ChatbotService {
    String askQuestion(String studentName, String question, String role);
    List<ChatMessage> getHistory(String studentName);
}