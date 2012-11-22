package com.erikandcolleen.gacookieparser;

/**
 * @author Erik Beeson
 */
public class GoogleAnalyticsData {
	private final GAVisitorData visitor;
	private final GASessionData session;
	private final GASessionEndData sessionEnd;
	private final GACustomValueData customValue;
	private final GAWebsiteOptimizerData websiteOptimizer;
	private final GATrafficSourcesData trafficSources;

	public GoogleAnalyticsData(GAVisitorData visitor, GASessionData session, GASessionEndData sessionEnd, GACustomValueData customValue, GAWebsiteOptimizerData websiteOptimizer, GATrafficSourcesData trafficSources) {
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
}
