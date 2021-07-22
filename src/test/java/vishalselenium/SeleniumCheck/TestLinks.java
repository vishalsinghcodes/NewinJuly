package vishalselenium.SeleniumCheck;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLinks {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\\\Udemy Selenium\\\\WebDrivers\\\\Chrome\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		
//		///div[@class='tableFixHead']//table[@id='product']/tbody/tr/td[4]
		
		List<WebElement> amount = driver.findElements(By.xpath("//div[@class='tableFixHead']//table[@id='product']/tbody/tr/td[4]"));
		
		amount.stream().forEach(s->System.out.println(s.getText()));
		
		driver.manage().window().fullscreen();
		String path = System.getProperty("user.dir");
		System.out.println(path);
//		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scr, new File (path+"\\abc.png"));
//		Thread.sleep(2000L);
		
		
		WebElement scope = driver.findElement(By.id("gf-BIG"));
		List<WebElement> ele = scope.findElements(By.tagName("a"));
		for(WebElement e : ele) {
		
		HttpURLConnection conn = (HttpURLConnection) new URL(e.getAttribute("href")).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		if(conn.getResponseCode()>400) {
			System.out.println(e.getText() +" Broken");
		}else
			System.out.println(e.getText()+" Its fine");
		
		}
				
				
		
		

	}

}
