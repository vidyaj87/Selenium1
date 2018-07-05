package simple;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
	public class TestMarionette {
 
	public static void main(String[] args) throws InterruptedException {
		
		
		
		// Change as per your geckodriver download location
		System.setProperty("webdriver.gecko.driver","D:\\VidyaWorks\\Automation\\geckodriver\\geckodriver.exe");
		
		// I have 2 FF versions in my system. FF 54 and FF 61. Geckodriver works with FF version 55 and above. So I custom installed the FF61 version in the D drive
		File pathBinary = new File("D:\\\\VidyaWorks\\\\Automation\\\\FirefoxQuantum\\firefox.exe");
		//The below lines help to call FF from the path
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);   
		DesiredCapabilities desired = DesiredCapabilities.firefox();
		FirefoxOptions options = new FirefoxOptions();
		
		//Setting the capabilities to the firefox driver
		//desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));

		desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
		desired.setCapability("marionette", true);
	
			
		// Now we are setting up a firefox profile  for our browser.
		//This avoids popping up of certificate issues while running our code in server.
		//This is especially useful while running our codes using CI like Jenkins
		
	    FirefoxProfile fp = new FirefoxProfile();
	    // for config list see this :
	    // http://kb.mozillazine.org/About:config_entries#Profile.
	    fp.setAcceptUntrustedCertificates(true);
	    fp.setAssumeUntrustedCertificateIssuer(true);
	    //fp.setEnableNativeEvents(false);
	    desired.setCapability(FirefoxDriver.PROFILE, fp);
		
	    //Finally creating the driver object
	    WebDriver driver = new FirefoxDriver(options);
		
		//Going to fetch google.com
		driver.get("http://www.google.com");
		Thread.sleep(2000);
		
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
	
