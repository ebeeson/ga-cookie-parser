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
import java.util.regex.Pattern;

/**
 * @author <a href="https://github.com/ebeeson">Erik Beeson</a>
 */
public abstract class GACookieData {
	private static final Pattern PATTERN_DOT = Pattern.compile("\\.");
	private final transient String[] parts;

	private final String domain;

	protected GACookieData(String cookieValue, int limit) {
		this.parts = (cookieValue == null ? new String[0] : PATTERN_DOT.split(cookieValue.trim(), limit));
		this.domain = getString(0);
	}

	protected GACookieData(String cookieValue) {
		this.parts = (cookieValue == null ? new String[0] : PATTERN_DOT.split(cookieValue.trim()));
		this.domain = getString(0);
	}

	protected String getString(int field) {
		return field < parts.length ? parts[field] : null;
	}

	protected Long getLong(int field) {
		String value = getString(field);
		try {
			return value != null ? Long.parseLong(value, 10) : null;
		} catch(NumberFormatException e) {
			return null;
		}
	}

	protected Integer getInteger(int field) {
		String value = getString(field);
		try {
			return value != null ? Integer.parseInt(value, 10) : null;
		} catch(NumberFormatException e) {
			return null;
		}
	}

	protected Date getDate(int field) {
		Long value = getLong(field);
		return value != null ? new Date(1000 * value) : null;
	}

	/**
	 * Domain hash, unique for each domain.
	 */
	public String getDomain() {
		return domain;
	}

	public static GACookieData getCookieData(String cookieName, String cookieValue) {
		if(cookieName != null && cookieValue != null) {
			if(GAVisitorData.COOKIE_NAME.equals(cookieName)) {
				return new GAVisitorData(cookieValue);
			} else if(GASessionData.COOKIE_NAME.equals(cookieName)) {
				return new GASessionData(cookieValue);
			} else if(GASessionEndData.COOKIE_NAME.equals(cookieName)) {
				return new GASessionEndData(cookieValue);
			} else if(GACustomValueData.COOKIE_NAME.equals(cookieName)) {
				return new GACustomValueData(cookieValue);
			} else if(GAWebsiteOptimizerData.COOKIE_NAME.equals(cookieName)) {
				return new GAWebsiteOptimizerData(cookieValue);
			} else if(GATrafficSourcesData.COOKIE_NAME.equals(cookieName)) {
				return new GATrafficSourcesData(cookieValue);
			}
		}

		return null;
	}
}
