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