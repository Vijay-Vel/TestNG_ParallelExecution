package utilities;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import threadManagers.ExtentManager;

public class MyListener implements ITestListener {
	public static ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test = SuiteListener.extentreports
				.createTest(result.getMethod().getMethodName() + " of thread " + Thread.currentThread().getId());
		ExtentManager.setTest(test);
		ExtentManager.getTest().assignCategory("Thread: " + Thread.currentThread().getId());
		ExtentManager.getTest().assignAuthor("Vijay");
		ExtentManager.getTest().assignDevice(System.getProperty("os.name"));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentManager.getTest().log(Status.PASS, " Testcase is Passed Successfully");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		try {
			String screenshotPath = ScreenshotUtility.takeScreenShot();
			ExtentManager.getTest().fail(result.getThrowable(),
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath, "Failed Screenshot").build());

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}
}
