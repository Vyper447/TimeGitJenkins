package time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class TimeTest {

	@Test
	void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05");
		assertTrue("The seconds were not calculated properly", seconds==18305);
	}

	@Test
	public void testGetTotalSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalSeconds("10:00");});
	}
	
	@Test
	void testGetTotalSecondsBoundry() {
	    int seconds = Time.getTotalSeconds("00:00:01");
	    assertEquals(1, seconds, "The seconds were not calculated properly");
	}
	
	@Test
	void testGetSecondsGood() {
		int seconds = Time.getSeconds("01:02:03");
        assertEquals(3, seconds, "The seconds were not extracted properly");
	}
	
	@Test
	void testGetSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalSeconds("10:00");});
	}
	
	@Test
	void testGetSecondsBoundry() {
		int seconds = Time.getTotalSeconds("00:00:59");
		assertEquals(59, seconds, "The seconds were not extracted properly");
	}
	
	@Test
	void testGetTotalMinutesGood() {
		int minutes = Time.getTotalMinutes("01:02:05");
		assertEquals(2, minutes, "The minutes were not extracted properly");
	}
	
	@Test
	void testGetTotalMinutesBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalSeconds("10:00");});
	}

	
	@Test
	void testGetTotalMinutesBoundry() {
		int minutes = Time.getTotalMinutes("00:59:59");
		assertEquals(59, minutes, "The minutes were not extracted properly");
	}


	@Test
	void testGetTotalHoursGood() {
		int hours = Time.getTotalHours("01:02:03");
		assertEquals(1, hours, "The hours were not extracted properly");
	}
	
	@Test
	void testGetTotalHoursBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalSeconds("10:00");});
	}

	
	@Test
	void testGetTotalHoursBoundry() {
		int hours = Time.getTotalHours("23:59:59");
        assertEquals(23, hours, "The hours were not calculated properly");
	}

	/*@Test
	void testGetMilliseconds() {
		int milliseconds = Time.getMilliseconds("12:05:05:05");
        assertEquals(5, milliseconds, "The milliseconds were not calculated properly");
	}*/
	
	@Test
	void testGetMillisecondsGood() {
		int milliseconds = Time.getMilliseconds("12:05:05:05");
        assertEquals(5, milliseconds, "The milliseconds were not calculated properly");
	}
	
	@Test
	void testGetMillisecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalSeconds("10:00");});
	}
	
	@Test
	void testGetMillisecondsBoundry() {
		int milliseconds = Time.getMilliseconds("00:00:00:00");
        assertEquals(0, milliseconds, "The milliseconds were not calculated properly");
	}

}
