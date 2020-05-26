package com.kalaiworld.feedback.api.service;

import com.kalaiworld.feedback.api.dto.QuestionDto;
import com.kalaiworld.feedback.api.dto.QuestionnaireDto;
import com.kalaiworld.feedback.api.model.Question;
import com.kalaiworld.feedback.api.model.Questionnaire;
import com.kalaiworld.feedback.api.repository.QuestionRepository;
import com.kalaiworld.feedback.api.repository.QuestionnaireRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class QuestionnaireService {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Transactional
    public String saveQuestionnaire(QuestionnaireDto questionnaireDto) {
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
            log.info("Question: " + question.toString());
            questions.add(question);
        });
        questionnaire.setQuestions(questions);
        questionnaire.setQuestionnaireId(UUID.randomUUID().toString());
        Questionnaire response = questionnaireRepository.save(questionnaire);
        log.info("Saved questionnaire: " + response.toString());
        log.info("Questionnaire Id: " + response.getQuestionnaireId());
        log.info("Questions size after saved questionnaire: " + questions.size());
        questions.forEach(question -> {
            question.setQuestionnaire(response);
            Question questionResponse = questionRepository.save(question);
            log.info("Saved question id: " + questionResponse.getId());
        });
        return response.getQuestionnaireId();
    }
}

