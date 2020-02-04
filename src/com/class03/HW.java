package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;

public class HW extends CommonMethods{
	@BeforeMethod(alwaysRun=true)
	public void openAndNavigate() {
		setUp("chrome","http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
	}
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		
		driver.quit();
	}
	@Test(groups= {"regression"},dataProvider="getData")
	public void addEmployee(String fName,String lName,String username,String password,String conPass) {
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Hum@nhrm123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		
		driver.findElement(By.xpath("//b[text()='PIM']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#menu_pim_addEmployee")));
		driver.findElement(By.cssSelector("a#menu_pim_addEmployee")).click();
		
		WebDriverWait wait1=new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#firstName")));
		
		driver.findElement(By.cssSelector("input#firstName")).sendKeys(fName);
		driver.findElement(By.cssSelector("input#lastName")).sendKeys(lName);
		driver.findElement(By.cssSelector("input#employeeId")).clear();
		driver.findElement(By.cssSelector("input#chkLogin")).click();
		driver.findElement(By.cssSelector("input#user_name")).sendKeys(username);
		driver.findElement(By.cssSelector("input#user_password")).sendKeys(password);
		driver.findElement(By.cssSelector("input#re_password")).sendKeys(conPass);
		
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		screenShot(fName);
		String actualId=driver.findElement(By.xpath("//*[@id='profile-pic']/h1")).getText();
		String expectedId=fName+" "+lName;
		SoftAssert sAssert=new SoftAssert();
		sAssert.assertEquals(actualId, expectedId,"Id info's NOT matched");
		
		sAssert.assertAll();
		
		
		
		
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] data= {
				{"bumbum","macar","kidar","hSinan17!!!!!","hSinan17!!!!!"},
				{"cumcum","nacar","mimar","hSinan17@@@@@","hSinan17@@@@@"},
				{"dumdum","gugam","ninar","hSinan17#####","hSinan17#####"},
				{"kumkum","mutar","pipar","hSinan17$$$$$","hSinan17$$$$$"},
				{"mummum","mincar","rirar","hSinan17%%%%%","hSinan17%%%%%"}};
		return data;
		
	}
	

}
