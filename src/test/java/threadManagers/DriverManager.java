package threadManagers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private static ThreadLocal<WebDriver> Threadlocaldriver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return Threadlocaldriver.get();

	}

	public static void setBrowser(String browser) {
		WebDriver driver = null;

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		Threadlocaldriver.set(driver);
	}

	public static void quitBrowser() {
		if (Threadlocaldriver.get() != null) {
			Threadlocaldriver.get().quit();
			Threadlocaldriver.remove();
		}
	}
}
