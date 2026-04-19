package ooad.service.grading;

import ooad.model.Submission;
import org.springframework.stereotype.Component;

@Component
public class AutoGradingStrategy implements GradingStrategy {
    @Override
    public int grade(Submission submission) {
        String content = submission.getContent();
        if (content == null || content.isBlank()) return 0;
        int score = 0;
        if (content.length() > 200) score += 40;
        else if (content.length() > 100) score += 25;
        else score += 10;
        if (content.contains("because") || content.contains("therefore")) score += 20;
        if (content.contains("example") || content.contains("for instance")) score += 20;
        if (content.split("\\.").length > 3) score += 20;
        return Math.min(score, 100);
    }
    @Override
    public String getStrategyName() { return "AUTO"; }
}