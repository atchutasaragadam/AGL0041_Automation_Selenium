package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testCases.SuperClass;
import utility.Log;

public class AGL_PreHeader_PF extends SuperClass{

	String sPreHeader;
	
	@FindBy(how=How.ID,using="menu-item-28")
	public WebElement  LOC_LNK_PREHDR_RES;
	
	@FindBy(how=How.ID, using="menu-item-2130")
	public WebElement  LOC_LNK_PREHDR_COMM;
	
	public AGL_PreHeader_PF(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void isPreHeaderElementPresent(WebElement element) {
		
		try {
			Thread.sleep(2000);
		if(element.isDisplayed())	{
		
		sPreHeader = element.getText();
		System.out.println("Pre Header element < "+sPreHeader+ " > is present ");
		Log.info("Pre Header element < "+sPreHeader+ " > is present ");
		}
		}catch(Exception e) {
			System.out.println("Pre Header element < "+sPreHeader+ " > is present ");
			Log.info("Pre Header element < "+sPreHeader+ " > is present ");
		}
	}
	
	public void verifyPreHeader_Execute() throws Exception {
		isPreHeaderElementPresent(LOC_LNK_PREHDR_RES);
		isPreHeaderElementPresent(LOC_LNK_PREHDR_COMM);
	}
	
}
