package excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FullExcelRead {

	public static void main(String[] args) throws IOException {
		File file=new File("D:\\Pravash\\MavenEX.xlsx");
		FileInputStream fis=new FileInputStream(file);
	    XSSFWorkbook workbook=new XSSFWorkbook(fis);
	    XSSFSheet sheet=workbook.getSheet("Sheet1");
        int rownum=sheet.getLastRowNum();
        for(int i=0;i<rownum;i++) {
        	Row row=sheet.getRow(i);
        int colno=row.getLastCellNum();
        for(int j=0;j<colno;j++) {
        	Cell cell=row.getCell(j);
        	CellType type=cell.getCellType();
        		if(type==CellType.STRING){
        		System.out.println(cell.getStringCellValue());	
        		
        		//System.out.print(cell.getStringCellValue());	
        		}
        		else if(type==CellType.NUMERIC){
        			System.out.println(cell.getNumericCellValue());
        			//System.out.print(cell.getNumericCellValue());
        		}
        		else {
        			System.out.println(cell.getBooleanCellValue());
        			//System.out.print(cell.getBooleanCellValue());
        		}
        	
       }
       // System.out.println();
        }
	}

}
