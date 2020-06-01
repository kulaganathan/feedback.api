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
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        Set<Question> questions = new HashSet<>();
        List<QuestionDto> questionsDto = questionnaireDto.getQuestions();
        questionsDto.forEach(questionDto -> {
            Question question = new Question();
            question.setQuestionnaire(questionnaire);
            question.setDescription(questionDto.getDescription());
            if (questionDto.getOptions() != null) {
                question.setOptions(questionDto.getOptions().toString());
            }
            question.setType(questionDto.getType().name());
            log.info("Question: " + question.toString());
            questions.add(question);
        });
        questionnaire.setIsDefault(questionnaireDto.getIsDefault());
        questionnaire.setTemplateName(questionnaireDto.getTemplateName());
        questionnaire.setCompanyName(questionnaireDto.getCompanyName());
        questionnaire.setInterviewDate(questionnaireDto.getInterviewDate());
        questionnaire.setPosition(questionnaireDto.getPosition());
        questionnaire.setResponseLimit(questionnaireDto.getResponseLimit());
        questionnaire.setQuestions(questions);
        Questionnaire response = questionnaireRepository.save(questionnaire);
        log.info("Saved questionnaire: " + response.toString());
        Questionnaire toUpdate = questionnaireRepository.findById(response.getId()).get();
        log.info("Retreived questionnaire: " + response.toString());

//        Questionnaire updatedQuestionnaire = questionnaireRepository.save(toUpdate);
//        questionnaire.setQuestions(questions);
//        questionnaire.setId(UUID.randomUUID().toString());
//        log.info("Updated questionnaire: " + updatedQuestionnaire.toString());
//        log.info("Questionnaire Id: " + updatedQuestionnaire.getId().toString());
        log.info("Questions size after updated questionnaire: " + toUpdate.getQuestions().size());
//        questions.forEach(question -> {
//            Question questionResponse = questionRepository.save(question);
//            log.info("Saved question id: " + questionResponse.getId());
//        });
        return response.getId().toString();
    }

    public Questionnaire getQuestionnaire(Long id) {
        log.info("Inside Get Questionnaire service.");
        Optional<Questionnaire> optionalQuestionnaire = questionnaireRepository.findById(id);
        return optionalQuestionnaire.get();
    }
}

