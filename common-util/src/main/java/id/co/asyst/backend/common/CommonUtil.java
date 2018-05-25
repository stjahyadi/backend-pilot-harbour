package id.co.asyst.backend.common;

import org.apache.commons.lang.StringUtils;

public class CommonUtil {

	/**
	 * To substitute a value when a null value is encountered.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static <T> T nvl(T a, T b) {
		return (a == null) ? b : a;
	}

	/**
	 * To pads the left-side of a string with a specific set of characters
	 * 
	 * @param value
	 * @param paddedLength
	 * @param padString
	 * @return
	 */
	public static String lpad(String value, Integer paddedLength, String padString) {
		String result = null;
		if (value.length() > paddedLength) {
			result = value.substring(value.length() - paddedLength);
		} else {
			result = StringUtils.leftPad(value, paddedLength, padString);
		}
		return result;
	}

	

}
