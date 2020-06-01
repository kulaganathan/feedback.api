package com.kalaiworld.feedback.api.controller;

import com.kalaiworld.feedback.api.dto.QuestionnaireDto;
import com.kalaiworld.feedback.api.model.Questionnaire;
import com.kalaiworld.feedback.api.service.QuestionnaireService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questionnaire")
@Slf4j
public class QuestionnaireController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @PostMapping
    public ResponseEntity<String> createQuestionnaire(@RequestBody QuestionnaireDto questionnaireDto) {
        log.info("Create Questionnaire API");
        return new ResponseEntity<String>(questionnaireService.saveQuestionnaire(questionnaireDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Questionnaire> getQuestionnaire(Long id) {
        log.info("Get Questionnaire API");
        return new ResponseEntity<Questionnaire>(questionnaireService.getQuestionnaire(id), HttpStatus.OK);
    }

}
