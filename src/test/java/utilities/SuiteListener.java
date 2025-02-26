package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class SuiteListener implements ISuiteListener {

	public static ExtentReports extentreports;
	String timeStamp = new SimpleDateFormat("ddMMyyyyy_HHmmss").format(new Date());
	String reportName = "Report_" + timeStamp;
	String filePath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + reportName+".html";

	@Override
	public void onStart(ISuite suite) {

		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter(filePath);
		htmlreporter.config().setEnableAuthorView(true);
		htmlreporter.config().setEnableCategoryView(true);
		htmlreporter.config().setEnableExceptionView(true);
		htmlreporter.config().setEnableTestRunnerLogsView(true);

		extentreports = new ExtentReports();
		extentreports.attachReporter(htmlreporter);

		extentreports.setSystemInfo("OS", System.getProperty("os.name"));
		extentreports.setSystemInfo("JAVA", System.getProperty("java.version"));
		extentreports.setSystemInfo("Host Name", System.getProperty("user.name"));
		extentreports.setSystemInfo("Browser Name", "Chrome");
		extentreports.setSystemInfo("Application", "Google");

	}

	@Override
	public void onFinish(ISuite suite) {

		extentreports.flush();
		
	}
}
