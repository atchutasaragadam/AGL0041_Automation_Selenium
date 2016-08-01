package pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testCases.SuperClass;
import utility.Log;

public class AGL_Header_PF extends SuperClass{

	String sHeader;
	List<WebElement> listOfElements;
	List<WebElement> listOfElements1;
	
	@FindBy(how=How.CSS,using="#menu-item-235>a")
	public List<WebElement>  LOC_MENU_LIST_UNDERSTANDINGSOLAR;

	@FindBy(how=How.CSS,using="#menu-item-235>a")
	public WebElement  LOC_MENU_UNDERSTANDINGSOLAR;
	
	
	@FindBy(how=How.ID, using="menu-item-236")
	public List<WebElement>  LOC_MENU_LIST_SWITCHSOLAR;
	
	@FindBy(how=How.ID, using="menu-item-236")
	public WebElement  LOC_MENU_SWITCHSOLAR;
	
	@FindBy(how=How.ID, using="menu-item-237")
	public List<WebElement>  LOC_MENU_LIST_SOLARWITHAGL;
	
	@FindBy(how=How.ID, using="menu-item-237")
	public WebElement  LOC_MENU_SOLARWITHAGL;
	
	@FindBy(how=How.ID, using="menu-item-237")
	public List<WebElement>  LOC_MENU_LIST_SOLARMONITORING;
	
	@FindBy(how=How.ID, using="menu-item-2604")
	public WebElement LOC_MENU_SOLARMONITORING;
	
	@FindBy(how=How.CLASS_NAME, using="tel")
	public List<WebElement>  LOC_MENU_LIST_TELPH;
	
	@FindBy(how=How.CLASS_NAME, using="tel")
	public WebElement  LOC_MENU_TELPH;
	
	
	public AGL_Header_PF(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void isHeaderElementPresent(WebElement element) {
		try {
			Thread.sleep(5000);
		if(element.isDisplayed())	{
		Thread.sleep(5000);
			sHeader = element.getText();
		System.out.println("Header element < "+sHeader+ " > is present ");
		Log.info("Header element < "+sHeader+ " > is present ");
		}
		}catch(Exception e) {
			System.out.println("Header element < "+sHeader+ " > is present ");
			Log.info("Header element < "+sHeader+ " > is present ");
		}
	}
	
	
	public void selectBy(WebElement element) {
		try {
		
//			if(driver.equals("safari")) {
//				String mouseOverScript = "var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false);"+"element.dispatchEvent(evObj);}else if(doucment.createEventObject) {element.fireEvent('onmouseover');}";
//               
//				            JavascriptExecutor js = (JavascriptExecutor) driver;
//				            js.executeScript(mouseOverScript, element);
//			} else {
//			Actions action = new Actions(driver);
//			//Thread.sleep(2000);
//			action.moveToElement(element).build().perform();
//			}
			Thread.sleep(5000);
			Actions action = new Actions(driver);
			Thread.sleep(5000);
			action.moveToElement(element).build().perform();
			System.out.println("List of elements in " +element.getText());
				
			
//			
						
			} catch (Exception e) {
			System.out.println("Class : AGL_Header_PF  || Method : selectBy || Description :" +e.getMessage());
			System.out.println("Class : AGL_Header_PF  || Method : selectBy || Description :" +e.getMessage());
		}
		
		
		
		
		
		
	}
	public void verifyHeader_Execute() throws Exception {
		Thread.sleep(5000);
		isHeaderElementPresent(LOC_MENU_UNDERSTANDINGSOLAR);
		isHeaderElementPresent(LOC_MENU_SWITCHSOLAR);
		isHeaderElementPresent(LOC_MENU_SOLARWITHAGL);
		isHeaderElementPresent(LOC_MENU_SOLARMONITORING);
		isHeaderElementPresent(LOC_MENU_TELPH);
		
	}

	public void getElementsFromHeaderDropdown() throws Exception {
		Thread.sleep(5000);
		selectBy(LOC_MENU_UNDERSTANDINGSOLAR);
		selectBy(LOC_MENU_SWITCHSOLAR);
		selectBy(LOC_MENU_SOLARWITHAGL);
		selectBy(LOC_MENU_SOLARMONITORING);
		selectBy(LOC_MENU_TELPH);
	}
	
}
