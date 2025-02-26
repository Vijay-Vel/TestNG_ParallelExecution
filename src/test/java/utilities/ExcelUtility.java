package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	static HashMap<String, String> map1;
	 
	public synchronized static HashMap<String, String> getExcelData(String sheet, String Scenario, String path) throws IOException {
 
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
 
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = workbook.getSheet(sheet);
 
		map1 = new HashMap<>();
 
		int rows = sheet1.getLastRowNum();
 
		int cols = sheet1.getRow(1).getLastCellNum(); // 4
		int column = 0;
 
		for (int r = 0; r <= rows; r++) {
 
			XSSFRow row = sheet1.getRow(r);
 
			for (int c = 0; c <= column; c++) {
 
				XSSFCell cell = row.getCell(c);
 
				CellType celltype = cell.getCellType();
				String cellvalue = getCellType(cell, celltype);
 
				if (cellvalue.equals(Scenario)) {
					int reqrow = r;
					for (int i = 0; i < cols; i++) {
						Cell cell1 = sheet1.getRow(0).getCell(i);
						CellType celltype1 = cell1.getCellType();
						String key1 = getCellType(cell1, celltype1);
 
						Cell cell2 = sheet1.getRow(reqrow).getCell(i);
						CellType celltype2 = cell2.getCellType();
						String val1 = getCellType(cell2, celltype2);
 
						map1.put(key1, val1);
					}
 
					for (Map.Entry<String, String> entry : map1.entrySet()) {
						String key = entry.getKey();
						String val = entry.getValue();
						System.out.print(val + " ");
					}
					System.out.println("\n" + Scenario + " :" + map1);
				}
			}
		}
		return map1;
	}
 
	public static String getCellType(Cell cell, CellType celltype) {
		String cellvalue = null;
		switch (celltype) {
		case STRING:
			cellvalue = cell.getStringCellValue();
			break;
 
		case NUMERIC:
			cellvalue = (String.valueOf(cell.getNumericCellValue()).toString());
			break;
		default:
			break;
		}
		return cellvalue;
	}

}
