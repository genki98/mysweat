package com.sweaters.projects.mysweat.util;

import com.sweaters.projects.mysweat.entity.exercise.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ExerciseDataUtil {
	public static ExerciseData convertRawDataToData(ExerciseRawData rawData) {
		ExerciseData result = new ExerciseData();

		result.setConsoleId(rawData.getConsoleId());

		List<SensoredRawData> sensoredRawDataList = rawData.getSensoredRawDataList();
		for(SensoredRawData sensoredRawData : sensoredRawDataList) {

		}

		return result;
	}

	public static List<ExerciseBatchData> convertDataListToBatchDataList(List<ExerciseData> exerciseDataList,
		String fromDate, String toDate) {
		Calendar calendar = getCalendar(fromDate);

		return new ArrayList<>();
	}

	private static Calendar getCalendar(String date) {
		Calendar calendar = Calendar.getInstance();
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(4, 6));
		int day = Integer.parseInt(date.substring(6, 8));
		calendar.set(year, month, day);

		return calendar;
	}
}
