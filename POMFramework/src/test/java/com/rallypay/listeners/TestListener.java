package com.rallypay.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.rallypay.utils.ScreenshotUtils;

public class TestListener implements ITestListener {

@Override
public void onFinish(ITestContext contextFinish) {
System.out.println("onFinish method finished");

}

@Override
public void onStart(ITestContext contextStart) {
System.out.println("onStart method started");
}

@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
System.out.println("Method failed with certain success percentage"+ result.getName());

}

@Override
public void onTestFailure(ITestResult result) {
	WebDriver driver= null;
System.out.println("Method failed"+ result.getName());
try {
	driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
} catch (IllegalArgumentException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IllegalAccessException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (NoSuchFieldException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SecurityException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
ScreenshotUtils screenshot = new ScreenshotUtils();
screenshot.onTestFailure(result, driver);

}

@Override
public void onTestSkipped(ITestResult result) {
System.out.println("Method skipped"+ result.getName());

}

@Override
public void onTestStart(ITestResult result) {
System.out.println("Method started"+ result.getName());

}

@Override
public void onTestSuccess(ITestResult result) {
System.out.println("Method passed"+ result.getName());

}

}
