package com.class02;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

public class TcSoftAssertion extends CommonMethods {
	
	@BeforeTest
	public void openAndNavigate() {
		setUp("chrome",Constants.HRMS_URL);
	}
	@AfterTest
	public void closeBrowse() {
		driver.quit();
	}
	@Test
	public void verifyLabels() {
		boolean fName=driver.findElement(By.className("hasTopFieldHelp")).isDisplayed();
		boolean empId=driver.findElement(By.xpath("//label[@for='employeeId']")).isDisplayed();
		boolean pFile=driver.findElement(By.xpath("//label[@for='photofile']")).isDisplayed();
		SoftAssert sAssert=new SoftAssert();
		sAssert.assertTrue(fName, "Full Name label is Displayed");
		sAssert.assertTrue(empId, "Employer id label is Displayed");
		sAssert.assertTrue(pFile, "Photo File Label is Displayed");
		
		driver.findElement(By.id("firstName")).sendKeys("John");
		driver.findElement(By.id("lastName")).sendKeys("Trovolta");
		driver.findElement(By.id("photofile")).sendKeys("C:/Users/sinan/Desktop/pic.jpg");
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		
		String actualEmpName=driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		System.out.println(actualEmpName);
		String expectedEmpName="John Trovolt";
		sAssert.assertEquals(actualEmpName,expectedEmpName,"Employee name is added");
		sAssert.assertAll();
		
	

}
}
