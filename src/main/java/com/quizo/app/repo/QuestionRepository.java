package com.quizo.app.repo;

import com.quizo.app.entity.Question;
import com.quizo.app.entity.QuestionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, QuestionId> {
}
