package simple;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxTest {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","D:\\VidyaWorks\\Automation\\geckodriver\\geckodriver.exe");

		//Calling firefox from a particular location
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary("D:\\VidyaWorks\\Automation\\FirefoxQuantum\\firefox.exe"); //This is the location where you have installed Firefox on your machine

		WebDriver driver = new FirefoxDriver(options);
		driver.get("http://www.google.com");
		
		driver.close();
		driver.quit();
	}
}
