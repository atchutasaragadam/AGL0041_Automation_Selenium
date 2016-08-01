package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.Log;

public class AGL_GlobalFooter_PF {
	
	String sGlobalFoter;

	@FindBy(how=How.ID, using="menu-item-362")
	public WebElement LOC_LNK_LEGALNOTICES;
	
	@FindBy(how=How.ID, using="menu-item-363")
	public WebElement LOC_LNK_PRIVACY;
	
	@FindBy(how=How.ID, using="menu-item-368")
	public WebElement  LOC_LINK_CONTACTUS;
	
	@FindBy(how=How.ID, using="menu-item-3944")
	public WebElement  LOC_LNK_SITEMAP;
	
	@FindBy(how=How.CLASS_NAME,using="organisation")
	public WebElement  LOC_LNK_ORGAGL;
	
	public AGL_GlobalFooter_PF(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void isGlobalFooterElementPresent(WebElement element) {
		try {
			Thread.sleep(2000);
		if(element.isDisplayed())	{
		
			sGlobalFoter = element.getText();
		System.out.println("Global Footer element < "+sGlobalFoter+ " > is present ");
		Log.info("Global Footer < "+sGlobalFoter+ " > is present ");
		}
		}catch(Exception e) {
			System.out.println("Global Footer < "+sGlobalFoter+ " > is present ");
			Log.info("Global Footer < "+sGlobalFoter+ " > is present ");
		}
	}
	
	public void verifyGlobalFooter_Execute() throws Exception {
		isGlobalFooterElementPresent(LOC_LNK_LEGALNOTICES);
		isGlobalFooterElementPresent(LOC_LNK_PRIVACY);
		isGlobalFooterElementPresent(LOC_LINK_CONTACTUS);
		isGlobalFooterElementPresent(LOC_LNK_SITEMAP);
		isGlobalFooterElementPresent(LOC_LNK_ORGAGL);
		
	}
	
}
