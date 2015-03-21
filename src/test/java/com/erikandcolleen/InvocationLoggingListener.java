package com.erikandcolleen;

import org.testng.*;

/**
 * Log all method invocations so test output logs don't all run together.
 *
 * @author <a href="https://github.com/ebeeson">Erik Beeson</a>
 */
public class InvocationLoggingListener implements IInvokedMethodListener {
	public void beforeInvocation(IInvokedMethod invokedMethod, ITestResult result) {
		ITestNGMethod testMethod = invokedMethod.getTestMethod();
		Reporter.log("");
		Reporter.log("**");
		Reporter.log(String.format("** %s.%s %s", testMethod.getTestClass().getRealClass().getSimpleName(), testMethod.getMethodName(), defaultString(testMethod.getDescription())));
		Reporter.log("**");
		Reporter.log("");
	}

	private String defaultString(String s) {
		return s == null ? "" : s;
	}

	public void afterInvocation(IInvokedMethod invokedMethod, ITestResult result) {
	}
}
