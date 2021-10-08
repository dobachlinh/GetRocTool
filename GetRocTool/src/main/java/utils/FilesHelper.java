package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/*
Program Name: FilesHelper.java
	    Author: Linh Do
		    Date: Oct 7, 2021 11:44:18 AM
 Description: 
 */
public class FilesHelper
{
	/*
	 * Method Name: WriteToFile Purpose: write log to file Accepts: String filepath,
	 * String text, Boolean isAppend Returns: N/A
	 */
	public static void WriteToFile(String filepath, String text, Boolean isAppend)
	{
		try
		{
			Writer output;
			output = new BufferedWriter(new FileWriter(filepath, isAppend));
			output.append(text.trim());
			System.out.println(text.trim());
			output.append("\n");
			output.close();
			System.out.println("Successfully write to the file log. " + filepath);

		}
		catch (IOException e)
		{
			System.out.println("An error occurred in err_log_file");
			e.printStackTrace();
		}
	}

	public static List<String> ReadFileToList(String filePath)
	{
		List<String> list = new ArrayList<String>();
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(filePath));
			String str;
			while ((str = in.readLine()) != null)
			{
				list.add(str);
			}

			String[] stringArr = list.toArray(new String[0]);
		}
		catch (Exception e)
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return list;
	}

}
