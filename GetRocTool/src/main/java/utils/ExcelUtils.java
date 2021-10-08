package utils;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell; 
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils
{
	static String excelPath = "./data/data.xlsx";
	static XSSFWorkbook work;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName)
	{
		if(excelPath.isEmpty())
		{
			excelPath = ExcelUtils.excelPath;
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
	
	public static int GetRowCount()
	{
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("No of rows " + rowCount);
		return rowCount;
	}

	public static void GetCellData(int rowNum, int colNum)
	{
		//String value = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		DataFormatter format = new DataFormatter();
		Object value1 = format.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		
		//System.out.println("getStringCellValue= "+ value);
		System.out.println("formatCellValue = "+ value1);
	}
	
	public static List<String> ReadColumnValues(int columnIndex)
	{
		List<String> list = new ArrayList<String>();
		DataFormatter format = new DataFormatter();
		
		for (Row row : sheet) { // For each Row.
      //Cell cell = row.getCell(columnIndex); 
			Object value = format.formatCellValue(row.getCell(columnIndex));
      if(!value.toString().isEmpty())
      {
      	list.add(value.toString());
      }
		}
		return list;
	}
	
	public static Map<String, Integer> ReadColumnWithRowID(int columnIndex)
	{
		//Use LinkedHashmap to retain order of insertion (HashMap No ordering & No preservation of insertion order)
		Map<String, Integer> list = new LinkedHashMap<String, Integer>(); 
		//List<String> list = new ArrayList<String>();
		DataFormatter format = new DataFormatter();
		
		for (int i = 0; i < GetRowCount(); i++) {  
       
			Object key = format.formatCellValue(sheet.getRow(i).getCell(columnIndex));
			 
			list.put(key.toString(), i); 
		} 
		return list;
	}
	
 

}
