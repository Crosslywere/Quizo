package com.quizo.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "QUESTIONS")
public class Question {

	@EmbeddedId
	private QuestionId questionId;

	private String question;

	private String answer;

	@Enumerated(EnumType.STRING)
	private Type type;

	private List<String> options;

	@Builder.Default
	private boolean shuffleOptions = false;

	@Builder.Default
	private boolean answerCaseSensitive = false;

	public enum Type {
		OBJECTIVE, SUBJECTIVE
	}

}
