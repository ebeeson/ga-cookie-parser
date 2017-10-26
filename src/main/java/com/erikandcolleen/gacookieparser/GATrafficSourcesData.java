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

import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Traffic Sources (__utmz)
 *
 * This cookie stores the type of referral used by the visitor to reach your site,
 * whether via a direct method, a referring link, a website search, or a campaign
 * such as an ad or an email link. It is used to calculate search engine traffic,
 * ad campaigns and page navigation within your own site. The cookie is updated with
 * each page view to your site.
 *
 * @author <a href="https://github.com/ebeeson">Erik Beeson</a>
 */
public class GATrafficSourcesData extends GADataBase {
	public static final String COOKIE_NAME = "__utmz";

	private final Date currentSessionStart;
	private final Integer sessionCount;
	private final Integer campaignNumber;
	private final CampaignData campaignData;

	public GATrafficSourcesData(String cookieValue) {
		super(cookieValue, 5);
		this.currentSessionStart = getDate(1);
		this.sessionCount = getInteger(2);
		this.campaignNumber = getInteger(3);
		this.campaignData = new CampaignData(getString(4));
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

	public Integer getCampaignNumber() {
		return campaignNumber;
	}

	public CampaignData getCampaignData() {
		return campaignData;
	}

	public static class CampaignData {
		private final String source;
		private final String name;
		private final String medium;
		private final String term;
		private final String content;
		private final Map<String, String> additionalData;

		private CampaignData(String campaignData) {
			Map<String, String> map = new LinkedHashMap<String, String>();

			for(String field : campaignData.split("\\|")) {
				String[] pair = field.split("=", 2);
				if(pair.length == 2) {
					map.put(pair[0], pair[1]);
				}
			}

			this.source = map.remove("utmcsr");
			this.name = map.remove("utmccn");
			this.medium = map.remove("utmcmd");
			this.term = map.remove("utmctr");
			this.content = map.remove("utmcct");

			this.additionalData = map.isEmpty() ? null : Collections.unmodifiableMap(map);
		}

		public String getSource() {
			return source;
		}

		public String getName() {
			return name;
		}

		public String getMedium() {
			return medium;
		}

		public String getTerm() {
			return term;
		}

		public String getContent() {
			return content;
		}

		public Map<String, String> getAdditionalData() {
			return additionalData;
		}

		public String toString() {
			final StringBuilder sb = new StringBuilder("CampaignData{");
			sb.append("source='").append(source).append('\'');
			sb.append(", name='").append(name).append('\'');
			sb.append(", medium='").append(medium).append('\'');
			sb.append(", term='").append(term).append('\'');
			sb.append(", content='").append(content).append('\'');
			sb.append(", additionalData=").append(additionalData);
			sb.append('}');
			return sb.toString();
		}
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder("GATrafficSourcesData{");
		sb.append("domain='").append(getDomain()).append('\'');
		sb.append(", currentSessionStart=").append(currentSessionStart);
		sb.append(", sessionCount=").append(sessionCount);
		sb.append(", campaignNumber=").append(campaignNumber);
		sb.append(", campaignData=").append(campaignData);
		sb.append('}');
		return sb.toString();
	}
}
