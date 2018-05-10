package com.sweaters.projects.mysweat.repository;

import com.sweaters.projects.mysweat.entity.exercise.ExerciseRawData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ExerciseDataRepository {
	public List<ExerciseRawData> get(String userId, String fromDate, String toDate) {
		return new ArrayList<>();
	}
}
