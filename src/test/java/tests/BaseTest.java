package tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;

import threadManagers.DriverManager;
import utilities.ExcelUtility;

public class BaseTest {
	public static ExtentReports extentreport;
	protected WebDriver driver;
	public HashMap<String, String> map;
	
	Logger logger = LogManager.getLogger(BaseTest.class);

	@Parameters({ "scenario" })
	@BeforeMethod
	public void setup(String scenario) throws IOException {
		
		map = ExcelUtility.getExcelData("Sheet1", scenario,
				System.getProperty("user.dir") + "\\TestData\\TestData.xlsx");
		System.out.println(map);
		DriverManager.setBrowser(map.get("Browser"));
		driver = DriverManager.getDriver();
		logger.info("Browser opened: " + map.get("Browser"));
		
		
		
	}

	@AfterMethod
	public void teardown() {

		DriverManager.quitBrowser();
		logger.info("Browser has been closed");
	}
}
