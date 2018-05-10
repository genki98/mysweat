package com.sweaters.projects.mysweat.entity.exercise;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExerciseRepeatData {
	// 1회 반복 수행시간
	private long totalTime;
	// 실제로 운동을 한 시간
	private long actualTime;
	// 수행 중량
	private int weight;

	private int work;
	private int calorie;

	private ExerciseUnitData contractionData;
	private ExerciseUnitData relaxationData;

	public ExerciseRepeatData(long totalTime, int weight) {
		this.totalTime = totalTime;
		this.weight = weight;
	}

	public void setContractionData(ExerciseUnitData contractionData) {
		this.contractionData = contractionData;
		this.actualTime += contractionData.getMillisecond();
		this.work += contractionData.getWork();
		this.calorie += contractionData.getCalorie();
	}

	public void setRelaxationData(ExerciseUnitData relaxationData) {
		this.relaxationData = relaxationData;
		this.actualTime += relaxationData.getMillisecond();
		this.work += relaxationData.getWork();
		this.calorie += relaxationData.getCalorie();
	}
}
