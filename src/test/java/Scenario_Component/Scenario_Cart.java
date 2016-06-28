package Scenario_Component;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Cart;

public class Scenario_Cart extends Base_Class {
	
	static Logger log=Logger.getLogger(Scenario_Cart.class);
	
	SoftAssert sAssert= new SoftAssert();
	
	@Test(dataProvider="dp_AddCart",dataProviderClass=DataProvider_Component.DataProvider_Cart.class)
	public void testAddCart(String TC_ID, String Order, String Search_Item, String Quantity,String Exp_Result) throws IOException, InterruptedException
	{
		log.info("Executing the Test case " +TC_ID+ "  Order is "+Order);
		Start_Server();
		Init_App();
		
		PageObject_Cart BC_Pob= new PageObject_Cart(driver);
		
		Explicit_wait(BC_Pob.Search_btn, 25);
		BC_Pob.Click_btn();
		
		Explicit_wait(BC_Pob.Searchview_txtbox, 25);
		BC_Pob.Enter_Search(Search_Item);
		
		Explicit_wait(BC_Pob.Add_btn, 25);
		BC_Pob.Click_Addbtn();
		
		Explicit_wait(BC_Pob.CartView_btn, 25);
		BC_Pob.Click_Viewcartbtn();
		
		Explicit_wait(BC_Pob.Addcart_msg, 25);
		String Actual_Result = BC_Pob.getAddcartmsg();
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is  " +Actual_Result+ "  and Expected Reult is " + Exp_Result);
			Snapshot_screen(TC_ID, Order);
		}
		else
		{
			log.info("Failed as Actual Result is  " +Actual_Result+ "  and Expected Reult is " + Exp_Result);
			Snapshot_screen(TC_ID, Order);
		}
		
		sAssert.assertAll();
		Stop_Server();
		
		
		
	}
	
	
	//Delete cart

	@Test(dataProvider="dp_Delete_Cart",dataProviderClass=DataProvider_Component.DataProvider_Cart.class)
	public void testDeleteCart(String TC_ID, String Order, String Search_Item, String Quantity,String Exp_Result) throws IOException, InterruptedException
	{
		log.info("Executing the Test case " +TC_ID+ "  Order is "+Order);
		Start_Server();
		Init_App();
		
		PageObject_Cart BC_Pob= new PageObject_Cart(driver);
		
		Explicit_wait(BC_Pob.Search_btn, 25);
		BC_Pob.Click_btn();
		
		Explicit_wait(BC_Pob.Searchview_txtbox, 25);
		BC_Pob.Enter_Search(Search_Item);
		
		Explicit_wait(BC_Pob.Add_btn, 25);
		BC_Pob.Click_Addbtn();
		
		Explicit_wait(BC_Pob.CartView_btn, 25);
		BC_Pob.Click_Viewcartbtn();
		
		Explicit_wait(BC_Pob.DeleteCart_btn, 25);
		BC_Pob.Click_Deletebtn();
		
		Explicit_wait(BC_Pob.DeleteCart_msg, 25);
		String Actual_Result = BC_Pob.getDeleteCartmsg();
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is  " +Actual_Result+ "  and Expected Reult is " + Exp_Result);
			Snapshot_screen(TC_ID, Order);
		}
		else
		{
			log.info("Failed as Actual Result is  " +Actual_Result+ "  and Expected Reult is " + Exp_Result);
			Snapshot_screen(TC_ID, Order);
		}
		
		sAssert.assertAll();
		Stop_Server();
		
		
		
	}
	
	

}
