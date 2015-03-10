/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Erik Beeson
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.erikandcolleen.gacookieparser;

import java.util.Date;

/**
 * Visitor (__utma)
 *
 * This cookie is typically written to the browser upon the first visit to your site from that web browser.
 * If the cookie has been deleted by the browser operator, and the browser subsequently visits your site,
 * a new __utma cookie is written with a different unique ID. In most cases, this cookie is used to
 * determine unique visitors to your site and it is updated with each page view. Additionally,
 * this cookie is provided with a unique ID that Google Analytics uses to ensure both the validity and
 * accessibility of the cookie as an extra security measure.
 *
 * @author Erik Beeson
 */
public class GAVisitorData extends GADataBase {
	public static final String COOKIE_NAME = "__utma";

	private final String uid;
	private final Date firstSessionStart;
	private final Date previousSessionStart;
	private final Date currentSessionStart;
	private final Integer sessionCount;

	public GAVisitorData(String value) {
		super(value);
		this.uid = getString(1);
		this.firstSessionStart = getDate(2);
		this.previousSessionStart = getDate(3);
		this.currentSessionStart = getDate(4);
		this.sessionCount = getInteger(5);
	}

	/**
	 * Unique Identifier.
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * Timestamp of this user's  first session.
	 */
	public Date getFirstSessionStart() {
		return firstSessionStart;
	}

	/**
	 * Timestamp for the previous session.
	 */
	public Date getPreviousSessionStart() {
		return previousSessionStart;
	}

	/**
	 * Timestamp for the current session.
	 */
	public Date getCurrentSessionStart() {
		return currentSessionStart;
	}

	/**
	 * Number of sessions started.
	 */
	public Integer getSessionCount() {
		return sessionCount;
	}
}
