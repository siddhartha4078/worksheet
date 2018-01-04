package library;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataxlconfig {
	public File f;
	public FileInputStream fis;
	public XSSFWorkbook wb;
	public XSSFSheet sh;

	public dataxlconfig(String filepath) {

		try {

			f = new File(filepath);
			fis = new FileInputStream(f);
			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}

	public String getdata(String name, int row, int column) {
		sh = wb.getSheet(name);
		String data = sh.getRow(row).getCell(column).getStringCellValue();
		return data;

	}

	public int rowcount(int index) {
		int row = wb.getSheetAt(index).getLastRowNum();
		row = row + 1;
		return row;

	}

}
