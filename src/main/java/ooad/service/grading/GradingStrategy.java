package ooad.service.grading;

import ooad.model.Submission;

public interface GradingStrategy {
    int grade(Submission submission);
    String getStrategyName();
}