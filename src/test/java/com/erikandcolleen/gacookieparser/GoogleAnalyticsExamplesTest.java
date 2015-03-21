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

import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * @author <a href="https://github.com/ebeeson">Erik Beeson</a>
 */
public class GoogleAnalyticsExamplesTest {
	private final String[][] cookies = new String[][]{
		{"__utma", "1.437088539.1384070688.1400563865.1400567205.576"},
		{"__utmc", "1"},
		{"__utma", "133161051.201442044.1386971902.1391295467.1391462432.8"},
		{"__utma", "173272373.1566673519.1385940746.1385940746.1385940746.1"},
		{"__utma", "173272373.1566673519.1385940746.1426019964.1426019964.1"},
		{"__utma", "173272373.1566673519.1385940746.1426129425.1426444516.2"},
		{"__utma", "173272373.1852318067.1404409620.1404409620.1404409620.1"},
		{"__utma", "173272373.1852318067.1404409620.1404409620.1404409620.1"},
		{"__utma", "247248150.1203009457.1426055336.1426055336.1426055336.1"},
		{"__utma", "73091649.1053265712.1420236166.1424315025.1426106303.6"},
		{"__utma", "93394463.267276107.1426143750.1426143750.1426143750.1"},
		{"__utmc", "133161051"},
		{"__utmc", "173272373"},
		{"__utmc", "173272373"},
		{"__utmc", "173272373"},
		{"__utmc", "173272373"},
		{"__utmc", "173272373"},
		{"__utmc", "247248150"},
		{"__utmc", "73091649"},
		{"__utmc", "93394463"},
		{"__utmz", "173272373.1426019964.1.1.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided)"},
		{"__utmz", "173272373.1426444516.2.2.utmcsr=blog.parsely.com|utmccn=(referral)|utmcmd=referral|utmcct=/post/1691/lucene/"},
		{"__utmz", "247248150.1426055336.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)"},
		{"__utmz", "73091649.1426106303.6.6.utmcsr=gmail|utmccn=(not%20set)|utmcmd=(not%20set)"},
		{"__utmz", "93394463.1426143750.1.1.utmcsr=helpouts.google.com|utmccn=(referral)|utmcmd=referral|utmcct=/"}
	};

	@Test(description = "Parsing examples")
	public void examples() {
		for(String[] cookie : cookies) {
			Reporter.log(String.format("%s: %s", cookie[0], cookie[1]));
			Reporter.log(String.valueOf(GADataBase.getCookieData(cookie[0], cookie[1])));
			Reporter.log("");
			Reporter.log("");
		}
	}
}