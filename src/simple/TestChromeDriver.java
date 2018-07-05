package simple;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestChromeDriver {
	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver","D:\\VidyaWorks\\Automation\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		// xpath is //*[@id="lst-ib"]
		driver.findElement(By.id("lst-ib")).sendKeys("Terrificminds");
		//xpath is //*[@id="hplogo"]
		driver.findElement(By.id("hplogo")).click();;
		// Click on google search button
		driver.findElement(By.xpath("/html/body/div[1]/div[4]/form/div[2]/div[3]/center/input[1]")).click();
		System.out.println("Page title is "+driver.getTitle());
		
	driver.close();
	driver.quit();
}
}
