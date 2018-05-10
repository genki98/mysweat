package com.sweaters.projects.mysweat.entity.exercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseMeanData {
	private String exerciseId;
	private String exerciseName;
	private long meanElapsedTime;
	private long meanPerformedTime;
	private int meanWeight;
	private double meanWork;
	private double meanCalorie;
}
