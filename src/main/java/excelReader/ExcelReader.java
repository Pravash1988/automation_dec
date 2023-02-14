package excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) throws IOException {
		File file=new File("D:\\Pravash\\MavenEX.xlsx");
		FileInputStream fis=new FileInputStream(file);
	    XSSFWorkbook workbook=new XSSFWorkbook(fis);
	    XSSFSheet sheet=workbook.getSheet("Sheet1");
	    Row row=sheet.getRow(1);
	    Cell cell=row.getCell(0);
	   // System.out.println(cell.getStringCellValue());
	    System.out.println(cell.getNumericCellValue());
		System.out.println(sheet.getLastRowNum());  //this will consider all rows i.e even empty rows, index starts from 0
		System.out.println(row.getLastCellNum());

		System.out.println(sheet.getPhysicalNumberOfRows());  //this will return only number of rows with actual data - index starts from 1
	
	    

	}

}
