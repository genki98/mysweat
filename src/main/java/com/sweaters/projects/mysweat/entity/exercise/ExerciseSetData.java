package com.sweaters.projects.mysweat.entity.exercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseSetData {
	private int setNo;
	private long elapsedTime;
	private long performedTime;
	private int weight;
	private int repeat;
	private double work;
	private double calorie;
}
