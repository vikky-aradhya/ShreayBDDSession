package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public LinkedHashMap<String, String> getRowDataHM(String filePath, String workBookName, String sheetName,
			int rowindex) throws Exception {

		// Load Excel sheet
		FileInputStream file = new FileInputStream(new File(filePath + "\\" + workBookName + ".xlsx"));
		// Load work book
		XSSFWorkbook book = new XSSFWorkbook(file);
		// Load sheet
		XSSFSheet sheet = book.getSheet(sheetName);
		// Load all Rows
		XSSFRow row = sheet.getRow(rowindex);
		XSSFRow headerRow = sheet.getRow(0);
		// Load all columns
		LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
		int firstCell = headerRow.getFirstCellNum();
		int lastCell = headerRow.getLastCellNum();
		XSSFCell cell1 = headerRow.getCell(firstCell);
		XSSFCell cell2 = row.getCell(firstCell);

		// Iterate through rows and columns
		for (int i = firstCell; i < lastCell; i++) {
			cell1 = headerRow.getCell(i);
			cell2 = row.getCell(i);
			String headerValue = cell1.getStringCellValue();
			String fieldValue;
			if (cell2 == null) {
				fieldValue = "";
			} else {
				fieldValue = cell2.getStringCellValue();
			}
			data.put(headerValue, fieldValue);
		}
		book.close();
		return data;
	}

	public List<LinkedHashMap<String, String>> getTestDataListByScenario(String filePath, String workBookName,
			String sheetName, String scenarioName) throws Exception {

		// Load Excel sheet
		FileInputStream file = new FileInputStream(new File(filePath + "\\" + workBookName + ".xlsx"));
		// Load work book
		XSSFWorkbook book = new XSSFWorkbook(file);
		// Load sheet
		XSSFSheet sheet = book.getSheet(sheetName);

		// Iterate to respective scenarios
		List<LinkedHashMap<String, String>> data = new ArrayList<LinkedHashMap<String, String>>();

		int totalRows = sheet.getPhysicalNumberOfRows();
		for (int i = 0; i < totalRows; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell cell = row.getCell(0);

			if (cell.getStringCellValue().equalsIgnoreCase(scenarioName)) {
				data.add(getRowDataHM(filePath, workBookName, sheetName, i));
				break;
			}
		}
		book.close();
		return data;
	}

}
