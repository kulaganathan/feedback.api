package com.kalaiworld.feedback.api.controller;

import com.kalaiworld.feedback.api.dto.QuestionnaireDto;
import com.kalaiworld.feedback.api.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionnaireController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @PostMapping
    public String createQuestionnaire(@RequestBody QuestionnaireDto questionnaireDto) {
        return questionnaireService.saveQuestionnaire(questionnaireDto);
    }

}
