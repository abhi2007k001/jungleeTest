package com.appium.Utilies;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appium.Base.baseTest;

public class seleniumUtils extends baseTest {

	

	// Method to wait untill webelement available
	public static void waitforForElementAvailable(WebElement element) {

		WebDriverWait wait = new WebDriverWait(baseTest.driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Method to get random name

	public static String getRandomEmail() {

		// generating a random email address
		Random random = new Random();
		int n = (int) (Math.random() * 10000 + 1);
		String email = "abc" + Integer.toString(n) + "@gmail.com";
		return email;

	}

}
