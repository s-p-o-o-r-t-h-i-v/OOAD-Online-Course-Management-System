package ooad.service;

import ooad.chatbot.ChatbotAdapter;
import ooad.chatbot.RuleBasedChatbotAdapter;
import ooad.model.ChatMessage;
import ooad.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChatbotServiceImpl implements ChatbotService {

    @Autowired
    ChatMessageRepository repository;

    // DIP - depends on ChatbotAdapter interface, not RuleBasedChatbot directly
    private ChatbotAdapter chatbotAdapter;

    public ChatbotServiceImpl() {
        this.chatbotAdapter = new RuleBasedChatbotAdapter();
    }

    @Override
    public String askQuestion(String studentName, String question) {

        // Step 1 - Get answer via adapter
        String answer = chatbotAdapter.processQuery(question);

        // Step 2 - Save to DB (Feature 3 happens automatically here)
        ChatMessage message = new ChatMessage();
        message.setStudentName(studentName);
        message.setQuestion(question);
        message.setAnswer(answer);
        repository.save(message);

        return answer;
    }

    @Override
    public List<ChatMessage> getHistory(String studentName) {
        return repository.findByStudentName(studentName);
    }
}