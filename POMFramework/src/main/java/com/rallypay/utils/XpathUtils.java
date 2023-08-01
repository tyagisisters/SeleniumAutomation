package com.rallypay.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class XpathUtils {

	private static Properties homexpaths, loginxpaths;
	static {
		homexpaths = new Properties();
		loginxpaths = new Properties();

		try {
			homexpaths.load(new FileInputStream(
					"C:\\Users\\Lenovo\\eclipse-workspace\\POMFramework\\src\\main\\resources\\com\\rallypay\\resources\\xpaths\\HomePageXpaths.properties"));
			loginxpaths.load(new FileInputStream(
					"C:\\Users\\Lenovo\\eclipse-workspace\\POMFramework\\src\\main\\resources\\com\\rallypay\\resources\\xpaths\\LoginPageXpaths.properties"));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getHomeXpath(String elementKey) {
		return homexpaths.getProperty(elementKey);

	}

	public static String getLoginXpath(String elementKey) {
		return loginxpaths.getProperty(elementKey);

	}

}
