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
 * Session, deprecated (__utmc)
 *
 * This cookie is no longer used by the ga.js tracking code to determine session status.
 *
 * @author <a href="https://github.com/ebeeson">Erik Beeson</a>
 */
public class GASessionEndData extends GADataBase {
	public static final String COOKIE_NAME = "__utmc";

	public GASessionEndData(String cookieValue) {
		super(cookieValue);
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder("GASessionEndData");
		sb.append('(').append(COOKIE_NAME).append("){");
		sb.append("domain='").append(getDomain()).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
