package com.kalaiworld.feedback.api.controller;

import com.kalaiworld.feedback.api.dto.QuestionnaireDto;
import com.kalaiworld.feedback.api.model.Questionnaire;
import com.kalaiworld.feedback.api.service.QuestionnaireService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questionnaire")
@Slf4j
public class QuestionnaireController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @PostMapping
    public String createQuestionnaire(@RequestBody QuestionnaireDto questionnaireDto) {
        return questionnaireService.saveQuestionnaire(questionnaireDto);
    }

    @GetMapping
    public Questionnaire getQuestionnaire(String id) {
        return questionnaireService.getQuestionnaire(id);
    }

}
