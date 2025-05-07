
package org.piccode.rt;

/**
 *
 * @author hexaredecimal
 */
public class PiccodeString implements PiccodeValue {
	private String string;

	public PiccodeString(String str) {
		this.string = str;
	}
	
	@Override
	public Object raw() {
		return string;
	}

	@Override
	public String toString() {
		return string;
	}
}
