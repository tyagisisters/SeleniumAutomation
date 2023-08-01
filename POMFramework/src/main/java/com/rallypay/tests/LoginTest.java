package com.rallypay.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rallypay.pages.HomePage;
import com.rallypay.pages.LoginPage;
import com.rallypay.utils.ExcelUtils;

public class LoginTest extends BaseTest {

	@Test(dataProvider = "Positive_Scenario")
	public void Login(String testcase, String sUserName, String sPassword) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		hp.clickonLoginButton();
		lp.enterEmail(sUserName);
		Reporter.log("LEmail entered");

		lp.enterPassword(sPassword);
		Reporter.log("Password entered");

		lp.clickonSignIn();
		Reporter.log("Login successfully done");
	}

	@DataProvider(name = "Positive_Scenario")

	public Object[][] Authentication() throws Exception {

		// Setting up the Test Data Excel file

		Object obj[][] = ExcelUtils.getExcelData("TestData.xlsx", "TestData");
		return obj;
 
	}

//	@Test
//	public void SecondTest() {
//		LoginPage lp = new LoginPage(driver);
//
//		//Assert.assertEquals(lp.getTitleText(), "RALLY PAY"); 
//		Assert.fail();
// 	}

}
