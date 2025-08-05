package week6.commonIntegrationExcel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CommonIntegrationExcel {

	public static String[][] getDataFromExcel(String excelFileName) throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+excelFileName+".xlsx");
		
		XSSFSheet ws = wb.getSheetAt(0);
		
		int rowCount = ws.getLastRowNum();
		
		short columnCount = ws.getRow(1).getLastCellNum();
		
		String[][] data = new String[rowCount][columnCount];
		
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				String stringCellValue = ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = stringCellValue;
			}
		}
		wb.close();
		return data;
	}

}
