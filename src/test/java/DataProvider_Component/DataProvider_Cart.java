package DataProvider_Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_Component.ExcelReadWrite;

public class DataProvider_Cart {
	
	@DataProvider(name="dp_AddCart")
	public static Iterator<String[]> getAddCartdata() throws IOException
	{
		
		List<String[]> Obj = flagRowCount("Add_Cart");
		return Obj.iterator();
			
		
	}
	
	
	@DataProvider(name="dp_Delete_Cart")
	public static Iterator<String[]> getDelete_Cartdata() throws IOException
	{
		List<String[]> Obj = flagRowCount("Delete_Cart");
		return Obj.iterator();
	}
	
	
	//common method to add the data to string array and list
	
	public static List<String[]> flagRowCount(String scriptname) throws IOException
	{
		
		ExcelReadWrite xl= new ExcelReadWrite("D:\\Appium\\26-Jun-2016\\June_BB_Project\\Test_Data\\Test_Data.xls");
		HSSFSheet Scenario_Cart = xl.Setsheet("Scenario_Cart");
		
		int RowCount = xl.getrowcount(Scenario_Cart);
		
		//create a list
		List<String[]> list_cart= new ArrayList<String[]>();
		
		
		for(int xlRow=1;xlRow<=RowCount;xlRow++)
		{
			String Execute_Flag = xl.Readvalue(Scenario_Cart, xlRow, "Execute_Flag");
			String Script_name = xl.Readvalue(Scenario_Cart, xlRow, "Script_name");
			
			if((Execute_Flag.equals("Y"))&&(Script_name.equals(scriptname)))
			{
				String[] arr_cart= new String[5];
				
				arr_cart[0]=xl.Readvalue(Scenario_Cart, xlRow, "TC_ID");
				arr_cart[1]=xl.Readvalue(Scenario_Cart, xlRow, "Order");
				arr_cart[2]=xl.Readvalue(Scenario_Cart, xlRow, "Search_Item");
				arr_cart[3]=xl.Readvalue(Scenario_Cart, xlRow, "Quantity");
				arr_cart[4]=xl.Readvalue(Scenario_Cart, xlRow, "Exp_Result");
				
				//adding to list
				list_cart.add(arr_cart);
				
			}//end of if
			
		}//end of for loop
		
		return 	list_cart;
		
		
	}


}
