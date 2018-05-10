package com.sweaters.projects.mysweat;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BasicTests {
	@Test
	public void subStringTest1() {
		String value = "20180421";
		String actual = value.substring(0, 4);
		String expected = "2018";

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void subStringTest2() {
		String value = "20180421";
		String actual = value.substring(4, 6);
		String expected = "04";

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void subStringTest3() {
		String value = "20180421";
		String actual = value.substring(6, 8);
		String expected = "21";

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void dateStringTest1() {
		String dateFormat = "yyyyMMdd HH:mm:ss";
		String expected = "20180101 12:00:00";
		String actual = new DateTime(2018, 1, 1, 12, 0, 0).toString(dateFormat);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void dateStringTest2() {
		String dateFormat = "yyyyMMdd HH:mm:ss";
		String expected = "20180421 13:30:12";
		String actual = new DateTime(2018, 4, 21, 13, 30, 12).toString(dateFormat);

		Assert.assertEquals(expected, actual);
	}
}
