package com.oep.wrapper.core.grading.domain;

public class Assignment implements Gradable {
    @Override
    public float getMaxPoints() {
        return 0;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
