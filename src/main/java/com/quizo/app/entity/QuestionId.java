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
public class QuestionId {

	@ManyToOne
	@JoinColumn(name = "BELONGS_TO")
	private Quiz belongsTo;

	private Integer number;
}
