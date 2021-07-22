package vishalselenium.SeleniumCheck;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Fileexample {
	
	public static void main(String args[]) throws IOException {
		
		FileInputStream fis = new FileInputStream("F:\\Udemy Selenium\\Excel for Apache POI practice\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		String req = null;
		int sheetnumbers = workbook.getNumberOfSheets();
		for(int i=0;i<sheetnumbers;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("Link")) {
			XSSFSheet reqsheet  = workbook.getSheetAt(i);
			
			Iterator<Row> ri = reqsheet.iterator();
			Row firstrow = ri.next();
			
			Iterator<Cell> ci = firstrow.cellIterator();
			int count =0;
			int k =0;
			
			while(ci.hasNext()) {
				Cell c = ci.next();
				//k++;
				if(c.getStringCellValue().equalsIgnoreCase("Link")) {
					count = k;
				}
				k++;
					
			}	
			System.out.println(count);
			//System.out.println(ri.next().getCell(0).getStringCellValue());
			
			
			
			while(ri.hasNext()) {
				Row r = ri.next();
			    if(r.getCell(0).getStringCellValue().contains("Prime")) {
			    	req = r.getCell(count).getStringCellValue();
			    }
			}
			
			System.out.println(req);
			
			}
			
		}
		
		System.out.println(req);
		
		System.setProperty("webdriver.chrome.driver", "F:\\\\Udemy Selenium\\\\WebDrivers\\\\Chrome\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.className("gLFyf")).sendKeys(req);
		Actions a = new Actions(driver);
		//a.keyDown(Keys.ENTER).build().perform();
		//a.click(ele).sendKeys(req).keyDown(Keys.ENTER).build().perform();
		a.sendKeys(Keys.ENTER).build().perform();
		a.moveToElement(driver.findElement(By.xpath("//div[@class='ULSxyf']/div/div/div/div/div/div[2]/div/div[2]"))).click().build().perform();
		
		
		
		
		
	}

}
