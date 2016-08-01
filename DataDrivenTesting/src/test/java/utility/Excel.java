package utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	public static String getCellValue(String sExcelFile, String sSheetName, int iRowNum, int iColNum){
		try {
			FileInputStream fis = new FileInputStream(sExcelFile);
			Workbook workbook = WorkbookFactory.create(fis);
			Cell cell = workbook.getSheet(sSheetName).getRow(iRowNum).getCell(iColNum);
			return cell.getStringCellValue();
		} catch(Exception e) {
			return "";
		}		
	}
	
	public static int getRowCount(String sExcelFile, String sSheetName) {
		try {
			FileInputStream fis = new FileInputStream(sExcelFile);
			Workbook workbook = WorkbookFactory.create(fis);
			int iRowCount = workbook.getSheet(sSheetName).getLastRowNum();
			return iRowCount;
			
		} catch(Exception e) {
			return 0;
		}
	}
	
	
}
