package com.oep.wrapper.core.grading.domain;

import com.oep.wrapper.core.grading.domain.question.Answer;
import com.oep.wrapper.core.grading.domain.question.Question;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity @Getter @Setter
public class AttemptQuestion {
    @Id
    @Column(name = "attempt_id", nullable = false)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "attempt_id", referencedColumnName = "id")
    private Attempt attempt;

    @OneToOne
    private Question question;

    @OneToOne
    private Answer answer;
    private Float pointsRewarded; // must be nullable for question that should be graded manually
}
