package com.oep.wrapper.core.grading.domain.question;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
public abstract class Question<T extends Answer> {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @OneToOne
    private Answer answer;
    private float pointsWorth;
    private boolean automaticGradable;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
