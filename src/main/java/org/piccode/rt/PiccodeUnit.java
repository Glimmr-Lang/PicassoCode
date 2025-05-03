
package org.piccode.rt;

/**
 *
 * @author hexaredecimal
 */
public class PiccodeNumber implements PiccodeValue {
	private String number;

	public PiccodeNumber(String number) {
		this.number = number;
	}
	
	@Override
	public Object raw() {
		return Double.parseDouble(number);
	}

	@Override
	public String toString() {
		return number;
	}
	
	
}
