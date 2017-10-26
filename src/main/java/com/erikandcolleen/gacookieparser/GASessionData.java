/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Erik Beeson
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
 * @author <a href="https://github.com/ebeeson">Erik Beeson</a>
 */
public class GASessionData extends GACookieData {
	public static final String COOKIE_NAME = "__utmb";

	private final Integer pageViews;
	private final Date currentSessionStart;

	public GASessionData(String cookieValue) {
		super(cookieValue);
		this.pageViews = getInteger(1);
		/**
		 * Field 2 is "outbound link countdown"
		 *
		 * This starts at 10 on every site. Each time you click on an outgoing
		 * link it will count down until it reaches 0. It’s part of an outgoing
		 * links tracking system in the ga.js that never appeared in the GA
		 * interface (thanks André Scholten for pointing this out).
		 *
		 * We don't bother with it since nobody seems to care about it anymore.
		 *
		 * @see http://springest.io/anatomy-of-google-analytics-cookies
		 * @see http://andrescholten.net/
		 */
		//this.outboundLinkCountdown = getInteger(2);
		this.currentSessionStart = getDate(3);
	}

	public Integer getPageViews() {
		return pageViews;
	}

	public Date getCurrentSessionStart() {
		return currentSessionStart;
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder("GASessionData");
		sb.append('(').append(COOKIE_NAME).append("){");
		sb.append("domain='").append(getDomain()).append('\'');
		sb.append(", pageViews=").append(pageViews);
		sb.append(", currentSessionStart=").append(currentSessionStart);
		sb.append('}');
		return sb.toString();
	}
}
