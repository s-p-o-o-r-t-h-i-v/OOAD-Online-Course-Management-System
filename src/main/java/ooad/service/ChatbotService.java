package ooad.service;

import ooad.model.ChatMessage;
import java.util.List;

// DEPENDENCY INVERSION PRINCIPLE
// Controller depends on this interface, never on the concrete class
public interface ChatbotService {
    String askQuestion(String studentName, String question);
    List<ChatMessage> getHistory(String studentName);
}