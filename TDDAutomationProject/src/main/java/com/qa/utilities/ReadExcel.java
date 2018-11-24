package com.qa.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel
{
	private static FileInputStream fis;
	private static Object[][] data;
	
	public static Object[][] readData(String sheetIndex)
	{
		try
		{
			fis=new FileInputStream("//Users//rakeshrane//TDDAutomationFramework//TDDAutomationFramework//TDDAutomationProject//src//main//java//com//qa//testdata//data.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheet(sheetIndex);
			
			for(int i=0;i<sheet.getLastRowNum();i++)
			{
				for(int k=i;k<sheet.getRow(i).getLastCellNum();k++)
				{
					//DataFormatter format=new DataFormatter();
					data[i][k]=sheet.getRow(i+1).getCell(k).toString();
				}
			}			
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		} 
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		return data;	
	}

}
