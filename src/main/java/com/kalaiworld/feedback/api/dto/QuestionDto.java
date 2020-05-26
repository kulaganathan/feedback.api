package com.kalaiworld.feedback.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDto {

    private String description;
    private QuestionType type;
    private List<String> options;

}

