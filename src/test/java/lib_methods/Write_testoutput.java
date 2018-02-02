package lib_methods;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import jxl.Workbook;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Write_testoutput {

	public void write(String ExcelSheetPath, String sheetname, int sheetno, int row, int column, String data, int d) {
		try {

			File exlFile = new File(ExcelSheetPath);
			WritableWorkbook writableWorkbook = Workbook.createWorkbook(exlFile);

			WritableSheet writableSheet = writableWorkbook.createSheet(sheetname, sheetno);

			String c = String.valueOf(d);

			Label label = new Label(column, row, data);
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

}
