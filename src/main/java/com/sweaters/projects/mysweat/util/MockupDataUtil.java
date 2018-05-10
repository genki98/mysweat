package com.sweaters.projects.mysweat.util;

import com.sweaters.projects.mysweat.entity.exercise.ExerciseBatchData;
import com.sweaters.projects.mysweat.entity.exercise.ExerciseData;
import com.sweaters.projects.mysweat.entity.exercise.ExerciseMeanData;
import com.sweaters.projects.mysweat.entity.exercise.ExerciseSetData;
import com.sweaters.projects.mysweat.entity.tag.TagInfo;
import com.sweaters.projects.mysweat.entity.user.UserAccount;
import com.sweaters.projects.mysweat.entity.user.UserRank;

import java.util.ArrayList;
import java.util.List;

public class MockupDataUtil {
	private String DATE_FORMAT = "yyyyMMdd HH:mm:ss";

	public static UserAccount getUserAccount() {
		return getUserAccount(181, 75);
	}

	public static UserAccount getUserAccount(double height, double weight) {
		UserAccount result = new UserAccount();

		result.setId("A000001");
		result.setEmail("test_user@sweaters.kr");
		result.setPassword("abcdefg");
		result.setName("test_user");
		result.setGender("GENDER_MALE");
		result.setBirthYear("2018");
		result.setCellphone("01012345678");
		result.setHeight(height);
		result.setWeight(weight);
		result.setUserRank(new UserRank("왕초보", 1));

		return result;
	}

	public static String getIdentificationCode() {
		return "Q1WH89";
	}

	public static String getEmail() {
		return "test_user@sweaters.kr";
	}

	public static String getPassword() {
		return "a1b2c3d4";
	}

	public static List<ExerciseBatchData> getExerciseBatchDataList() {
		List<ExerciseBatchData> result = new ArrayList<>();

		String[] dateArray = { "20180419 12:00:00", "20180420 12:01:00", "20180421 12:05:00", "20180421 18:50:00" };
		int[] sequenceArray = { 0, 0, 0, 1 };
		long[] elapsedTimeArray = { 3060000, 3180000, 2940000, 3000000 };

		String[][] consoleIdArray = {
			{ "b_247834", "i_349823", "p_985743", "a_138846", "c_998341" },
			{ "l_568323", "s_971364", "a_138845", "c_998341", "b_574233" },
			{ "o_754833", "c_998341", "c_998341", "p_985743", "s_075523" },
			{ "l_523231", "l_142534", "l_246744", "l_632562", "t_834746" }
		};
		String[][] exerciseNameArray = {
			{ "benchPress", "inclineBenchPress", "pecDeckFly", "assistedDip", "cableMachine" },
			{ "latPullDown", "seatedRow", "assistedPullup", "cableMachine", "bicepsCurl" },
			{ "overHeadPress", "", "", "pecDeckFly", "seatedAbCrunch" },
			{ "legPress", "legExtension", "legCurl", "legAbduction", "torsoRotation" }
		};

		String[] tagIdArray = { "lockerkey_001", "lockerkey_002", "lockerkey_003", "myphone_001" };

		String[][] startDateTimeArray = {
			{ "20180419 12:05:00", "20180419 12:11:30", "20180419 12:17:13", "20180419 12:31:21", "20180419 12:38:57" },
			{ "20180420 12:04:00", "20180420 12:10:07", "20180420 12:20:01", "20180420 12:31:17", "20180420 12:44:41" },
			{ "20180421 12:11:00", "20180421 12:17:01", "20180421 12:24:58", "20180421 12:33:01", "20180421 12:41:51" },
			{ "20180421 18:59:00", "20180421 19:02:40", "20180421 19:10:44", "20180421 19:21:59", "20180421 19:29:39" }
		};

		long[][] setElapsedTimeArray = {
			{ 300000, 330000, 340000, 290000, 350000 },
			{ 295000, 312000, 328000, 301000, 325000 },
			{ 299000, 309000, 319000, 311000, 300500 },
			{ 303000, 300000, 390000, 340000, 320100 }
		};

		for (int i = 0; i < dateArray.length; i++) {
			ExerciseBatchData batchData = new ExerciseBatchData(dateArray[i], sequenceArray[i], elapsedTimeArray[i]);
			List<ExerciseData> exerciseDataList = getExerciseDataList(consoleIdArray[i], exerciseNameArray[i],
				tagIdArray[i], startDateTimeArray[i], setElapsedTimeArray[i]);

			for (ExerciseData exerciseData : exerciseDataList) {
				batchData.addExercise(exerciseData);
			}

			result.add(batchData);
		}

		return result;
	}

