package com.Actitime.genericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.pom.LoginPage;

public class Baseclass {
public static WebDriver driver;
FileLibrary fl = new FileLibrary();

	@BeforeSuite
	public void databaseConnection() {
		Reporter.log("database connected",true);
	}
	
	@BeforeClass
	public void launchBrowser() throws IOException {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String url = fl.readData_FromPropertyFile("url");
		driver.get(url);
		Reporter.log("browser launch",true);
	}
		@BeforeMethod
		public void login() throws IOException {
			LoginPage lp = new LoginPage(driver);
			String un = fl.readData_FromPropertyFile("username");
			lp.getUntbx().sendKeys(un);
			String pas = fl.readData_FromPropertyFile("passward");
			lp.getPwtbx().sendKeys(pas);;
			lp.getLgbtn().click();;
			Reporter.log("login successful",true);
		}
		
		
		@AfterMethod
		public void logout() {
			driver.findElement(By.id("logoutLink")).click();
			Reporter.log("logged out successfully",true);
		}
		
		@AfterClass
		public void closebrowser() {
			driver.close();
			Reporter.log("browser closed",true);
		}
		
		@AfterSuite
		public void closedatabaseconnection() {
			Reporter.log("database disconnected",true);
		}
}



