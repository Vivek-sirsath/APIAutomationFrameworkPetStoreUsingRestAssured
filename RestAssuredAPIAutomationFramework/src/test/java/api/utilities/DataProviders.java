package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "AllData")
	public String[][] AllDataProvider() {

		String fName = System.getProperty("user.dir") + "//testdata//UserAPIFrameworkData.xlsx";

		int ttlRowCount = ReadExcelFile.getRowCount(fName, "sheet1");
		int ttlColCount = ReadExcelFile.getColCount(fName, "sheet1");

		System.out.println("Total row count: " + ttlRowCount); // 4
		System.out.println("Total column count: " + ttlColCount); // 7

		// [ttlRowCount - 1] Because, we need to return data from 3 rows only not from all 4 rows
		String userData[][] = new String[ttlRowCount - 1][ttlColCount];		

		for (int rowNo = 1; rowNo < ttlRowCount; rowNo++) {

			for (int colNo = 0; colNo < ttlColCount; colNo++) {
				userData[rowNo - 1][colNo] = ReadExcelFile.getCellValue(fName, "sheet1", rowNo, colNo);
				// We subtract 1 because array index starts from 0.
			}
		}
		return userData;
	}
	
/*
	In above method, Why [ttlRowCount - 1] ?
	Because:
	Row 0 = header (ID, Username, FirstName, ...)
	Actual data starts from row 1

	So:
		new String[3][7]

	Meaning:
		3 test runs
		7 parameters each
*/


	@DataProvider(name = "userNameData")
	public String[] userNameDataProvider() {

		String fName = System.getProperty("user.dir") + "//testdata//UserAPIFrameworkData.xlsx";

		int ttlRowCount = ReadExcelFile.getRowCount(fName, "sheet1");

		// [ttlRowCount - 1] Because, we need to return data from 3 rows only not from all 4 rows
		String userName[] = new String[ttlRowCount - 1];

		// zero th row '0' (First Row) is for heading, hence start from '1' (Second Row)
		for (int rowNo = 1; rowNo < ttlRowCount; rowNo++) {

			userName[rowNo - 1] = ReadExcelFile.getCellValue(fName, "sheet1", rowNo, 1);
		}
		return userName;
	}
}
