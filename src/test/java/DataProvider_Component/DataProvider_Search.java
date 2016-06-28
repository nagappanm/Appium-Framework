package DataProvider_Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_Component.ExcelReadWrite;

public class DataProvider_Search {
	
	
	@DataProvider(name="dp_InvalidSearch")
	public static Iterator<String[]> getInvalidSearchdata() throws IOException
	{
		
		List<String[]> Obj = flagRowCount("Invalid_Search");
		return Obj.iterator();
			
		
	}
	
	
	@DataProvider(name="dp_ValidSearch")
	public static Iterator<String[]> getValidsearchdata() throws IOException
	{
		List<String[]> Obj = flagRowCount("Valid_Search");
		return Obj.iterator();
	}
	
	
	//common method to add the data to string array and list
	
	public static List<String[]> flagRowCount(String scriptname) throws IOException
	{
		
		ExcelReadWrite xl= new ExcelReadWrite("D:\\Appium\\26-Jun-2016\\June_BB_Project\\Test_Data\\Test_Data.xls");
		HSSFSheet Search_Scenario = xl.Setsheet("Search_Scenario");
		
		int RowCount = xl.getrowcount(Search_Scenario);
		
		//create a list
		List<String[]> list_search= new ArrayList<String[]>();
		
		
		for(int xlRow=1;xlRow<=RowCount;xlRow++)
		{
			String Execute_Flag = xl.Readvalue(Search_Scenario, xlRow, "Execute_Flag");
			String Script_name = xl.Readvalue(Search_Scenario, xlRow, "Script_name");
			
			if((Execute_Flag.equals("Y"))&&(Script_name.equals(scriptname)))
			{
				String[] arr_search= new String[4];
				
				arr_search[0]=xl.Readvalue(Search_Scenario, xlRow, "TC_ID");
				arr_search[1]=xl.Readvalue(Search_Scenario, xlRow, "Order");
				arr_search[2]=xl.Readvalue(Search_Scenario, xlRow, "Search_Item");
				arr_search[3]=xl.Readvalue(Search_Scenario, xlRow, "Exp_Result");
				arr_search[3]=arr_search[3].replace(".0", "");
				//adding to list
				list_search.add(arr_search);
				
			}//end of if
			
		}//end of for loop
		
		return 	list_search;
		
		
	}

}
