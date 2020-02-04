package com.class02;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class TcAssertion extends CommonMethods {
	/*
	 * TC 1: HRMS Add Employee: 1.Open chrome browser
	 * 2.Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
	 * 3.Login into the application
	 * 4.Click on Add Employee
	 * 5.Verify labels: Full Name, Employee Id, Photograph are displayed
	 * 6.Provide Employee First and Last Name
	 * 7.Add a picture to the profile
	 * 8.Verify Employee has been added successfully
	 * 9.Close the browser
	 */
	@BeforeTest
	public void openAndNavigate() {
		setUp("chrome","http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		
		
	}
//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//		
//	}
	@Test
	public void verifyLabels() {
		boolean fName=driver.findElement(By.className("hasTopFieldHelp")).isDisplayed();
		boolean empId=driver.findElement(By.xpath("//label[@for='employeeId']")).isDisplayed();
		boolean pFile=driver.findElement(By.xpath("//label[@for='photofile']")).isDisplayed();
		Assert.assertTrue(fName, "Full Name label is Displayed");
		Assert.assertTrue(empId, "Employer id label is Displayed");
		Assert.assertTrue(pFile, "Photo File Label is Displayed");
		
		driver.findElement(By.id("firstName")).sendKeys("John");
		driver.findElement(By.id("lastName")).sendKeys("Trovolta");
		driver.findElement(By.id("photofile")).sendKeys("C:/Users/sinan/Desktop/pic.jpg");
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		
		String actualEmpName=driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		System.out.println(actualEmpName);
		String expectedEmpName="John Trovolt";
		Assert.assertEquals(actualEmpName,expectedEmpName,"Employee name is added");
		
	}
	
	
	
	

}
