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
 * Website Optimizer (__utmx)
 *
 * This cookie is used by Website Optimizer and only set when the Website Optimizer tracking
 * code is installed and correctly configured for your pages. When the optimizer script executes,
 * this cookie stores the variation this visitor is assigned to for each experiment, so the visitor
 * has a consistent experience on your site.  See the Website Optimizer Help Center for more information.
 *
 * @see <a href="http://www.google.com/support/websiteoptimizer/">Website Optimizer Help Center</a>
 * @author <a href="https://github.com/ebeeson">Erik Beeson</a>
 */
public class GAWebsiteOptimizerData extends GADataBase {
	public static final String COOKIE_NAME = "__utmx";

	public GAWebsiteOptimizerData(String value) {
		super(value);
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder("GAWebsiteOptimizerData{");
		sb.append("domain='").append(getDomain()).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
