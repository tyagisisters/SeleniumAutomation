package com.rallypay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.rallypay.utils.XpathUtils.*;



public class LoginPage{

	private WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
 	}
	 By email = By.xpath(getLoginXpath("email"));
 	 By password=By.xpath(getLoginXpath("password"));
	 By signIn = By.xpath(getLoginXpath("signIn"));
	 By title = By.xpath(getLoginXpath("title"));
 
	public void enterEmail(String mail) {
 
		  driver.findElement(email).sendKeys(mail);
		
	}
	public void enterPassword(String psswrd)
	{
		  driver.findElement(password).sendKeys(psswrd);;
	}
	public void clickonSignIn()
	{
		  driver.findElement(signIn).click();
	}
	public String getTitleText() {
		// TODO Auto-generated method stub
		return driver.findElement(title).getText();
	}
}
