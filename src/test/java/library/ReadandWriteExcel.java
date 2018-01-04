package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
 
 
public class ReadandWriteExcel {
	
	public void t(){
		
		 try {
			
			  File src=new File("E:\\Siddhartha\\Projects\\Automation-neon\\com.worksheet_admin\\src\\test\\resources\\dropdown_worksheets.xlsx");
		
			   FileInputStream fis=new FileInputStream(src);
			 
			   // Load workbook
			   XSSFWorkbook wb=new XSSFWorkbook(fis);
			   
			   // Load sheet- Here we are loading first sheetonly
			      XSSFSheet sh1= wb.getSheetAt(0);
		
			 
			 String data= sh1.getRow(0).getCell(0).getStringCellValue();
			 System.out.println(data);

			 
			  } catch (Exception e) {
			 
			   System.out.println(e.getMessage());
			 
			  }
			  
	}
 
 public static void main(String []args){
	 ReadandWriteExcel r = new  ReadandWriteExcel();
	 r.t();
 
 }
 
}