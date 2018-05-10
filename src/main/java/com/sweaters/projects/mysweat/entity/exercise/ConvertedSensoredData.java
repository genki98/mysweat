package com.sweaters.projects.mysweat.entity.exercise;

import lombok.Data;

@Data
public class ConvertedSensoredData {
	// 운동수행시간
	private long millisecond;
	// 힘
	private int force;
	// 이동거리
	private int displacement;
}
