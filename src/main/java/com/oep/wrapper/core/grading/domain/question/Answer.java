package com.oep.wrapper.core.grading.domain.question;

import javax.persistence.*;

@Entity
public abstract class Answer {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
}
