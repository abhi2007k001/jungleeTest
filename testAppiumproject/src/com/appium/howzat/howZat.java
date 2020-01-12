package com.appium.howzat;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.appium.Base.baseTest;
import com.appium.Utilies.fileUtils;
import com.appium.Utilies.seleniumUtils;

import io.appium.java_client.MobileBy;

public class howZat extends baseTest {
	
 
	@BeforeClass

	public static void setUp() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		baseTest.InitializeAppDriver();
		

	}


	@Test(description = "Download a app",priority = 1)
	public static void DownloadApp() {
		
		seleniumUtils.waitforForElementAvailable(driver.findElement(MobileBy.xpath(prop.getProperty("download"))));
		driver.findElement(MobileBy.xpath(prop.getProperty("download"))).click();
		Assert.assertTrue(fileUtils.verifyFIleDownload(prop.getProperty("folderPath"), "howzat.apk"),
				"FAIL : User not able to download app");
		System.out.println("PASS: User succesfully able to download a app");
	}

	
	@Test(description = "Register a user and login with same user",priority = 1)
	public static void registerAndSignUpwithNewUser() {
		driver.findElement(MobileBy.xpath(prop.getProperty("register"))).click();
		seleniumUtils.waitforForElementAvailable(driver.findElement(MobileBy.xpath(prop.getProperty("paceHolder"))));
		driver.findElement(MobileBy.xpath(prop.getProperty("paceHolder"))).sendKeys(seleniumUtils.getRandomEmail());
		driver.findElement(MobileBy.xpath(prop.getProperty("pasword"))).sendKeys(prop.getProperty("pwd"));
		driver.findElement(MobileBy.xpath(prop.getProperty("register"))).click();
		driver.close();
		
		//launch browswer
		baseTest.InitializeAppDriver();
		
		seleniumUtils.waitforForElementAvailable(driver.findElement(MobileBy.xpath(prop.getProperty("paceHolder"))));
		driver.findElement(MobileBy.xpath(prop.getProperty("loginButton"))).click();
		driver.findElement(MobileBy.xpath(prop.getProperty("placeHolder"))).sendKeys(seleniumUtils.getRandomEmail());
		driver.findElement(MobileBy.xpath(prop.getProperty("pasword"))).sendKeys(prop.getProperty("pwd"));
		driver.findElement(MobileBy.xpath(prop.getProperty("loginButton"))).click();
		driver.findElement(MobileBy.xpath(prop.getProperty("accountSettings"))).click();
		driver.findElement(MobileBy.xpath(prop.getProperty("AccountName"))).click();
		//Validation
		Assert.assertTrue(driver.findElement(MobileBy.xpath("//*[@name='email' and text()='"+seleniumUtils.getRandomEmail()+"'][1]")).isDisplayed());
		System.out.println("PASS: User succesfully able to login using registered user");
		

		
	}

}
