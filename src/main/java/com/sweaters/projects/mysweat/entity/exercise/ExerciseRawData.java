package com.sweaters.projects.mysweat.entity.exercise;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ExerciseRawData {
	private String userId;
	private String consoleId;
	private String tagId;
	private Date startDate;
	private long elapsedMilliseconds;

	private List<SensoredRawData> sensoredRawDataList;
}
