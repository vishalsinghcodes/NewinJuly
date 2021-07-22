package vishalselenium.SeleniumCheck;



import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
	
	@Test(retryAnalyzer = vishalselenium.SeleniumCheck.RetryAnalyzer.class)
	public void mobiletest1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\\\Udemy Selenium\\\\WebDrivers\\\\Chrome\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
//		driver.findElement(By.xpath("//button[text()='Home']")).click();
//		driver.navigate().back();
		
		driver.findElement(By.id("dropdown-class-example")).click();	
		WebElement ddn = driver.findElement(By.id("dropdown-class-example"));
		Select s = new Select(ddn);
		s.selectByIndex(2);
		System.out.println(s.getFirstSelectedOption().getText());
		
		
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys("india");
		Thread.sleep(2000L);
		List<WebElement> option = driver.findElements(By.cssSelector("li.ui-menu-item"));
		
//		for(WebElement a : option) {
//			if(a.getText().equalsIgnoreCase("British Indian Ocean Territory"))
//				a.click();		
//		}
		
		List<WebElement> ll= option.stream().filter(v->v.getText().equalsIgnoreCase("British Indian Ocean Territory")).collect(Collectors.toList());
		ll.get(0).click();
		
		driver.findElement(By.id("checkBoxOption1")).click();
		
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected(), "It is correct");
			
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		
		
		
		
		driver.findElement(By.id("name")).sendKeys("Vishal Singh");
		driver.findElement(By.id("alertbtn")).click();
		String allerttext = driver.switchTo().alert().getText();;
		Thread.sleep(2000L);
		System.out.println(allerttext);
		driver.switchTo().alert().accept();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1200)");
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.id("mousehover"))).build().perform();
		driver.findElement(By.xpath("//a[text()='Top']")).click();
		ac.moveToElement(driver.findElement(By.xpath("//input[@name='enter-name']"))).click().keyDown(Keys.SHIFT).sendKeys("Vishal Singh").build().perform();
		
		driver.findElement(By.id("openwindow")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it =  windows.iterator();
		String basepage = it.next();
		String secondpage = it.next();
		
		driver.switchTo().window(secondpage);
		driver.close();
		
		driver.switchTo().window(basepage);
		js.executeScript("window.scrollBy(0,1200)");
		
		
//		Thread.sleep(5000L);
	//driver.close();
		
	}

}
