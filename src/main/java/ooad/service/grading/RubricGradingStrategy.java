package ooad.service.grading;

import ooad.model.Submission;
import org.springframework.stereotype.Component;

@Component
public class RubricGradingStrategy implements GradingStrategy {
    @Override
    public int grade(Submission submission) {
        String content = submission.getContent();
        if (content == null || content.isBlank()) return 0;
        int contentScore   = content.length() > 150 ? 40 : 20;
        int structureScore = content.split("\n").length > 2 ? 30 : 15;
        int depthScore     = content.split(" ").length > 50 ? 30 : 15;
        return contentScore + structureScore + depthScore;
    }
    @Override
    public String getStrategyName() { return "RUBRIC"; }
}