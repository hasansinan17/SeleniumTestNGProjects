package com.class02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

public class practice2 extends CommonMethods {
	@BeforeTest
	public void openAndNavigate() {
		setUp("chrome",Constants.HRMS_URL);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void logoAndLogin() {
		boolean logoDisplayed=driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		logoDisplayed=false;
		//Hard Assert will fail and execution will stop at that point
		//Assert.assertTrue(logoDisplayed,"Logo is NOT Displayed)
		
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(logoDisplayed, "Logo is NOT displayed");
		
		driver.findElement(By.name("txtUserName")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.name("Submit")).click();
		
		boolean welcomeDisplayed=driver.findElement(By.id("welcome")).isDisplayed();
		softAssert.assertTrue(welcomeDisplayed, "Welcome element is NOT displayed");
		softAssert.assertAll();
		
		
	}
	
	
	
	

}
