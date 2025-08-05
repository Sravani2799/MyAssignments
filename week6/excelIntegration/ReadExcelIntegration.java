package week6.excelIntegration;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelIntegration {

	public static String[][] readData() throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook("./data/testDataIntegration.xlsx");
		
		XSSFSheet ws = wb.getSheetAt(0);
		
		/*
		 * String stringCellValue = ws.getRow(1).getCell(0).getStringCellValue();
		 * System.out.println(stringCellValue);
		 */
		
		int rowCount = ws.getLastRowNum();
		
		short columnCount = ws.getRow(1).getLastCellNum();
		
		String[][] data = new String[rowCount][columnCount];
		
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				String stringCellValue2 = ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j]= stringCellValue2;
			}
		}
		wb.close();
		
		return data;

	}

}
