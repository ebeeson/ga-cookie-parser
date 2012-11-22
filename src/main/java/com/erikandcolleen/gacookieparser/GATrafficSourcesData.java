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
 * @author Erik Beeson
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
	}
}
