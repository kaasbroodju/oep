package com.oep.wrapper.core.grading.domain.gradingsystem;

public class DutchGrade extends Grade {
    public DutchGrade(float maxScore, float amountScored) {
        super(maxScore, amountScored);
    }

    @Override
    protected boolean isInsufficient(float result) {
        return result >= 5.5;
    }

    @Override
    protected float calcResult(float maxScore, float amountScored) {
        return 9 * amountScored / maxScore + 1;
    }

    @Override
    public String toString() {
        return String.valueOf(result);
    }
}
