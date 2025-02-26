package tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import threadManagers.ExtentManager;

public class TestGoogle extends BaseTest {

	Logger logger = LogManager.getLogger(TestGoogle.class);

	@Test
	public void testGoogle() throws InterruptedException, AWTException {

		ExtentManager.getTest().log(Status.INFO, "Opened Browser: "+map.get("Browser"));

		driver.get("https://www.google.co.uk/");
		Thread.sleep(10000);
		System.out.println(
				"Title of the page: " + driver.getTitle() + " and Thread id is " + Thread.currentThread().getId());
		ExtentManager.getTest().log(Status.INFO, "Opened Google Page!!!");

		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(map.get("Value"));
		Thread.sleep(2000);
		ExtentManager.getTest().log(Status.INFO, "Entered Search Value: " + map.get("Value"));
		logger.info("Entered Search Value: " + map.get("Value"));
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(10000);

	}
}
