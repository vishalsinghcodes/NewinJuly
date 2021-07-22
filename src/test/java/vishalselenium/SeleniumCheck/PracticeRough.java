package vishalselenium.SeleniumCheck;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PracticeRough {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "F:\\\\Udemy Selenium\\\\WebDrivers\\\\Chrome\\\\chromedriver.exe");
		DesiredCapabilities dc = new DesiredCapabilities().chrome();
		dc.acceptInsecureCerts();
		ChromeOptions c = new ChromeOptions();
		c.merge(dc);
		WebDriver driver = new ChromeDriver(c);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//		String un = "admin";
//		String pw = "admin";
//		String url = "https://"+un+":"+pw+"@the-internet.herokuapp.com/";
//		driver.get(url);
//		driver.findElement(By.xpath("//a[text()='Basic Auth']")).click();
		
		driver.get("https://the-internet.herokuapp.com/upload");
		driver.findElement(By.xpath("//input[@id='file-upload']")).click();
		Thread.sleep(2000L);
		Runtime.getRuntime().exec("G:\\fileuploadforautoit.exe");
		Thread.sleep(2000L);
		driver.findElement(By.className("button")).click();
		

		
		
		//https://the-internet.herokuapp.com/
		//driver.get("https://"+un+":"+pw+"the-internet.herokuapp.com/");
		
		
		
	}

}
