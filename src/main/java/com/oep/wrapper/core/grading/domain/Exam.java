package com.oep.wrapper.core.grading.domain;

import com.oep.wrapper.core.grading.domain.gradingsystem.GradingSystem;
import com.oep.wrapper.core.grading.domain.question.Question;

import javax.persistence.*;
import java.util.List;

@Entity
public class Exam implements Gradable {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Transient
    private GradingSystem gradingSystem;
    @OneToMany
    private List<Attempt> attempts;
    @OneToMany
    private List<Question> questions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
