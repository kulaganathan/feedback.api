package com.kalaiworld.feedback.api.repository;

import com.kalaiworld.feedback.api.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
