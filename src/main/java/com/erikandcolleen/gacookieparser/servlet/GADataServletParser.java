package com.erikandcolleen.gacookieparser.servlet;

import com.erikandcolleen.gacookieparser.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static com.erikandcolleen.gacookieparser.GADataBase.getCookieData;

/**
 * @author Erik Beeson
 */
public class GADataServletParser {
	public static GACustomValueData getCustomValueData(HttpServletRequest request) {
		return (GACustomValueData) getGoogleAnalyticsCookieData(request, GACustomValueData.COOKIE_NAME);
	}

	public static GASessionData getSessionData(HttpServletRequest request) {
		return (GASessionData) getGoogleAnalyticsCookieData(request, GASessionData.COOKIE_NAME);
	}

	public static GASessionEndData getSessionEndData(HttpServletRequest request) {
		return (GASessionEndData) getGoogleAnalyticsCookieData(request, GASessionEndData.COOKIE_NAME);
	}

	public static GATrafficSourcesData getTrafficSourcesData(HttpServletRequest request) {
		return (GATrafficSourcesData) getGoogleAnalyticsCookieData(request, GATrafficSourcesData.COOKIE_NAME);
	}

	public static GAVisitorData getVisitorData(HttpServletRequest request) {
		return (GAVisitorData) getGoogleAnalyticsCookieData(request, GAVisitorData.COOKIE_NAME);
	}

	public static GAWebsiteOptimizerData getWebsiteOptimizerData(HttpServletRequest request) {
		return (GAWebsiteOptimizerData) getGoogleAnalyticsCookieData(request, GAWebsiteOptimizerData.COOKIE_NAME);
	}

	public static GADataBase[] getGoogleAnalyticsCookieData(HttpServletRequest request) {
		List<GADataBase> list = new ArrayList<GADataBase>();
		if(request != null) {
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for(Cookie cookie : cookies) {
					GADataBase data = getGoogleAnalyticsCookieData(cookie);
					if(data != null) {
						list.add(data);
					}
				}
			}
		}
		return list.toArray(new GADataBase[list.size()]);
	}

	public static GADataBase getGoogleAnalyticsCookieData(HttpServletRequest request, String cookieName) {
		return request != null ? getCookieData(cookieName, getCookieValue(request.getCookies(), cookieName)) : null;
	}

	public static GADataBase getGoogleAnalyticsCookieData(Cookie cookie) {
		return cookie != null ? getCookieData(cookie.getName(), cookie.getValue()) : null;
	}

	public static String getCookieValue(Cookie[] cookies, String name) {
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals(name)) {
					return cookie.getValue();
				}
			}
		}

		return null;
	}
}