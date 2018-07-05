package simple;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxTestTwo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver","D:\\VidyaWorks\\Automation\\geckodriver\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary("D:\\VidyaWorks\\Automation\\FirefoxQuantum\\firefox.exe"); 
		/*The Desired Capabilities Class helps us to tell the webdriver, which environment we are going to use in our test script.
		 * */
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("moz:firefoxOptions", options);
		//set more capabilities as per your requirements
 
		FirefoxDriver driver = new FirefoxDriver(capabilities);
		driver.get("http://www.google.com");
		
		driver.close();
		driver.quit();
	}
}