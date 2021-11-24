package com.oep.wrapper.core.grading.domain.gradingsystem;

public class DutchPhysicalEducationGrade extends Grade {
    public DutchPhysicalEducationGrade(float maxScore, float amountScored) {
        super(maxScore, amountScored);
    }

    @Override
    protected boolean isInsufficient(float result) {
        return result < 5.5;
    }

    @Override
    protected float calcResult(float maxScore, float amountScored) {
        return new DutchGrade(maxScore, amountScored).getResult();
    }

    @Override
    public String toString() {
        if (result >= 9) {
            return "U";
        } else if (result >= 7) {
            return "G";
        } else if (result >= 5.5) {
            return "V";
        } else {
            return "O";
        }
    }
}
