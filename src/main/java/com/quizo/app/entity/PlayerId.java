package com.quizo.app.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PlayerId {

	@ManyToOne
	@JoinColumn(name = "QUIZ_TAKEN")
	private Quiz quizTaken;

	// Possible collisions waiting to happen when trying to find player in database
	// Possible solution - intercept incoming request and manipulate data to include some of the quiz details when logging in
	private String registrationDetail;

}
