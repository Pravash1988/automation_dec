package excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CellValueWithRow {
	int rownum;
	public List<String> getData(int rownum) throws IOException
	{File file=new File("D:\\Pravash\\MavenEX.xlsx");
	FileInputStream fis=new FileInputStream(file);
    XSSFWorkbook workbook=new XSSFWorkbook(fis);
    XSSFSheet sheet=workbook.getSheet("Sheet1");
//    rownum=sheet.getLastRowNum();
//    for(int i=0;i<rownum;i++) {
  	Row row=sheet.getRow(rownum);
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
		List<String> list = new ArrayList<String>();
		if(type==CellType.STRING){
			list.add(cell.getStringCellValue());
		}
		else if(type==CellType.NUMERIC){
			list.add(cell.getNumericCellValue());
		}
		else {
			list.add(cell.getBooleanCellValue())
			//System.out.print(cell.getBooleanCellValue());
		}
	for(String s:list) {
		System.out.println(s);
	}
		
		return list;
	
		
    }
	return null;}
	
	

	public static void main(String[] args) throws IOException {
    CellValueWithRow cvr=new CellValueWithRow();
    cvr.getData(2);
	}

}
