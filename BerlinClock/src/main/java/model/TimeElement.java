/**
 * 
 */
package model;

/**
 * @author ELMEKKAOUI Redouane
 *
 */
public class TimeElement {
	private TimeDuration duration;
	private TimeColor color;
	
	/**
	 * @param duration
	 * @param color
	 */
	public TimeElement(TimeDuration duration, TimeColor color) {
		super();
		this.duration = duration;
		this.color = color;
	}

	/**
	 * @return the duration
	 */
	public TimeDuration getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(TimeDuration duration) {
		this.duration = duration;
	}

	/**
	 * @return the color
	 */
	public TimeColor getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(TimeColor color) {
		this.color = color;
	}

	/** 
	 * Return color of the time block
	 */
	@Override
	public String toString() {
		return color.getColor();
	}

}
