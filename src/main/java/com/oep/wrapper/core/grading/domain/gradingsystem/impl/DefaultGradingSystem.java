package com.oep.wrapper.core.grading.domain.gradingsystem.impl;

import com.oep.wrapper.core.grading.domain.gradingsystem.GradingSystem;

public class DefaultGradingSystem implements GradingSystem {
    public String calcGrade(float scored, float maxAmount) {
        return String.valueOf(9 * scored / maxAmount + 1);
    }

    @Override
    public String calcAverage(String[] grades) {
        return null;
    }

//    @Override
//    public String calcAverage(Grade[] grades) {
//        return String.valueOf(
//                Arrays.stream(grades).mapToDouble(s -> s).sum() / grades.length);
//    }
}
