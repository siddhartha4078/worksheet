package practice;

import java.io.IOException;

import org.testng.annotations.Test;

public class Testexceldata {

	private String path = "C:\\Users\\Siddhartha\\Desktop\\dataset.xls";

	@Test
	public void printdata() throws IOException {
		
	

		try {

			Dataconfig config = new Dataconfig(path);
			int rowcount = config.rowcount(0);

			System.out.println("Row count is " + rowcount);

			String data = config.getdata(0, 5, 0);
			System.out.println("data is " + data);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
