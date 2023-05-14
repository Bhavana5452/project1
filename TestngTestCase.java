package com.testngPackage;



import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestngTestCase {

	private  WebDriver     driver;
	private  WebDriverWait wait;
	final private String  URL1 = "http://iamneo.ai";
	final private String  URL2 = "https://www.facebook.com";
	@BeforeTest
	public void setupTest() {
		//WebDriverManager.firefoxdriver().setup();
		//driver = new FirefoxDriver();
		// for chrome driver
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
		
		wait = new WebDriverWait(driver,30);
		driver.manage().window().maximize();
		}
	@AfterTest
	public void quitDriver() {
		driver.quit();
	}
	  @Test
		public void T03_backForwardRefresh() throws InterruptedException {
			driver.navigate().to(URL1);
			wait.until(ExpectedConditions.presenceOfElementLocated (By.id("neo-products-cover")));
			Assert.assertEquals(driver.getTitle(), "Learning and assessment solution for Universities and Enterprises");
			
			driver.navigate().to(URL2);
			Thread.sleep(1000);
			wait.until(ExpectedConditions.presenceOfElementLocated (By.id("email")));
			Assert.assertEquals(driver.getTitle(),"Facebook – log in or sign up");
			
			driver.navigate().back();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.presenceOfElementLocated (By.id("neo-products-cover")));
			Assert.assertEquals(driver.getTitle(), "Learning and assessment solution for Universities and Enterprises");
		   
		   
			System.out.println(URL1);
			
			
			driver.navigate().forward();
			
			wait.until(ExpectedConditions.presenceOfElementLocated (By.id("email")));
			Assert.assertEquals("Facebook – log in or sign up", driver.getTitle());
			driver.navigate().refresh();
		}
	}
