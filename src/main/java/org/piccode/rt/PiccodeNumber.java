
package org.piccode.rt;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 17 * hash + Objects.hashCode(this.number);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true; 

		if (!(obj instanceof PiccodeNumber)) return false;
		var num = (PiccodeNumber) obj;
		return num.number.equals(this.number);
	}
	
	
}
