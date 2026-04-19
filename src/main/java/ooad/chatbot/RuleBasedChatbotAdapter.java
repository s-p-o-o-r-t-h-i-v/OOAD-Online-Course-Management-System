package ooad.chatbot;

// ADAPTER PATTERN in action
// Translates processQuery() → findAnswer()
public class RuleBasedChatbotAdapter implements ChatbotAdapter {

    private RuleBasedChatbot chatbot;

    public RuleBasedChatbotAdapter() {
        this.chatbot = new RuleBasedChatbot();
    }

    @Override
    public String processQuery(String question) {
        // Translation happens here
        return chatbot.findAnswer(question);
    }
}