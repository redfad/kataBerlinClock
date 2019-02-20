package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.BerlingClockException;

class BerlinTimeTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void shouldFailWhenTimeFormatIsNotRespected() {
		assertThrows(BerlingClockException.class, () -> {
			BerlinTime berlinTime = new BerlinTime("test");
			berlinTime.getBerlinTime();
		});
	}
	
	@Test
	void shouldFailWhenTimeTextContainsOtherThenNumbers() {
		assertThrows(BerlingClockException.class, () -> {
			BerlinTime berlinTime = new BerlinTime("AB:01:25");
			berlinTime.getBerlinTime();
		});
	}
	
	@Test
	void shouldFailWhenInputTimeHasInvalidNumberOfSeconds() {
		assertThrows(BerlingClockException.class, () -> {
			BerlinTime berlinTime = new BerlinTime("02:56:66");
			berlinTime.getBerlinTime();
		});
	}
	
	@Test
	void shouldFailWhenInputTimeHasInvalidNumberOfMinutes() {
		assertThrows(BerlingClockException.class, () -> {
			BerlinTime berlinTime = new BerlinTime("12:66:25");
			berlinTime.getBerlinTime();
		});
	}
	
	@Test
	void shouldFailWhenInputTimeHasInvalidNumberOfHours() {
		assertThrows(BerlingClockException.class, () -> {
			BerlinTime berlinTime = new BerlinTime("33:01:25");
			berlinTime.getBerlinTime();
		});
	}
	
	@Test
	void shouldReturnBerlinTimeFormat() throws BerlingClockException{
		BerlinTime berlinTime = new BerlinTime("11:53:20");
		assertEquals(berlinTime.getBerlinTime().toString(), "[R, R][Y][Y, Y, R, Y, Y, R, Y, Y, R, Y][Y, Y, Y]");
	}

}
