/**
 * 
 */
package model;

/**
 * @author mac
 *
 */
public enum TimeDuration {
	FIVE_HOUR(18000),
	ONE_HOUR(3600),
	FIVE_MIN(300),
	ONE_MIN(60);
	
	final int duration;

	private TimeDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	} 

}
