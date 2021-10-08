package utils;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils
{
	// static String excelPath = "./data/data.xlsx";
	static XSSFWorkbook work;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName)
	{
		if(excelPath.isEmpty())
		{
			excelPath = "./data/data.xlsx";
		}
			
		try
		{
			work = new XSSFWorkbook(excelPath);
			sheet = work.getSheet(sheetName);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());

		}
	}
	
	public static void GetRowCount()
	{
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("No of rows " + rowCount);
	}

	public static void GetCellData(int rowNum, int colNum)
	{
		//String value = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		DataFormatter format = new DataFormatter();
		Object value1 = format.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		
		//System.out.println("getStringCellValue= "+ value);
		System.out.println("formatCellValue = "+ value1);
	}

}
