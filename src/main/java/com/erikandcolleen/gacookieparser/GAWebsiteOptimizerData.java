package com.erikandcolleen.gacookieparser;

/**
 * Website Optimizer (__utmx)
 *
 * This cookie is used by Website Optimizer and only set when the Website Optimizer tracking
 * code is installed and correctly configured for your pages. When the optimizer script executes,
 * this cookie stores the variation this visitor is assigned to for each experiment, so the visitor
 * has a consistent experience on your site.  See the Website Optimizer Help Center for more information.
 *
 * @see <a href="http://www.google.com/support/websiteoptimizer/">Website Optimizer Help Center</a>
 * @author Erik Beeson
 */
public class GAWebsiteOptimizerData extends GADataBase {
	public static final String COOKIE_NAME = "__utmx";

	public GAWebsiteOptimizerData(String value) {
		super(value);
	}
}
