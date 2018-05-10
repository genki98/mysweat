package com.sweaters.projects.mysweat.entity.exercise;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExerciseUnitData {
	private long millisecond;
	// 운동량 = 수행한 운동의 총량 = 일
	// force * displacement = work, Joule
	private double work;
	// 소모한 칼로리량
	// 1 calorie = 4.184 Joule, 1Kcal = 4184
	// https://www.google.co.kr/search?q=calorie+joule&oq=calorie+joule&aqs=chrome..69i57j6j0.3104j0j7&sourceid=chrome&ie=UTF-8
	private double calorie;

	public ExerciseUnitData(long millisecond, double work) {
		this.millisecond = millisecond;
		this.work = work;
		this.calorie = work / 4.184;
	}
}
