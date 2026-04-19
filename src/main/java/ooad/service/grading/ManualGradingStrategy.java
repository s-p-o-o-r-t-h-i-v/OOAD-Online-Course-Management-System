package ooad.service.grading;

import ooad.model.Submission;
import org.springframework.stereotype.Component;

@Component
public class ManualGradingStrategy implements GradingStrategy {
    @Override
    public int grade(Submission submission) {
        return submission.getGrade() != null ? submission.getGrade() : 0;
    }
    @Override
    public String getStrategyName() { return "MANUAL"; }
}