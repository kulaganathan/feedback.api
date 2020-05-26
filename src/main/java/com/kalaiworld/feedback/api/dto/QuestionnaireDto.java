package com.kalaiworld.feedback.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class QuestionnaireDto {

    private Boolean isDefault;
    private String templateName;
    private String companyName;
    private int responseLimit;
    private String position;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Zagreb")
    private LocalDate interviewDate;
    private List<QuestionDto> questions;

}