	public static List<ExerciseData> getExerciseDataList(String[] consoleIdArray, String[] exerciseNameArray,
		String tagId, String[] startDateTimeArray, long[] elapsedTimeArray) {
		List<ExerciseData> result = new ArrayList<>();

		int[] setNoArray = { 1, 2, 3, 4, 4 };
		long[] setElapsedTimeArray = { 30000, 32000, 35000, 33000, 30000 };
		long[] setPerformedTimeArray = { 25000, 29000, 31000, 28000, 27000 };
		int[] weightArray = { 40, 60, 80, 80, 60 };
		int[] repeatArray = { 20, 20, 15, 12, 15 };
		double[] workArray = { 50, 60, 70, 65, 55 };

		for (int i = 0; i < consoleIdArray.length; i++) {
			ExerciseData exerciseData = new ExerciseData(consoleIdArray[i], exerciseNameArray[i], tagId,
				startDateTimeArray[i], elapsedTimeArray[i]);
			List<ExerciseSetData> setDataList = getExerciseSetDataList(setNoArray, setElapsedTimeArray,
				setPerformedTimeArray, weightArray, repeatArray, workArray);
			for (ExerciseSetData setData : setDataList) {
				exerciseData.addExerciseSetData(setData);
			}

			result.add(exerciseData);
		}

		return result;
	}

	public static List<ExerciseSetData> getExerciseSetDataList(int[] setNoArray, long[] elapsedTimeArray,
		long[] performedTimeArray, int[] weightArray, int[] repeatArray, double[] workArray) {
		List<ExerciseSetData> result = new ArrayList<>();

		for (int i = 0; i < setNoArray.length; i++) {
			result.add(new ExerciseSetData(setNoArray[i], elapsedTimeArray[i], performedTimeArray[i], weightArray[i],
				repeatArray[i], workArray[i], workArray[i] / 4.189));
		}

		return result;
	}

	public static List<ExerciseMeanData> getExerciseMeanDataList() {
		List<ExerciseMeanData> result = new ArrayList<>();

		String[] exerciseIdArray = {
			"chest_0001", "chest_0002", "chest_0003", "chest_0004", "arm_0001",
			"back_0001", "back_0002", "back_0003", "back_0004", "arm_0002",
			"shoulder_0001", "shoulder_0002", "shoulder_0003", "shoulder_0004", "abs_0001",
			"leg_0001", "leg_0002", "leg_0003", "leg_0004", "abs_0002"
		};
		String[] exerciseNameArray = {
			"benchPress", "inclineBenchPress", "pecDeckFly", "assistedDip", "cableMachine",
			"latPullDown", "seatedRow", "assistedPullup", "cableMachine", "bicepsCurl",
			"overHeadPress", "lateralize", "militaryPress", "rearDeltoid", "torsoRotation",
			"legPress", "legExtension", "legCurl", "legAbduction", "seatedAbCrunch"
		};
		long[] meanElapsedTimeArray = {
			320000, 310000, 305000, 350000, 300000,
			330000, 320000, 325000, 340000, 295000,
			325000, 324000, 307000, 335000, 340000,
			390000, 340000, 335000, 280000, 295000
		};
		long[] meanPerformedTimeArray = {
			270000, 280000, 280000, 310000, 270000,
			295000, 285000, 280000, 300000, 265000,
			280000, 290000, 277000, 300000, 300500,
			290000, 280000, 275000, 230000, 250000
		};
		int[] meanWeightArray = {
			55, 40, 25, 40, 30,
			60, 70, 10, 50, 25,
			30, 15, 25, 10, 60,
			200, 80, 50, 90, 30
		};
		double[] meanWorkArray = {
			50.7, 43.4, 30.1, 45.2, 38.1,
			57.0, 70.1, 20.3, 60.5, 40.2,
			30.1, 25.1, 40.3, 20.1, 60.8,
			100.7, 90.7, 54.3, 78.3, 57.2
		};

		for (int i = 0; i < exerciseIdArray.length; i++) {
			result.add(new ExerciseMeanData(exerciseIdArray[i], exerciseNameArray[i], meanElapsedTimeArray[i],
				meanPerformedTimeArray[i], meanWeightArray[i], meanWorkArray[i], meanWorkArray[i] / 4.19));
		}

		return result;
	}

	public static List<TagInfo> getTagInfoList() {
		List<TagInfo> result = new ArrayList<>();

		result.add(new TagInfo("nsd2flk1", "my_iPod", "20180221 14:21:10", ""));
		result.add(new TagInfo("gd3dfl12", "my_galaxy8", "20180311 09:25:10", ""));

		return result;
	}
}
