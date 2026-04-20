package ooad.chatbot;

public class RuleBasedChatbotAdapter implements ChatbotAdapter {

    private RuleBasedChatbot chatbot;

    public RuleBasedChatbotAdapter() {
        this.chatbot = new RuleBasedChatbot();
    }

    @Override
    public String processQuery(String question, String role) {
        return chatbot.findAnswer(question, role);
    }
}