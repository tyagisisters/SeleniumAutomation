package com.rallypay.pages;

import static com.rallypay.utils.XpathUtils.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	 By loginButton = By.xpath(getHomeXpath("loginButton"));
 
	public void clickonLoginButton() {
		  driver.findElement(loginButton).click(); 

	}

	public String getLoginButtonText() {
		// TODO Auto-generated method stub
		return driver.findElement(loginButton).getText();
	}

}
