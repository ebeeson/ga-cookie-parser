# GA Cookie Parser

Parse Google Analytics cookies with Java.


# Introduction

Easily parse the values of the following 6 Google Analytics cookies: [__utma](https://ebeeson.github.io/ga-cookie-parser/javadoc/com/erikandcolleen/gacookieparser/GAVisitorData.html), [__utmb](https://ebeeson.github.io/ga-cookie-parser/javadoc/com/erikandcolleen/gacookieparser/GASessionData.html), [__utmc](https://ebeeson.github.io/ga-cookie-parser/javadoc/com/erikandcolleen/gacookieparser/GASessionEndData.html), [__utmv](https://ebeeson.github.io/ga-cookie-parser/javadoc/com/erikandcolleen/gacookieparser/GACustomValueData.html), [__utmx](https://ebeeson.github.io/ga-cookie-parser/javadoc/com/erikandcolleen/gacookieparser/GAWebsiteOptimizerData.html), [__utmz](https://ebeeson.github.io/ga-cookie-parser/javadoc/com/erikandcolleen/gacookieparser/GATrafficSourcesData.html).

For descriptions of each cookie, and their corresponding classes, see below.

To use when you already have the cookie value, just instantiate the appropriate class with the cookie value:

```
GAVisitorData visitorData = new GAVisitorData("<value of __utma cookie>"); 
System.out.println(visitorData.getFirstSessionStart());
```

### Combined Data

There are two helper classes for wrapping all 6 cookies into a single object:

#### [GoogleAnalyticsData](https://ebeeson.github.io/ga-cookie-parser/javadoc/com/erikandcolleen/gacookieparser/GoogleAnalyticsData.html)

This is just a dumb wrapper for all cookies.

#### [GoogleAnalyticsCombinedData](http://ebeeson.github.io/ga-cookie-parser/javadoc/com/erikandcolleen/gacookieparser/GoogleAnalyticsCombinedData.html).

This attempts to merge the data from all 6 cookies into a single object. This is ideal for serializing all GA cookie data into a single object.


# Servlets

When working in a servlet environment, there are a few helper classes for extracting GA cookie data from an HttpServletRequest:

```
GoogleAnalyticsData analyticsData = new GoogleAnalyticsServletData(request);
GoogleAnalyticsCombinedData analyticsCombinedData = new GoogleAnalyticsCombinedData(request);
GADataBase[] data = GADataServletParser.getGoogleAnalyticsCookieData(request);
```

See the [com.erikandcolleen.gacookieparser.servlet.*](https://ebeeson.github.io/ga-cookie-parser/javadoc/com/erikandcolleen/gacookieparser/servlet/package-summary.html) package for more details.


# Cookies

## Visitor (__utma)

[GAVisitorData](https://ebeeson.github.io/ga-cookie-parser/javadoc/com/erikandcolleen/gacookieparser/GAVisitorData.html)

This cookie is typically written to the browser upon the first visit to your site from that web browser.
If the cookie has been deleted by the browser operator, and the browser subsequently visits your site,
a new __utma cookie is written with a different unique ID. In most cases, this cookie is used to
determine unique visitors to your site and it is updated with each page view. Additionally,
this cookie is provided with a unique ID that Google Analytics uses to ensure both the validity and
accessibility of the cookie as an extra security measure.


## Session (__utmb)

[GASessionData](https://ebeeson.github.io/ga-cookie-parser/javadoc/com/erikandcolleen/gacookieparser/GASessionData.html)

This cookie is used to establish and continue a user session with your site.
When a user views a page on your site, the Google Analytics code attempts to
update this cookie. If it does not find the cookie, a new one is written and
a new session is established. Each time a user visits a different page on your
site, this cookie is updated to expire in 30 minutes, thus continuing a single
session for as long as user activity continues within 30-minute intervals. This
cookie expires when a user pauses on a page on your site for longer than 30 minutes.
You can modify the default length of a user session with the _setSessionCookieTimeout() method.


## Session, deprecated (__utmc)

[GASessionEndData](https://ebeeson.github.io/ga-cookie-parser/javadoc/com/erikandcolleen/gacookieparser/GASessionEndData.html)

This cookie is no longer used by the ga.js tracking code to determine session status.


## Custom Value (__utmv)

[GACustomValueData](https://ebeeson.github.io/ga-cookie-parser/javadoc/com/erikandcolleen/gacookieparser/GACustomValueData.html)

This cookie is not normally present in a default configuration of the tracking code.
The __utmv cookie passes the information provided via the _setVar() method, which you
use to create a custom user segment. This string is then passed to the Analytics servers
in the GIF request URL via the utmcc parameter. This cookie is only written if you have
added the _setVar() method for the tracking code on your website page.


## Website Optimizer (__utmx)

[GAWebsiteOptimizerData](https://ebeeson.github.io/ga-cookie-parser/javadoc/com/erikandcolleen/gacookieparser/GAWebsiteOptimizerData.html)

This cookie is used by [Website Optimizer](http://www.google.com/support/websiteoptimizer/) and only set when the Website Optimizer tracking
code is installed and correctly configured for your pages. When the optimizer script executes,
this cookie stores the variation this visitor is assigned to for each experiment, so the visitor
has a consistent experience on your site.  See the Website Optimizer Help Center for more information.


## Traffic Sources (__utmz)

[GATrafficSourcesData](https://ebeeson.github.io/ga-cookie-parser/javadoc/com/erikandcolleen/gacookieparser/GATrafficSourcesData.html)

This cookie stores the type of referral used by the visitor to reach your site,
whether via a direct method, a referring link, a website search, or a campaign
such as an ad or an email link. It is used to calculate search engine traffic,
ad campaigns and page navigation within your own site. The cookie is updated with
each page view to your site.


# See Also

[javadocs](https://ebeeson.github.io/ga-cookie-parser/javadoc/)
[tests](https://ebeeson.github.io/ga-cookie-parser/tests/)
