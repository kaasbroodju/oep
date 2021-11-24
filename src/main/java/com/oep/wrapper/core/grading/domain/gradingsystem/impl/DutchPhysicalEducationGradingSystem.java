package com.oep.wrapper.core.grading.domain.gradingsystem.impl;

import com.oep.wrapper.core.grading.domain.gradingsystem.GradingSystem;

public class DutchPhysicalEducationGradingSystem implements GradingSystem {

    private static final DefaultGradingSystem defaultGradingSystem = new DefaultGradingSystem();

    @Override
    public String calcGrade(float scored, float maxAmount) {
        float grade = Float.parseFloat(defaultGradingSystem.calcGrade(scored, maxAmount));
        if (grade >= 9) {
            return "U";
        } else if (grade >= 7) {
            return "G";
        } else if (grade >= 5.5) {
            return "V";
        } else {
            return "O";
        }
    }

    @Override
    public String calcAverage(String[] grades) {

        return "G";
    }
}
