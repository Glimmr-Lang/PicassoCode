
package org.piccode.rt;

/**
 *
 * @author hexaredecimal
 */
public class PiccodeBoolean implements PiccodeValue {
	private String value;

	public PiccodeBoolean(String number) {
		this.value = number;
	}
	
	@Override
	public Object raw() {
		return (value.equals("true"));
	}

	@Override
	public String toString() {
		return value;
	}
	
	
}
