package com.erikandcolleen.gacookieparser;

/**
 * Session, deprecated (__utmc)
 *
 * This cookie is no longer used by the ga.js tracking code to determine session status.
 *
 * @author Erik Beeson
 */
public class GASessionEndData extends GADataBase {
	public static final String COOKIE_NAME = "__utmc";

	public GASessionEndData(String value) {
		super(value);
	}
}
