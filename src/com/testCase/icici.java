package com.testCase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class icici {
	WebDriver driver;
	String typeOfDeposit = "Quarterly Payout";

	@Test
	public void f() throws InterruptedException {

		/// setting type of fixed eposit and amount.................................

		driver.switchTo().frame("paymframe");

		driver.findElement(By.xpath("//input[@id='loanAmount']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='loanAmount']")).sendKeys("60000");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//select[@id='ddlTypeOfFixedDeposit']")).click();
		Select select = new Select(driver.findElement(By.xpath("//select[@id='ddlTypeOfFixedDeposit']")));
		select.selectByValue("Quarterly Payout");

		String rateOfInterest = driver.findElement(By.xpath("//span[@id='spnRateOfInterest']")).getText();
		System.out.println("rate of interest :" + rateOfInterest);

		String maturityValue = driver.findElement(By.xpath("//span[@id='spnMaturityValue']")).getText();
		System.out.println("maturity value :" + maturityValue);

		String aggrigateInterestAmount = driver.findElement(By.xpath("//span[@id='spnAIAmount']")).getText();
		System.out.println("aggrigate interest amount :" + aggrigateInterestAmount);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='idDays']")).click();;
	
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='tenureDay']")).clear();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='tenureDay']")).sendKeys("1000");
		
		driver.findElement(By.xpath("//select[@id='ddlTypeOfFixedDeposit']")).click();
		
		Select select1 = new Select(driver.findElement(By.xpath("//select[@id='ddlTypeOfFixedDeposit']")));
		select1.selectByValue("Quarterly Payout");
		
		String maturityValue1 = driver.findElement(By.xpath("//span[@id='spnMaturityValue']")).getText();
		System.out.println("maturity value1 :" + maturityValue1);

		String aggrigateInterestAmount1 = driver.findElement(By.xpath("//span[@id='spnAIAmount']")).getText();
		System.out.println("aggrigate interest amount1 :" + aggrigateInterestAmount1);

	}

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.icicibank.com/calculator/fd-calculator.html");
		 driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
