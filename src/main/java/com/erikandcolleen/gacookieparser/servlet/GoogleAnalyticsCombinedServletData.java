package com.erikandcolleen.gacookieparser.servlet;

import com.erikandcolleen.gacookieparser.*;

import javax.servlet.http.HttpServletRequest;

import static com.erikandcolleen.gacookieparser.servlet.GADataServletParser.getGoogleAnalyticsCookieData;

/**
 * @author Erik Beeson
 */
public class GoogleAnalyticsCombinedServletData extends GoogleAnalyticsCombinedData {
	public GoogleAnalyticsCombinedServletData(HttpServletRequest request) {
		super(
				(GAVisitorData) getGoogleAnalyticsCookieData(request, GAVisitorData.COOKIE_NAME),
				(GASessionData) getGoogleAnalyticsCookieData(request, GASessionData.COOKIE_NAME),
				(GASessionEndData) getGoogleAnalyticsCookieData(request, GASessionEndData.COOKIE_NAME),
				(GACustomValueData) getGoogleAnalyticsCookieData(request, GACustomValueData.COOKIE_NAME),
				(GAWebsiteOptimizerData) getGoogleAnalyticsCookieData(request, GAWebsiteOptimizerData.COOKIE_NAME),
				(GATrafficSourcesData) getGoogleAnalyticsCookieData(request, GATrafficSourcesData.COOKIE_NAME)
		);
	}
}
