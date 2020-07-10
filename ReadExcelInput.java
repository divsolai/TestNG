package util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelInput {

	public static String[][] readExceldata(String ExcelFileName) throws IOException {
		// TODO Auto-generated method stub

XSSFWorkbook book = new XSSFWorkbook("./data/"+ExcelFileName+".xlsx");
XSSFSheet sheet = book.getSheetAt(0);
int rowcount = sheet.getLastRowNum();
System.out.println(rowcount);
XSSFRow header = sheet.getRow(0);
short colCount = header.getLastCellNum();

String [][] array= new String[rowcount][colCount];

	for(int i=1;i<=rowcount;i++)
	{
		XSSFRow row = sheet.getRow(i);
		for(int j=0;j<colCount;j++)
		{
			XSSFCell cell = row.getCell(j);
			String data = cell.getStringCellValue();
			array[i-1][j]=data;
			System.out.println(data);
		}
	}

book.close();
return array;


	}

}

