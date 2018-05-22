package com.sweaters.projects.mysweat.entity.exercise;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExerciseData {
	private String consoleId;
	private String exerciseName;
	private String bodyPart;
	private String tagId;
	private String startDateTime;
	private long elapsedTime;
	private long performedTime;
	private int work;
	private int calorie;

	private List<ExerciseSetData> exerciseSetDataList;

	public ExerciseData() {
		this.exerciseSetDataList = new ArrayList<>();
	}

	public ExerciseData(String consoleId, String tagId, String startDateTime, long elapsedTime) {
		this();
		this.consoleId = consoleId;
		this.tagId = tagId;
		this.startDateTime = startDateTime;
		this.elapsedTime = elapsedTime;
	}

	public ExerciseData(String consoleId, String exerciseName, String bodyPart, String tagId, String startDateTime,
	                    long
			                    elapsedTime) {
		this(consoleId, tagId, startDateTime, elapsedTime);
		this.exerciseName = exerciseName;
		this.bodyPart = bodyPart;
	}

	public void addExerciseSetData(ExerciseSetData exerciseSetData) {
		exerciseSetDataList.add(exerciseSetData);

		this.performedTime += exerciseSetData.getElapsedTime();
		this.work += exerciseSetData.getWork();
		this.calorie += exerciseSetData.getCalorie();
	}
}
