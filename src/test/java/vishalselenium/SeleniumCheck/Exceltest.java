package vishalselenium.SeleniumCheck;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceltest {

	public static void main(String[] args) throws IOException {
		String req = null;
		FileInputStream fis = new FileInputStream("F:\\Udemy Selenium\\Excel for Apache POI practice\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int noofsheets = workbook.getNumberOfSheets();
		for (int i = 0; i < noofsheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Link")) {
				XSSFSheet reqsheet = workbook.getSheetAt(i);

				Iterator<Row> ri = reqsheet.iterator();
				Row firstrow = ri.next();

				Iterator<Cell> ci = firstrow.cellIterator();
				int colno = 0;
				int k = 0;

				while (ci.hasNext()) {
					Cell value = ci.next();
					if (value.getStringCellValue().equalsIgnoreCase("Names"))
						colno = k;
					k++;
				}
				System.out.println(colno);
				while (ri.hasNext()) {
					Row r = ri.next();
					if(r.getCell(0).getStringCellValue().equalsIgnoreCase("Prime")) {						
					Iterator<Cell> cc = r.cellIterator();
					cc.next();
					
						req = cc.next().getStringCellValue();
				//	ri.next();

				}
			}

		}

		System.out.println(req);
	}

}
}
