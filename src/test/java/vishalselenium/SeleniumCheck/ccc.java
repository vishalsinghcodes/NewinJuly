package vishalselenium.SeleniumCheck;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ccc {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("F:\\Udemy Selenium\\Excel for Apache POI practice//Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int noofsheets = workbook.getNumberOfSheets();
		for (int i = 0; i < noofsheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet reqsheet = workbook.getSheetAt(i);
				Iterator<Row> rows = reqsheet.iterator();
				Row firstrow = rows.next();
				Iterator<Cell> ci = firstrow.cellIterator();
				int k = 0;
				int column = 0;
				while (ci.hasNext()) {
					Cell value = ci.next();
					if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase")) {
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							System.out.println(cv.next().getStringCellValue());
						}
					}
				}
			}
		}
	}
}
