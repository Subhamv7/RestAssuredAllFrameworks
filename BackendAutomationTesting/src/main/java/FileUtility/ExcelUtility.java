package FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	String file = "./Test-Data/Test-Script Data.xlsx";

	public String getDataFromExcel(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		wb.close();
		return data;

	}

	public int getRowCount(String SheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(SheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}

	public void setDataIntoExcel(String SheetName, int rowNum, int celNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		
		wb.getSheet(SheetName).getRow(rowNum).createCell(celNum).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		wb.close();

	}

}
