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

/**
 * Custom Value (__utmv)
 *
 * This cookie is not normally present in a default configuration of the tracking code.
 * The __utmv cookie passes the information provided via the _setVar() method, which you
 * use to create a custom user segment. This string is then passed to the Analytics servers
 * in the GIF request URL via the utmcc parameter. This cookie is only written if you have
 * added the _setVar() method for the tracking code on your website page.
 *
 * @author <a href="https://github.com/ebeeson">Erik Beeson</a>
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

	public String toString() {
		final StringBuilder sb = new StringBuilder("GACustomValueData{");
		sb.append("domain='").append(getDomain()).append('\'');
		sb.append(", value='").append(value).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
