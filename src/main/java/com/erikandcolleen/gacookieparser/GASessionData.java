package com.erikandcolleen.gacookieparser;

import java.util.Date;

/**
 * Session (__utmb)
 *
 * This cookie is used to establish and continue a user session with your site.
 * When a user views a page on your site, the Google Analytics code attempts to
 * update this cookie. If it does not find the cookie, a new one is written and
 * a new session is established. Each time a user visits a different page on your
 * site, this cookie is updated to expire in 30 minutes, thus continuing a single
 * session for as long as user activity continues within 30-minute intervals. This
 * cookie expires when a user pauses on a page on your site for longer than 30 minutes.
 * You can modify the default length of a user session with the _setSessionCookieTimeout() method.
 *
 * @author Erik Beeson
 */
public class GASessionData extends GADataBase {
	public static final String COOKIE_NAME = "__utmb";

	private final Integer pageViews;
	private final Date currentSessionStart;

	public GASessionData(String value) {
		super(value);
		this.pageViews = getInteger(1);
		//getInteger(2) // outbound link countdown, https://groups.google.com/forum/?fromgroups=#!topic/analytics-help-basics/YhHkR9AJuGM
		this.currentSessionStart = getDate(3);
	}

	public Integer getPageViews() {
		return pageViews;
	}

	public Date getCurrentSessionStart() {
		return currentSessionStart;
	}
}