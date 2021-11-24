package com.oep.wrapper.core.grading.domain.gradingsystem;

public interface GradingSystem {
    String calcGrade(float scored, float maxAmount);
    String calcAverage(String[] grades);
}
