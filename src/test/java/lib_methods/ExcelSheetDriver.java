package lib_methods;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelSheetDriver {

	static Sheet wrksheet;
	static Workbook wrkbook = null;
	public String ExcelSheetPath;
	public String sheetname;
	private String excelpath = "E:\\Siddhartha\\Projects\\Automation-neon\\com.worksheet\\src\\test\\resources\\TestData\\Performance_testdata.xls";
	private String excelpath1 = "E:\\Siddhartha\\Projects\\Automation-neon\\com.worksheet\\src\\test\\resources\\TestData\\Performance_testdataout.xls";


	public ExcelSheetDriver(String ExcelSheetPath, String sheetname) throws BiffException, IOException {

		wrkbook = Workbook.getWorkbook(new File(ExcelSheetPath));
		wrksheet = wrkbook.getSheet(sheetname);
	}

	public static int RowCount() {
		return wrksheet.getRows();
	}

	public static String ReadCell(int column, int row) {
		return wrksheet.getCell(column, row).getContents();
	}

	public void write(String ExcelSheetPath, String sheetname,int sheetno, int row, int column, String data, int d) {
		try {
			
			
			File exlFile = new File(ExcelSheetPath);
			WritableWorkbook writableWorkbook = Workbook.createWorkbook(exlFile);

			WritableSheet writableSheet = writableWorkbook.createSheet(sheetname, sheetno);

			String c = String.valueOf(d);

			Label label = new Label(column, row,data);
			Label label2 = new Label(column + 1, row, c);
			DateTime date = new DateTime(column + 2, row, new Date());

		
			writableSheet.addCell(label);
			writableSheet.addCell(label2);
			writableSheet.addCell(date);

		
			writableWorkbook.write();
			System.out.println("Data written succesfully");
			writableWorkbook.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}

	}

	public void write_result_copy() throws BiffException, IOException {

		try {

			File inputFile = new File(excelpath);
			File outputFile = new File(excelpath1);
			Workbook readCopy = Workbook.getWorkbook(inputFile);

			WritableWorkbook writeCopy = Workbook.createWorkbook(outputFile,readCopy);

			WritableSheet writableSheet = writeCopy.createSheet("Sheet1",1);

			String c1 = String.valueOf("");

			Label label = new Label(0, 2, c1);

			writableSheet.addCell(label);

			writeCopy.write();
			System.out.println("Data written succesfully");
			writeCopy.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}


}
