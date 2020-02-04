package com.class02;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.class2.WebElement;
import com.utils.CommonMethods;
import com.utils.Constants;

public class practice3 extends CommonMethods {
	@BeforeMethod
	public void openAndNavigate() {
		setUp("chrome",Constants.HRMS_URL);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void validationOfLogo() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		boolean isTrue = driver.findElement(By.xpath("//img[contains(@src,'syntax.png')]")).isDisplayed();
		Assert.assertTrue(isTrue, "Logo is Not Displayed");
		Assert.assertN
	}
	@Test(priority=1)
	public void validationOfMessage() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("btnLogin")).click();
		WebElement error = driver.findElement(By.id("spanMessage"));
		String expectedError="Password cannot be empty";
		if (error.isDisplayed()) {
			System.out.println("error is dislayed");
			if(error.getText().equals(expectedError)) {
				System.out.println("Erorr msg is correct. Test Pass");
			}else {
				System.out.println("Erorr msg is not correct. Test Fail");
			}
		} else {
			System.out.println("error is NOT displayed. Test Fail");
		}
	}

}
