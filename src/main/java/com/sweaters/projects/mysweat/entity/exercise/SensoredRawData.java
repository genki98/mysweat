package com.sweaters.projects.mysweat.entity.exercise;

import lombok.Data;

@Data
public class SensoredRawData {
	private long timeStamp;

	private int tensileForce;

	private int angularX;
	private int angularY;
	private int angularZ;

	private int accelerationX;
	private int accelerationY;
	private int accelerationZ;
}
