package PageObject_Component;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_Cart {
	
	
	public AppiumDriver driver;	
	
	@FindBy(id="com.bigbasket.mobileapp:id/action_search")
	public WebElement Search_btn;	
	
	@FindBy(id="com.bigbasket.mobileapp:id/searchView")
	public WebElement Searchview_txtbox;
	
	
	@FindBy(id="com.bigbasket.mobileapp:id/imgAddToBasket")
	public WebElement Add_btn;
		
	@FindBy(id="com.bigbasket.mobileapp:id/btnViewBasket")
	public WebElement CartView_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductDesc")
	public WebElement Addcart_msg;
	
	@FindBy(id="com.bigbasket.mobileapp:id/imgRemove")
	public WebElement DeleteCart_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement DeleteCart_msg;
	
		
	public PageObject_Cart(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void Click_btn()
	{
		Search_btn.click();
	}
	
	
	public void Enter_Search(String Value)
	{
		Searchview_txtbox.sendKeys(Value +"\n");
		
	}
	
	
	public void Click_Addbtn()
	{
		Add_btn.click();
	}
	
	
	public void Click_Viewcartbtn()
	{
		CartView_btn.click();
	}
	
	
	public String getAddcartmsg()
	{
		return Addcart_msg.getText();
		
	}
	
	public void Click_Deletebtn()
	{
		DeleteCart_btn.click();
	}
	
	public String getDeleteCartmsg()
	{
		return DeleteCart_msg.getText();
		
	}


}
