/**
 * 
 */
package core;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import exception.BerlingClockException;
import model.TimeColor;
import model.TimeDuration;
import model.TimeElement;

/**
 * @author ELMEKKAOUI Redouane
 *
 */
public class BerlinTime {
	private final Logger log = Logger.getLogger("BerlinTime");
	private List<TimeElement> fiveHours;
	private List<TimeElement> oneHours;
	private List<TimeElement> fiveMinutes;
	private List<TimeElement> oneMinutes;
	private String time;

	public BerlinTime(String time) {
		this.time = time;
	}

	/**
	 * Convert text Time to Berlin Format
	 * 
	 * @return
	 * @throws BerlingClockException
	 */

	public String getBerlinTime() throws BerlingClockException {
		log.info("Request to convert : " + time + " to Berlin Clock");
		try {
			LocalTime normalTime = LocalTime.parse(time);
			convertToBerlinTime(normalTime);
		} catch (DateTimeParseException e) {
			throw new BerlingClockException("Merci de saisir un temps valide");
		}

		return this.toString();
	}

	/**
	 * Convert time to Berlin Format
	 * 
	 * @param hours
	 * @param minutes
	 * @param seconds
	 * @return
	 */

	private void convertToBerlinTime(LocalTime normalTime) {
		fiveHours = new ArrayList<TimeElement>();
		oneHours = new ArrayList<TimeElement>();
		fiveMinutes = new ArrayList<TimeElement>();
		oneMinutes = new ArrayList<TimeElement>();

		for (int i = 0; i < normalTime.getHour() / 5; i++) {
			fiveHours.add(new TimeElement(TimeDuration.FIVE_HOUR, TimeColor.RED));
		}

		for (int i = 0; i < normalTime.getHour() % 5; i++) {
			oneHours.add(new TimeElement(TimeDuration.ONE_HOUR, TimeColor.YELLOW));
		}

		for (int i = 0; i < normalTime.getMinute() / 5; i++) {
			TimeElement timeElement = null;
			if ((i + 1) % 3 == 0) {
				timeElement = new TimeElement(TimeDuration.FIVE_MIN, TimeColor.RED);
			} else {
				timeElement = new TimeElement(TimeDuration.FIVE_MIN, TimeColor.YELLOW);
			}
			fiveMinutes.add(timeElement);
		}

		for (int i = 0; i < normalTime.getMinute() % 5; i++) {
			oneMinutes.add(new TimeElement(TimeDuration.ONE_HOUR, TimeColor.YELLOW));
		}

		log.info("Berlin Clock : \n" + normalTime.getHour() + "h : " + fiveHours + " - " + oneHours + "\n" +
				 normalTime.getMinute() + "min : " + fiveMinutes + " - " + oneMinutes);
	}

	/**
	 * @return the Number of 5 Hours
	 */
	public List<TimeElement> getFiveHours() {
		return fiveHours;
	}

	/**
	 * @return the Number of 1 Hour
	 */
	public List<TimeElement> getOneHours() {
		return oneHours;
	}

	/**
	 * @return the Number of Five Minutes
	 */
	public List<TimeElement> getFiveMinutes() {
		return fiveMinutes;
	}

	/**
	 * @return the Number of One Minutes
	 */
	public List<TimeElement> getOneMinutes() {
		return oneMinutes;
	}

	/**
	 * to String
	 */
	@Override
	public String toString() {
		return "" + fiveHours + oneHours + fiveMinutes + oneMinutes;
	}

}
