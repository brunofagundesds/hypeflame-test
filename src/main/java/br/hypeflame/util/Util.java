package br.hypeflame.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
	public static WebDriver driver;	
	
	public static WebDriver selectBrowser(String browser) throws Exception {
		String so = GetOS.getOS();
		String exe = "";
		
		if (so.equals("win"))  {
			exe = ".exe";
		}
	switch (browser.toLowerCase()) {
		case "firefox":
			
			System.setProperty("webdriver.gecko.driver", "drivers/" + so + "/geckodriver" + exe);
			driver = new FirefoxDriver();
			break;

		case "chrome":
			
			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/" + so + "/chromedriver" + exe);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
			break;
			
		default:
			break;
		}
		
		return driver;
	}
		
	public static String getPropertyValue(String property) {
		String value = null;
		
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File("config.properties")));
			
			value = prop.getProperty(property);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	
	
	public static void click(String xpath, int timeout) {
		JavascriptExecutor exe = (JavascriptExecutor) Util.driver;

		WebElement generic = (new WebDriverWait(Util.driver, timeout))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		exe.executeScript("arguments[0].click()", generic);

	}

	public static void click(String xpath) {

		Util.click(xpath, 10);

	}

	public static void digitar(String xpath, String text, int timeout) {

		WebElement generic = (new WebDriverWait(Util.driver, timeout))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		generic.sendKeys(text);

	}

	public static void digitar(String xpath, String text) {

		Util.digitar(xpath, text, 10);
	}	
	
}