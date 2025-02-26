package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import tests.BaseTest;
import threadManagers.DriverManager;

public class ScreenshotUtility extends BaseTest {
	 
	public static String takeScreenShot() throws IOException {
 
		TakesScreenshot ts = (TakesScreenshot) (DriverManager.getDriver());
		File src = ts.getScreenshotAs(OutputType.FILE);
 
		File dest = new File(System.getProperty("user.dir") + "\\screenshots\\screenshot"
				+ System.currentTimeMillis() + ".png");
		FileUtils.copyFile(src, dest);
 
		String destpath = dest.getAbsolutePath();
		// System.out.println("Screenshot Taken");
		return destpath;
 
	}
 
}
 