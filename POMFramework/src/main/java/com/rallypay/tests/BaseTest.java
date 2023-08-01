package com.rallypay.tests;

import java.io.IOException;
import com.rallypay.config.*;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.rallypay.utils.*;

public class BaseTest{

	public static WebDriver driver;
	public static org.apache.logging.log4j.Logger log;
	public static String dir = System.getProperty("user.dir");

	@BeforeSuite
	public void setUp() throws IOException {
		System.setProperty("log4j.configurationFile",
				dir + "\\src\\main\\resources\\com\\rallypay\\resources\\log4j2.xml");

		log = LogManager.getLogger(BaseTest.class.getName());

		driver = new FirefoxDriver();

		System.setProperty("webdriver.gecko.driver", dir + "\\src\\main\\resources\\geckodriver.exe");
		log.info("webdriver setup done");

	 
	}

	@BeforeTest
	@Parameters({  "URL", "Env" })
	public void setupBrowserAndURL( String URL, String Env) {
		Configuration configFileReader = new Configuration();
 
		if (Env.equalsIgnoreCase("QA")) {
			if (URL.equalsIgnoreCase("QA_URL")) {
				driver.get(configFileReader.applicationUrl_QA_URL());
				log.info("Website hit");

				driver.manage().window().maximize();

			}
		}
		if (Env.equalsIgnoreCase("DEV")) {
			if (URL.equalsIgnoreCase("DEV_URL")) {
				driver.get(configFileReader.applicationUrl_DEV_URL());

			}
		}
	}

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			log.info("driver quitted");

		}

	}

}
