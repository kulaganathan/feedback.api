package com.kalaiworld.feedback.api.controller;

import com.kalaiworld.feedback.api.dto.QuestionDto;
import com.kalaiworld.feedback.api.dto.QuestionnaireDto;
import com.kalaiworld.feedback.api.model.Question;
import com.kalaiworld.feedback.api.model.Questionnaire;
import com.kalaiworld.feedback.api.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class QuestionnaireController {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @PostMapping
    public Questionnaire createQuestionnaire(@RequestBody QuestionnaireDto questionnaireDto) {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setIsDefault(questionnaireDto.getIsDefault());
        questionnaire.setTemplateName(questionnaireDto.getTemplateName());
        questionnaire.setCompanyName(questionnaireDto.getCompanyName());
        questionnaire.setInterviewDate(questionnaireDto.getInterviewDate());
        questionnaire.setPosition(questionnaireDto.getPosition());
        questionnaire.setResponseLimit(questionnaireDto.getResponseLimit());
        List<QuestionDto> questionsDto = questionnaireDto.getQuestions();
        List<Question> questions = new ArrayList<>();
        questionsDto.forEach(questionDto -> {
            Question question = new Question();
            question.setDescription(questionDto.getDescription());
            question.setOptions(questionDto.getOptions().get(0));
            question.setType(questionDto.getType().name());
        });
        questionnaire.setQuestions(questions);
        questionnaire.setQuestionnaireId(UUID.randomUUID().toString());
        return questionnaireRepository.save(questionnaire);
    }
}
