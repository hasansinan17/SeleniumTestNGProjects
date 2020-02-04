package com.class02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

import junit.framework.Assert;

public class groupDemo extends CommonMethods {
	@BeforeMethod(alwaysRun=true)
	public void openAndNavigate() {
		setUp("chrome",Constants.HRMS_URL);
	}
	@AfterTest(alwaysRun=true)
	public void closeBrowser(){
		driver.quit();
	}
	@Test(groups="regression")
	public void titleValidation() {
		String expectedTitle="Human Management Systems";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle,"Titles are NOT matched");
		
		
	}
	@Test(groups= {"regression,Login"})
	public void logoAndLogin() {
		SoftAssert sAssert=new SoftAssert();
		boolean isDisplayed=driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		sAssert.assertTrue(isDisplayed, "Log is  displayed");
		
		//log in
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		//verify Welcome element is displayed
		
		boolean welcomeIspresent=driver.findElement(By.id("welcome")).isDisplayed();
		sAssert.assertTrue(welcomeIspresent, "Welcome element is NOT present");
		sAssert.assertAll();
	}
	

}
