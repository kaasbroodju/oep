package com.oep.wrapper.core.grading.domain;

import com.oep.wrapper.core.grading.domain.question.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Attempt {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @OneToMany
    private List<AttemptQuestion> answers;
}
