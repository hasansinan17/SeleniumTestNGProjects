package com.class02;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class practice extends CommonMethods{
	@BeforeMethod
	public void openAndNavigate() {
		setUp("chrome",Constants.HRMS_URL);
	}
	@AfterMethod
	public void closeBrowsers() {
		driver.quit();
		
	}
	@Test(priority=1)
	public void titleValidation() {
		System.out.println("Executing title validation test case----------");
		String expectedTitle="Human Management Systems";
		String actualTitle=driver.getTitle();//Human Management System
		Assert.assertEquals(actualTitle, expectedTitle,"Titles are Not matched");
		
		System.out.println("I am a text after assertion");
		
		
	}
	@Test(priority=2)
	public void logoValidation() {
		boolean isDisplayed=driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		
		Assert.assertTrue(isDisplayed, "Syntax Logo is NOT displayed");
	}

}
