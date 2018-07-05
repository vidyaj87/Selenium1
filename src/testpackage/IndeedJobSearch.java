package testpackage;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IndeedJobSearch {

	public static void main(String[] args) throws InterruptedException {

		// Change as per your geckodriver download location
		System.setProperty("webdriver.gecko.driver","D:\\VidyaWorks\\Automation\\geckodriver\\geckodriver.exe");
	// I have 2 FF versions in my system. FF 54 and FF 61. Geckodriver works with FF version 55 and above. So I custom installed the FF61 version in the D drive
		File pathBinary = new File("D:\\VidyaWorks\\Automation\\FirefoxQuantum\\firefox.exe");
	//The below lines help to call FF from the path
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);   
		DesiredCapabilities desired = DesiredCapabilities.firefox();
		FirefoxOptions options = new FirefoxOptions();
		desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
		WebDriver driver = new FirefoxDriver(options);
		driver.get("https://www.google.co.in/");
		
	
		// Set implicit wait for 30 seconds
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Perform job search in Indeed website
		driver.get("http://www.indeed.co.in/");
		driver.findElement(By.id("what")).sendKeys("Selenium");
		driver.findElement(By.id("where")).sendKeys("Bangalore");
		driver.findElement(By.id("fj")).click(); // click find jobs button
		System.out.println("Search Results Page Title: " + driver.getTitle());
		System.out.println("Search Results Count Text:" + driver.findElement(By.id("searchCount")).getText());
		Thread.sleep(2000);
		driver.close();
		
		driver.quit();

		}
	
}
