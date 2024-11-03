package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProidersClass {
	
	@DataProvider(name="LoginDataProvider")
	public String[][] provideLoginData() throws IOException
	{
		String path =System.getProperty("user.dir")+"//TestData//LoginData.xlsx";
		
		ExcelUtility excel = new ExcelUtility(path);
		
		int totalRows=excel.getRowCount("Login");
		int totalColumns=excel.getCellCount("Login",1);
		
		String login [] [] = new String [totalRows] [totalColumns];
		
		for(int row=0;row<totalRows;row++)
		{
			for(int col=0;col<totalColumns;col++)
			{
				login [row] [col] = excel.getCellData("Login", row+1, col);
			}
		}
		
		return login;
	}

}
