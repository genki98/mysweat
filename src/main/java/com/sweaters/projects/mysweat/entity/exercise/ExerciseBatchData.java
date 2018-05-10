package com.sweaters.projects.mysweat.entity.exercise;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExerciseBatchData {
	private String startDateTime;
	private int sequence;
	private long elapsedTime;
	private long performedTime;
	private int work;
	private int calorie;

	public List<ExerciseData> exerciseDataList;

	public ExerciseBatchData() {
		this.exerciseDataList = new ArrayList<>();
	}

	public ExerciseBatchData(String startDateTime, int sequence, long elapsedTime) {
		this();
		this.startDateTime = startDateTime;
		this.sequence = sequence;
		this.elapsedTime = elapsedTime;
	}

	public void addExercise(ExerciseData exerciseData) {
		exerciseDataList.add(exerciseData);

		performedTime += exerciseData.getElapsedTime();
		work += exerciseData.getWork();
		calorie += exerciseData.getCalorie();
	}
}
