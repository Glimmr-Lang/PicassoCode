
package org.piccode.rt;

import java.util.List;

/**
 *
 * @author hexaredecimal
 */
public class PiccodeArray implements PiccodeValue {
	private List<PiccodeValue> nodes;

	public PiccodeArray(List<PiccodeValue> nodes) {
		this.nodes = nodes;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		for (int i = 0; i < nodes.size(); i++) {
			sb.append(nodes.get(i));
			if (i < nodes.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public List<PiccodeValue> getList() {
		return nodes;
	}

	public PiccodeValue[] array() {
		return nodes.toArray(PiccodeValue[]::new);
	}
	
	@Override
	public Object raw() {
		return nodes.toArray();
	}
}
