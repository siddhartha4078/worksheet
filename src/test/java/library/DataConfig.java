package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class DataConfig {
	HSSFWorkbook wb;
	HSSFSheet sh;

	public DataConfig(String Excelpath) {

		try {

			File scr = new File(Excelpath);

			FileInputStream fis = new FileInputStream(scr);

			wb = new HSSFWorkbook(fis);

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public String getData(int Sheetnumber, int row, int column) throws IOException {

		sh = wb.getSheetAt(Sheetnumber);

		String Record1 = sh.getRow(row).getCell(column).getStringCellValue();
		return Record1;
	}

	public int getrow(int sheetindex) {

		int row = wb.getSheetAt(sheetindex).getLastRowNum();

		row = row + 1;
		return row;

	}

	public void writedata(int Sheetnumber,int row, int column, double value) throws IOException {

		try {
			
			sh = wb.getSheetAt(Sheetnumber);
			sh.getRow(row).createCell(column).setCellValue(value);

			FileOutputStream fout = new FileOutputStream(
					new File("C:\\Users\\Siddhartha\\Desktop\\Performance testing1.xls"));
			wb.write(fout);
			
			 fout.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
