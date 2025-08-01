package TestNGMarathon;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelIntegrationTestNGMarathon {
	
	public static String[][] saveData(String ExcelWorkBook) throws IOException {
		
		/*
		 * As data is in Excel workbook we have instantiated the XFFSWorkbook class
		 * and created a variable to pass the Workbook names
		 */
		XSSFWorkbook wbook = new XSSFWorkbook("./data/" + ExcelWorkBook +".xlsx");
		
		//Worksheet is located with Index
		XSSFSheet wsheet = wbook.getSheetAt(0);
		
		//RowCount and Column Count has been retrived
		int rowCount = wsheet.getLastRowNum();
		short colCount = wsheet.getRow(1).getLastCellNum();
		
		//initiated 2-D array to store the values and pass the data
		String[][] data = new String[rowCount][colCount];
		
		//nested for loop has been initiated
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				String stringCellValue = wsheet.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = stringCellValue;
			}
		}
		//Workbook closed and the values in data are returned
		wbook.close();
		return data;
	}

}
