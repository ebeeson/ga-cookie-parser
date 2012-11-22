package com.erikandcolleen.gacookieparser;

import java.util.Date;

/**
 * @author Erik Beeson
 */
public class GoogleAnalyticsCombinedData {
	private final String domain;
	private final Integer pageViews;
	private final Integer sessionCount;
	private final Integer campaignNumber;
	private final GATrafficSourcesData.CampaignData campaignData;
	private final String uid;
	private final Date firstSessionStart;
	private final Date previousSessionStart;
	private final Date currentSessionStart;
	private final String customVariableValue;

	public GoogleAnalyticsCombinedData(GAVisitorData visitor, GASessionData session, GASessionEndData sessionEnd,
									   GACustomValueData customValue, GAWebsiteOptimizerData websiteOptimizer,
									   GATrafficSourcesData trafficSources) {
		String domain = null;
		String uid = null;
		Date firstSessionStart = null;
		Date previousSessionStart = null;
		Date currentSessionStart = null;

		if(visitor != null) {
			domain = visitor.getDomain();
			uid = visitor.getUid();
			firstSessionStart = visitor.getFirstSessionStart();
			previousSessionStart = visitor.getPreviousSessionStart();
			currentSessionStart = visitor.getCurrentSessionStart();
		}

		Integer pageViews = null;

		if(session != null) {
			domain = firstNotNull(domain, session.getDomain());
			pageViews = session.getPageViews();
			currentSessionStart = firstNotNull(currentSessionStart, session.getCurrentSessionStart());
		}

		if(sessionEnd != null) {
			domain = firstNotNull(domain, sessionEnd.getDomain());
		}

		String customVariableValue = null;

		if(customValue != null) {
			domain = firstNotNull(domain, customValue.getDomain());
			customVariableValue = customValue.getValue();
		}

		if(websiteOptimizer != null) {
			domain = firstNotNull(domain, websiteOptimizer.getDomain());
		}

		Integer sessionCount = null;
		Integer campaignNumber = null;
		GATrafficSourcesData.CampaignData campaignData = null;

		if(trafficSources != null) {
			domain = firstNotNull(domain, trafficSources.getDomain());
			sessionCount = trafficSources.getSessionCount();
			campaignNumber = trafficSources.getCampaignNumber();
			campaignData = trafficSources.getCampaignData();
		}

		this.domain = domain;
		this.pageViews = pageViews;
		this.sessionCount = sessionCount;
		this.campaignNumber = campaignNumber;
		this.campaignData = campaignData;
		this.uid = uid;
		this.firstSessionStart = firstSessionStart;
		this.previousSessionStart = previousSessionStart;
		this.currentSessionStart = currentSessionStart;
		this.customVariableValue = customVariableValue;
	}

	private static <T> T firstNotNull(T... objects) {
		for(T object : objects) {
			if(object != null) {
				return object;
			}
		}
		return null;
	}

	public String getDomain() {
		return domain;
	}

	public Integer getPageViews() {
		return pageViews;
	}

	public Integer getSessionCount() {
		return sessionCount;
	}

	public Integer getCampaignNumber() {
		return campaignNumber;
	}

	public GATrafficSourcesData.CampaignData getCampaignData() {
		return campaignData;
	}

	public String getUid() {
		return uid;
	}

	public Date getFirstSessionStart() {
		return firstSessionStart;
	}

	public Date getPreviousSessionStart() {
		return previousSessionStart;
	}

	public Date getCurrentSessionStart() {
		return currentSessionStart;
	}

	public String getCustomVariableValue() {
		return customVariableValue;
	}
}
