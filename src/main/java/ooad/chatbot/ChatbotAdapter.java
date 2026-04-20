package ooad.chatbot;

// ADAPTER PATTERN - common shape all chatbot engines must follow
public interface ChatbotAdapter {
    String processQuery(String question, String role);
}