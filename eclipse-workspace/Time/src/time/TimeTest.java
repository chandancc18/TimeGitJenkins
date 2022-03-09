package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	
	@Test
	public void testGetTotalSecondsGood() 
	{
		int seconds = Time.getTotalSeconds("05:05:05");
		assertTrue("The seconds were not calculated properly", seconds==18305);
	}

	@Test
	public void testGetTotalSecondsBad() 
	{
	assertThrows(
	 StringIndexOutOfBoundsException.class, 
	 ()-> {Time.getTotalSeconds("10:00");});
	}
	
	@Test
	public void testGetTotalSecondsBoundaryLower() 
	{
		int seconds = Time.getTotalSeconds("05:00:00");
		assertTrue("The seconds were not calculated properly", seconds==18000);
	}
	
	@Test
	public void testGetTotalSecondsBoundaryUpper() 
	{
		int seconds = Time.getTotalSeconds("05:59:59");
		assertTrue("The seconds were not calculated properly", seconds==21599);
	}


	@Test
	void testGetSecondsGood() {
		int seconds = Time.getSeconds("05:59:57");
		assertTrue("The seconds were not calculated properly", seconds==57);
	}
	
	@Test
	public void testGetSecondsBoundaryLower() 
	{
		int seconds = Time.getSeconds("05:00:00");
		assertTrue("The seconds were not calculated properly", seconds==00);
	}
	
	@Test
	public void testGetSecondsBoundaryUpper() 
	{
		int seconds = Time.getSeconds("05:59:59");
		assertTrue("The seconds were not calculated properly", seconds==59);
	}
	
	@Test
	public void testGetSecondsBad() 
	{
	assertThrows(
	 StringIndexOutOfBoundsException.class, 
	 ()-> {Time.getTotalSeconds("10:00");});
	}
	

	@Test
	void testGetMinutesGood() {
		int minutes = Time.getTotalMinutes("06:48:57");
		assertTrue("The minutes were not calculated properly", minutes==48);
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "05:03:00",  "05:03:59" })
	void testGetTotalMinutesBoundary(String candidate) {
	int minutes = Time.getTotalMinutes(candidate);
	assertTrue("The minutes were not calculated properly",minutes ==3);
	}
	
	@Test
	public void testGetTotalMinutesBad() 
	{
	assertThrows(
	 StringIndexOutOfBoundsException.class, 
	 ()-> {Time.getTotalMinutes("10");});
	}


	@Test
	void testGetTotalHoursGood() {
		int hours = Time.getTotalHours("06:48:57");
		assertTrue("The minutes were not calculated properly",hours==6);
	}
	
	@Test
	public void testGetTotalHoursBad() 
	{
	assertThrows(
	 NumberFormatException.class, 
	 ()-> {Time.getTotalHours("abc");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "06:00:00", "06:19:15", "06:59:59" })
	void testGetTotalHours(String candidate) {
	int hours = Time.getTotalHours(candidate);
	assertTrue("The hours were not calculated properly", hours ==6);
	}
	
	
	@Test
	void testGetMilliSecondsGood() {
		int milliseconds = Time.getmilliSeconds("06:48:57:978");
		assertTrue("The minutes were not calculated properly", milliseconds==978);
	}
	
	@Test
	void testGetMilliSecondsBad() {
		assertThrows(
				 StringIndexOutOfBoundsException.class, 
				 ()-> {Time.getTotalSeconds("10:00");});
	}
	
	@Test
	void testGetMilliSecondsBoundaryUpper() {
		int milliseconds = Time.getmilliSeconds("06:48:57:000");
		assertTrue("The minutes were not calculated properly", milliseconds==000);
	}
	
	@Test
	void testGetMilliSecondsBoundaryLower() {
		int milliseconds = Time.getmilliSeconds("06:48:57:999");
		assertTrue("The minutes were not calculated properly", milliseconds==999);
	}
}



