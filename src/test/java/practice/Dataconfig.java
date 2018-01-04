package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class Dataconfig {

	public File f;
	public FileInputStream fis;
	public HSSFWorkbook wb;
	public HSSFSheet sh;
	public DataFormatter format;

	public Dataconfig(String filepath) throws IOException {

		f = new File(filepath);
		fis = new FileInputStream(f);
		wb = new HSSFWorkbook(fis);
		format = new DataFormatter();
	}

	public int rowcount(int sheetindex) {

		int row = wb.getSheetAt(sheetindex).getLastRowNum();

		row = row + 1;

		return row;
	}

	public String getdata(int Stringindex, int row, int column) {

		sh = wb.getSheetAt(Stringindex);

		String data = sh.getRow(row).getCell(column).getStringCellValue();

		return data;
	}

}
