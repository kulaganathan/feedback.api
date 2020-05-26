package com.kalaiworld.feedback.api.repository;

import com.kalaiworld.feedback.api.model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, String> {

    List<Questionnaire> findAll();

    Questionnaire findByQuestionnaireId(String id);
}
