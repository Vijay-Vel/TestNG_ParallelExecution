package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import threadManagers.ExtentManager;

public class TestGmail extends BaseTest {

	Logger logger = LogManager.getLogger(TestGmail.class);

	@Test
	public void testGmail() throws InterruptedException {
		
		ExtentManager.getTest().log(Status.INFO, "Opened Browser: "+map.get("Browser"));

		driver.get("https://workspace.google.com/intl/en-US/gmail/");
		Thread.sleep(7000);
		System.out.println(
				"Title of the page: " + driver.getTitle() + " and Thread id is " + Thread.currentThread().getId());
		ExtentManager.getTest().log(Status.INFO, "Opened Gmail Page!!!");
		logger.info("Opened Gmail Page!!!");

		String actual = driver.findElement(By.xpath("//div[@class='header__logos']/descendant::span")).getText();
		String expected = "Google";
		ExtentManager.getTest().log(Status.INFO, "Actual Page name: " + actual + " Expected Page name: " + expected);
		logger.info("Actual Page name: " + actual + " Expected Page name: " + expected);
		Assert.assertEquals(actual, expected);

	}

}
