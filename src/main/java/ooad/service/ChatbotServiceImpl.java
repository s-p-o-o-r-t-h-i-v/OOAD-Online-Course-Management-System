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

    private ChatbotAdapter chatbotAdapter;

    public ChatbotServiceImpl() {
        this.chatbotAdapter = new RuleBasedChatbotAdapter();
    }

    @Override
    public String askQuestion(String studentName, String question, String role) {

        // Pass role to adapter so chatbot can give role-aware answers
        String answer = chatbotAdapter.processQuery(question, role);

        // Save to DB
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