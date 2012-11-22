package com.erikandcolleen.gacookieparser;

/**
 * Custom Value (__utmv)
 *
 * This cookie is not normally present in a default configuration of the tracking code.
 * The __utmv cookie passes the information provided via the _setVar() method, which you
 * use to create a custom user segment. This string is then passed to the Analytics servers
 * in the GIF request URL via the utmcc parameter. This cookie is only written if you have
 * added the _setVar() method for the tracking code on your website page.
 *
 * @author Erik Beeson
 */
public class GACustomValueData extends GADataBase {
	public static final String COOKIE_NAME = "__utmv";

	private final String value;

	public GACustomValueData(String value) {
		super(value);
		this.value = getString(1);
	}

	/**
	 * Custom values specified in user custom variables.
	 */
	public String getValue() {
		return value;
	}
}
