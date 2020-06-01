package com.kalaiworld.feedback.api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "question")
@Data
@ToString(exclude = {"questionnaire"})
@EqualsAndHashCode(exclude = {"questionnaire"})
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String type;
    private String options;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Questionnaire questionnaire;

}

