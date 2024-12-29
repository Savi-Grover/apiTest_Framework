package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.core.format.DataFormatDetector;

public class XLUtility {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	//constructor to pass path of excel file
	public XLUtility(String path) {
		this.path=path;
	}
	
	//get rowcount from excel sheet
	public int getRowCount(String sheetName) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowCount;
	}
	
	   //get getCellCount from excel sheet
		public int getCellCount(String sheetName, int rownum) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		int cellCount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellCount;
		}
		
		//get getCellData from excel sheet
		public String getCellData(String sheetName, int rownum, int column) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(column);
		
		DataFormatter abc= new DataFormatter();
		String data;
		
		try {
			data= abc.formatCellValue(cell);
		}
		catch(Exception e) {
			data="";
		}
		workbook.close();
		fi.close();
		return data;
		
		}
		
		//set getCellData from excel sheet
		public String setCellData(String sheetName, int rownum, int column, String data) throws IOException 
		{
		File xlfile=new File(path);
		if(!xlfile.exists()) 
		{
			
			workbook=new XSSFWorkbook();
			fo=new FileOutputStream(path);
			workbook.write(fo);
			
		}
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		
		if(workbook.getSheetIndex(sheetName)==-1)
			workbook.createSheet(sheetName);
		sheet=workbook.getSheet(sheetName);
		
		if(sheet.getRow(rownum)==null)
			sheet.createRow(rownum);
		row=sheet.getRow(rownum);
		
			
		workbook.close();
		fi.close();
		return data;
				
				}
}
