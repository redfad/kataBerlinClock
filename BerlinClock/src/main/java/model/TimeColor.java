/**
 * 
 */
package model;

/**
 * @author ELMekkaoui Redouane
 *
 */
public enum TimeColor {
	YELLOW("Y"),
	RED("R");
	
	final private String color;
	
	private TimeColor(String color) {
		this.color = color;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

}
