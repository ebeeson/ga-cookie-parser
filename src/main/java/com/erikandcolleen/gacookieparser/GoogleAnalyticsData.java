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
 * @author <a href="https://github.com/ebeeson">Erik Beeson</a>
 */
public class GoogleAnalyticsData {
	private final GAVisitorData visitor;
	private final GASessionData session;
	private final GASessionEndData sessionEnd;
	private final GACustomValueData customValue;
	private final GAWebsiteOptimizerData websiteOptimizer;
	private final GATrafficSourcesData trafficSources;

	public GoogleAnalyticsData(GAVisitorData visitor, GASessionData session, GASessionEndData sessionEnd,
							   GACustomValueData customValue, GAWebsiteOptimizerData websiteOptimizer,
							   GATrafficSourcesData trafficSources) {
		this.visitor = visitor;
		this.session = session;
		this.sessionEnd = sessionEnd;
		this.customValue = customValue;
		this.websiteOptimizer = websiteOptimizer;
		this.trafficSources = trafficSources;
	}

	public GAVisitorData getVisitor() {
		return visitor;
	}

	public GASessionData getSession() {
		return session;
	}

	public GASessionEndData getSessionEnd() {
		return sessionEnd;
	}

	public GACustomValueData getCustomValue() {
		return customValue;
	}

	public GAWebsiteOptimizerData getWebsiteOptimizer() {
		return websiteOptimizer;
	}

	public GATrafficSourcesData getTrafficSources() {
		return trafficSources;
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder("GoogleAnalyticsData{");
		sb.append("visitor=").append(visitor);
		sb.append(", session=").append(session);
		sb.append(", sessionEnd=").append(sessionEnd);
		sb.append(", customValue=").append(customValue);
		sb.append(", websiteOptimizer=").append(websiteOptimizer);
		sb.append(", trafficSources=").append(trafficSources);
		sb.append('}');
		return sb.toString();
	}
}
