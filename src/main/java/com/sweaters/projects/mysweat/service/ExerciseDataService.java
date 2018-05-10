package com.sweaters.projects.mysweat.service;

import com.sweaters.projects.mysweat.entity.exercise.ExerciseBatchData;
import com.sweaters.projects.mysweat.entity.exercise.ExerciseData;
import com.sweaters.projects.mysweat.entity.exercise.ExerciseMeanData;
import com.sweaters.projects.mysweat.entity.exercise.ExerciseRawData;
import com.sweaters.projects.mysweat.repository.ExerciseDataRepository;
import com.sweaters.projects.mysweat.util.ExerciseDataUtil;
import com.sweaters.projects.mysweat.util.MockupDataUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseDataService {
	@Autowired
	ExerciseDataRepository exerciseDataRepository;

	public List<ExerciseBatchData> syncExerciseData(String userId, String deviceId, DateTime dateTime) {
		return MockupDataUtil.getExerciseBatchDataList();
	}

	public List<ExerciseBatchData> getExerciseBatchDataList(String userId, String fromDate, String toDate) {
		List<ExerciseRawData> exerciseRawDataList = exerciseDataRepository.get(userId, fromDate, toDate);

		List<ExerciseData> exerciseDataList = new ArrayList<>();
		for (ExerciseRawData rawData : exerciseRawDataList) {
			exerciseDataList.add(ExerciseDataUtil.convertRawDataToData(rawData));
		}

		List<ExerciseBatchData> result = ExerciseDataUtil.convertDataListToBatchDataList(exerciseDataList, fromDate,
			toDate);

		return result;
	}

	public List<ExerciseMeanData> getExerciseMeanData() {
		return MockupDataUtil.getExerciseMeanDataList();
	}
}
