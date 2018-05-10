package com.sweaters.projects.mysweat.controller;

import com.sweaters.projects.mysweat.entity.ApiResponse;
import com.sweaters.projects.mysweat.entity.MessageSet;
import com.sweaters.projects.mysweat.entity.exercise.ExerciseBatchData;
import com.sweaters.projects.mysweat.entity.exercise.ExerciseMeanData;
import com.sweaters.projects.mysweat.service.ExerciseDataService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exercise_data")
public class ExerciseDataController {
	@Autowired
	ExerciseDataService exerciseDataService;

	@RequestMapping(value = "/sync", method = RequestMethod.GET)
	public ApiResponse syncExerciseData(String userId, String deviceId) {
		ApiResponse result = new ApiResponse();
		DateTime currentDateTime = DateTime.now();

		List<ExerciseBatchData> exerciseBatchDataList = exerciseDataService.syncExerciseData(userId, deviceId,
			currentDateTime);
		result.setSuccessful(true);
		result.setMessage(MessageSet.OK);
		result.setHasReturnObject(true);
		result.setReturnObject(exerciseBatchDataList);

		return result;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ApiResponse getExerciseBatchDataList(String userId, String fromDate, String toDate) {
		ApiResponse result = new ApiResponse();

		List<ExerciseBatchData> exerciseBatchDataList = exerciseDataService.getExerciseBatchDataList(userId, fromDate,
			toDate);
		result.setSuccessful(true);
		result.setMessage(MessageSet.OK);
		result.setHasReturnObject(true);
		result.setReturnObject(exerciseBatchDataList);

		return result;
	}

	@RequestMapping(value = "/get_mean_data", method = RequestMethod.GET)
	public ApiResponse getExerciseMeanDataList() {
		ApiResponse result = new ApiResponse();

		List<ExerciseMeanData> exerciseMeanDataList = exerciseDataService.getExerciseMeanData();
		result.setSuccessful(true);
		result.setMessage(MessageSet.OK);
		result.setHasReturnObject(true);
		result.setReturnObject(exerciseMeanDataList);

		return result;
	}

	@RequestMapping(value = "/set", method = RequestMethod.POST)
	public ApiResponse setExerciseRawData(String userId, String consoleId, String tagId, String startDate,
		String elapsedTime, String sensoredRawDataValue) {
		return new ApiResponse();
	}
}