package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.Log;

public class AGL_SideNavigation_PF {
	
	String sSideNav;

	@FindBy(how = How.CLASS_NAME, using="btn-toggle-quoteform")
	public WebElement  LOC_BTN_SPEAKTOEXPERT;
	
	@FindBy(how = How.CLASS_NAME, using="btn-location")
	public WebElement  LOC_BTN_LOCATION;
	
	@FindBy(how = How.CLASS_NAME, using="btn-to-top")
	public WebElement  LOC_BTN_TOTOP;
	
	public AGL_SideNavigation_PF(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void isSideNavigationElementPresent(WebElement element) {
		try {
			Thread.sleep(2000);
		if(element.isDisplayed())	{
		
			sSideNav = element.getText();
		System.out.println("Global Footer element < "+sSideNav+ " > is present ");
		Log.info("Global Footer < "+sSideNav+ " > is present ");
		}
		}catch(Exception e) {
			System.out.println("Global Footer < "+sSideNav+ " > is present ");
			Log.info("Global Footer < "+sSideNav+ " > is present ");
		}
	}
	
	public void verifySideNavigation_Execute() throws Exception {
		isSideNavigationElementPresent(LOC_BTN_SPEAKTOEXPERT);
		isSideNavigationElementPresent(LOC_BTN_LOCATION);
		isSideNavigationElementPresent(LOC_BTN_LOCATION);
		
	}
}
