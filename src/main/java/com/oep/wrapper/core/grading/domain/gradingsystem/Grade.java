package com.oep.wrapper.core.grading.domain.gradingsystem;

import lombok.Getter;

@Getter
public abstract class Grade {
    protected float result;
    protected boolean isInsufficient;

    public Grade(float maxScore, float amountScored) {
        float temp = calcResult(maxScore, amountScored);
        this.result = temp;
        this.isInsufficient = isInsufficient(temp);
    }

    protected abstract boolean isInsufficient(float result);
    protected abstract float calcResult(float maxScore, float amountScored);
    public abstract String toString();
}
