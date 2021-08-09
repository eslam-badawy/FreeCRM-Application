package com.freecrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.freecrm.base.TestBase;


public class TestUtils extends TestBase{

	public TestUtils() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public static void takePicture(String name) throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File ("E:\\workspace\\PageObjectFreeCRM\\TestReport\\"+name+".png"));
                                              	
	}                                                                              
	
	
	public static Object[][] getdDataFromExcell(String SheetName) throws IOException {
		File file = new File("C:\\Users\\eslam\\OneDrive\\Desktop\\ContactPageData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(SheetName);
        int rows = sheet.getLastRowNum();
        int columns = sheet.getRow(0).getLastCellNum();
        Object data[][] = new Object[rows][columns];
        
        for (int i=0 ; i<rows ; i++)
        {
        	for(int j=0 ; j<columns ; j++)
        	{
        		data[i][j]=sheet.getRow(i).getCell(j).toString();
        	}
        	
        }
        workbook.close();
        return data;
        
        
	}


	 



	}

	
	
	
	


