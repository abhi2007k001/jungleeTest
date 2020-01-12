package com.appium.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;

public class baseTest {

	@SuppressWarnings("rawtypes")
	public static AppiumDriver driver = null;
	public static Properties prop=null;
	
	
	public static void luanchdriver() {
		//Setting desired capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Chrome");
		capabilities.setCapability("VERSION", "10.0.0"); 
		capabilities.setCapability("deviceName","Redmi K20");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("udid", "a6089028");

		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("androidPackage", "com.android.chrome");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		capabilities.setCapability("autoAcceptAlerts", true); 
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	       chromePrefs.put("profile.default_content_settings.popups", 0);
	       chromePrefs.put("download.default_directory", "");
		
		options.setExperimentalOption("prefs",chromePrefs);
		
		//Load prop file
		
		 File file = new File("D:/Dev/ReadData/src/datafile.properties");
		 FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			prop = new Properties();
			
			//load properties file
			try {
				prop.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		
		//Initiating new remotedriver instance
		try {
			driver = (AppiumDriver) new RemoteWebDriver (new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			
			System.out.println(e.getMessage());
		}
		//Loading the URL
		driver.get("https://www.howzat.com");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
	}


	public static void InitializeAppDriver() {
		// TODO Auto-generated method stub
		
	}
	
}
