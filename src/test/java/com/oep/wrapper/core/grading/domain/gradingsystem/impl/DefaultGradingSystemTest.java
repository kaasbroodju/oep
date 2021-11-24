package com.oep.wrapper.core.grading.domain.gradingsystem.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultGradingSystemTest {
    private DefaultGradingSystem system;

    @BeforeEach
    void init() {
        system = new DefaultGradingSystem();
    }

    @Test
    void calcGradeHigh() {
        assertEquals("10.0", system.calcGrade(20f, 20f));
    }

    @Test
    void calcGradeMiddle() {
        assertEquals("5.5", system.calcGrade(10f, 20f));
    }

    @Test
    void calcGradeLow() {
        assertEquals("1.0", system.calcGrade(0f, 20f));
    }

    @Test
    void calcAverage() {
    }
}