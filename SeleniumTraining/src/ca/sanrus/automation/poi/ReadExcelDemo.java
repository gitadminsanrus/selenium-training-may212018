package ca.sanrus.automation.poi;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import ca.sanrus.automation.constant.Browser;
import ca.sanrus.automation.util.WebDriverUtil;

public class ReadExcelDemo {

	public static void main(String[] args) {

		//Step1 : Initialize the workbook
		try {
			XSSFWorkbook workbook = new XSSFWorkbook("config.xlsx");
			
			int totalSheets = workbook.getNumberOfSheets();
			System.out.println("Total Sheets = " + totalSheets);
			
			Sheet envUrlsSheet = workbook.getSheetAt(0);
			Sheet homePageElementsSheet = workbook.getSheet("HomePage_Elements");
			

			int rows = (envUrlsSheet.getLastRowNum() - envUrlsSheet.getLastRowNum());
			System.out.println("Row Count in Env URLs sheet = " + (envUrlsSheet.getLastRowNum() + 1));
			
			String prodUrl = "";
			
			for (int rowIndex = 0; rowIndex < envUrlsSheet.getLastRowNum(); rowIndex++) {
				Row row = envUrlsSheet.getRow(rowIndex);
				
				Cell cellA = row.getCell(0);
				if (cellA.getCellType() == CellType.STRING
						&& "PROD_URL".equals(cellA.getStringCellValue())) {
					prodUrl = row.getCell(1).toString();

					break;
				}
			}
			
			System.out.println("Production URL = " + prodUrl);
			
			WebDriver driver = WebDriverUtil.getWebDriver(Browser.CHROME);
			driver.navigate().to(prodUrl);
			
//			Row row = envUrlsSheet.getRow(9);
//			Cell cell = row.getCell(0);
////			System.out.println(cell.toString());
////			System.out.println(cell.getNumericCellValue());
////			System.out.println(cell.getCellType());
//			
//			CellType cellType = cell.getCellType();
//			
//			switch (cellType) {
//				case NUMERIC:
//					System.out.println(cell.getNumericCellValue());
//					break;
//					
//				case STRING:
//					System.out.println(cell.getStringCellValue());
//					break;
//					
//				case FORMULA:
//					System.out.println(cell.getCellFormula());
//					System.out.println(cell.getNumericCellValue());
//					break;
//
//				default:
//					System.out.println(cell.toString());
//					break;
//			}
			

			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
