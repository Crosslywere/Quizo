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
@Table(name = "QUIZZES")
public class Quiz {

	@Id
	@GeneratedValue
	private String id;

	@ManyToOne
	private Creator creator;

	@OneToMany(orphanRemoval = true)
	private List<Player> examinees;

	private String title;

	@Builder.Default
	private boolean inviteOnly = true;

	@Builder.Default
	private boolean reentryAllowed = true;

	@OneToMany(orphanRemoval = true)
	private List<Question> questions;

	private int questionsPerPlayer;

	@Builder.Default
	private boolean shuffleQuestions = false;

}
