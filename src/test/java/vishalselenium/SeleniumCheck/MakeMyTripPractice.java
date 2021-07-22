package vishalselenium.SeleniumCheck;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class MakeMyTripPractice {
	
	
	@Test
	public void Test2() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "F:\\\\Udemy Selenium\\\\WebDrivers\\\\Chrome\\\\chromedriver.exe");
	DesiredCapabilities dc = new DesiredCapabilities().chrome();
	dc.acceptInsecureCerts();
	dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	
	ChromeOptions c = new ChromeOptions();
	c.addArguments("--disable-notifications");
	c.merge(dc);
	
	WebDriver driver = new ChromeDriver(c);
	driver.get("https://www.spicejet.com/");
	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
	Thread.sleep(2000L);
	driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_originStation1']//option[@value='ATQ']")).click();
	
	}

}
