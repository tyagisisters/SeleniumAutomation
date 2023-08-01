package com.rallypay.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class ScreenshotUtils  {
	WebDriver driver;
	public void onTestFailure(ITestResult result, WebDriver driver) 
	 {
		this.driver=driver;
		  Reporter.setCurrentTestResult(result);
	        File img = new File(System.getProperty("user.dir")+"/screen_"+result.getMethod().getMethodName()+".png");

	        if(result.getStatus() == 2){ //failed scenario
	            Reporter.log("This is failed log from reporter.log", true);

 	            try {
		            FileOutputStream screenshotStream = new FileOutputStream(img);

					screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
		            screenshotStream.close();

				} catch (WebDriverException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 
	            Reporter.log(" <a href='"+img.getAbsolutePath()+"'> <img src='"+ img.getAbsolutePath()+"' height='200' width='200'/> </a>  ");

	        }
	 }
}
