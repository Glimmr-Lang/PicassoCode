
package org.piccode.rt;

/**
 *
 * @author hexaredecimal
 */
public class PiccodeString implements PiccodeValue {
	private String string;

	public PiccodeString(String str) {
		this.string = str;
		if (str.startsWith("\"") || str.startsWith("'")) {
			this.string = str.substring(1);
		} 
		if (str.endsWith("\"") || str.endsWith("'")) {
			this.string = this.string.substring(0, string.length() - 1);
		} 
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
