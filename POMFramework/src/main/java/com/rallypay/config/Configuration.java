package com.rallypay.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	private static Properties properties;
	static {
		properties = new Properties();

		try {
			properties.load(new FileInputStream(
					"C:\\Users\\Lenovo\\eclipse-workspace\\POMFramework\\src\\main\\resources\\com\\rallypay\\resources\\Configuration.properties"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String applicationUrl_QA_URL() {
        
		String applicationUrl = properties.getProperty("applicationUrl_QA");
        if(applicationUrl != null) return applicationUrl;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String applicationUrl_DEV_URL() {
        String applicationUrl = properties.getProperty("applicationUrl_DEV");
        if(applicationUrl != null) return applicationUrl;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

}
