package com.quizo.app.repo;

import com.quizo.app.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, String> {
}
