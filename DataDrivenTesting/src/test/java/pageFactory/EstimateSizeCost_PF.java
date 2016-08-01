package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testCases.SuperClass;
import utility.Log;

public class EstimateSizeCost_PF extends SuperClass{
	
	public WebDriverWait wait;
	
	@FindBy(how=How.CLASS_NAME, using="btn-scrollto")
	public WebElement  LOC_BTN_SCROLLTO;

	@FindBy(how=How.NAME, using="homeType")
	public WebElement  LOC_DRPDWN_HOMETYPE;
	
	@FindBy(how=How.CSS, using=".error-message.error-message-home-type-2.is-visible")
	public WebElement  LOC_TXTAREA_HOMETYPE_ERRMSG;
	
	@FindBy(how=How.NAME, using="state")
	public WebElement  LOC_DRPDWN_STATE;
	
	@FindBy(how=How.CSS, using=".error-message.error-message-state.is-visible")
	public WebElement  LOC_TXTAREA_STATE_ERRMSG;
	
	@FindBy(how=How.NAME, using="region")
	public WebElement LOC_DRPDWN_REGION;
	
	@FindBy(how=How.NAME, using="noOfPeople")
	public WebElement  LOC_DRPDWN_NUMOFPEOPLE;
	
	@FindBy(how=How.NAME, using="energyUse")
	public WebElement  LOC_DRPDWN_ENERGYUSE;
	
	@FindBy(how=How.NAME, using="Estimate")
	public WebElement LOC_BTN_ESTSIZECOST;
	
	public EstimateSizeCost_PF(WebDriver driver){
		//super();
		PageFactory.initElements(driver, this);
	}

	public void selectByText(WebElement element, String elementValue){
		Select sel = new Select(element);
		sel.selectByVisibleText(elementValue);
	}
	
	public void waitForElementVisibility(WebElement element) {
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
	}
	public void clickBtnScrollTo() throws Exception {
		Thread.sleep(1000);
		LOC_BTN_SCROLLTO.click();
		Log.info("Clicked on 'Scroll to Estimate Size Cost' button ");
		System.out.println("Clicked on 'Scroll to Estimate Size Cost' button ");
	}
	
	public void estSizeCost_Execute(String str_homeType, String str_state, String str_region, String str_noOfPeople, String str_EnergyUse) throws Exception {
	
		//waitForElementVisibility(we_homeType);
		if(str_homeType.contains("apartment")){
			Thread.sleep(1000);
			selectByText(LOC_DRPDWN_HOMETYPE, str_homeType);
			Log.info("Selected value for Home Type is  " +str_homeType);
			System.out.println("Selected value for Home Type is  " +str_homeType);
			
			String str_Expected_homeTypeErrMsg = "Did you know, you need building approval to get solar on an apartment. For more information, speak to one of our experts 1300 377 118.";
				
			//waitForElementVisibility(we_homeType_ErrMsg);
			Thread.sleep(1000);
			String str_Actual_homeTypeErrMsg = LOC_TXTAREA_HOMETYPE_ERRMSG.getText();
			System.out.println(" str_Actual_homeTypeErrMsg : " +str_Actual_homeTypeErrMsg);
			 if(str_Expected_homeTypeErrMsg.equals(str_Actual_homeTypeErrMsg)) {
				 Log.info("Selected Home Type value is " +str_homeType+ " and the message on the screen is < " +str_Actual_homeTypeErrMsg+ " >");
				 System.out.println("Selected Home Type value is " +str_homeType+ " and the message on the screen is < " +str_Actual_homeTypeErrMsg+ " >");
			 } else {
				 Log.info("Selected Home Type value is " +str_homeType);
				 Log.info(" The actual message on the screen is < " +str_Actual_homeTypeErrMsg+ " >");
				 Log.info("The expected message on the screen is < " +str_Expected_homeTypeErrMsg+ " >");
				
				 System.out.println("Selected Home Type value is " +str_homeType);
				 System.out.println(" The actual message on the screen is < " +str_Actual_homeTypeErrMsg+ " >");
				 System.out.println("The expected message on the screen is < " +str_Expected_homeTypeErrMsg+ " >");
			 }
			
		} else {
		
		//	waitForElementVisibility(we_homeType);
			Thread.sleep(1000);
			selectByText(LOC_DRPDWN_HOMETYPE, str_homeType);
			Log.info("Selected Home Type value is " +str_homeType);
			System.out.println("Selected Home Type value is " +str_homeType);
			
			if(str_state.contains("ACT") || str_state.contains("TAS")  || str_state.contains("NT")  || str_state.contains("WA") ) {
			
				//waitForElementVisibility(we_state);
				Thread.sleep(1000);
				selectByText(LOC_DRPDWN_STATE, str_state);
				Log.info("Selected State value is " +str_state);
				System.out.println("Selected State value is " +str_state);
				
				String str_Expected_state_ErrMsg="We’re sorry, we currently don’t service your state or territory. Please call 1300 377 118 to find out more.";
				
				//waitForElementVisibility(we_state_ErrMsg);
				Thread.sleep(1000);
				String str_Actual_State_ErrMsg = LOC_TXTAREA_STATE_ERRMSG.getText();
				 if(str_Expected_state_ErrMsg.equals(str_Actual_State_ErrMsg)) {
					 Log.info("Selected state value is " +str_homeType+ " and the message on the screen is < " +str_Actual_State_ErrMsg+ " >");
					 System.out.println("Selected state value is " +str_homeType+ " and the message on the screen is < " +str_Expected_state_ErrMsg+ " >");	
					 
				 } else {
					 Log.info("Selected State value is " +str_state);
					 Log.info(" The actual message on the screen is < " +str_Actual_State_ErrMsg+ " >");
					 Log.info("The expected message on the screen is < " +str_Expected_state_ErrMsg+ " >");
					
					 System.out.println("Selected State value is " +str_state);
					 System.out.println(" The actual message on the screen is < " +str_Actual_State_ErrMsg+ " >");
					 System.out.println("The expected message on the screen is < " +str_Expected_state_ErrMsg+ " >");
				 }
			} else {
			
				//waitForElementVisibility(we_state);
				Thread.sleep(1000);
				selectByText(LOC_DRPDWN_STATE, str_state);
				Log.info("Selected value for State is " +str_state);
				System.out.println("Selected State is " +str_state);
				
				//waitForElementVisibility(we_region);
				Thread.sleep(1000);
				
				selectByText(LOC_DRPDWN_REGION, str_region);
				Log.info("Selected value for Region is " +str_region);
				System.out.println("Selected value for Region  is " +str_region);
				
				//waitForElementVisibility(we_noOfPeople);
				Thread.sleep(1000);
				selectByText(LOC_DRPDWN_NUMOFPEOPLE, str_noOfPeople);
				Log.info("Selected value for 'number of people' is " +str_noOfPeople);
				System.out.println("Selected value for 'number of people' is " +str_noOfPeople);
				
				//waitForElementVisibility(we_energyUse);
				Thread.sleep(1000);
				selectByText(LOC_DRPDWN_ENERGYUSE, str_EnergyUse);
				Log.info("Selected value for 'Energy use' is " +str_EnergyUse);
				System.out.println("Selected value for 'Energy use' is " +str_EnergyUse);
				
			}
		}
	}
	
	public void clickBtnEstimate() throws Exception {
		
		//waitForElementVisibility(we_btn_EstSizeCost);
		Thread.sleep(1000);
		LOC_BTN_ESTSIZECOST.click();
			Thread.sleep(1000);
			Log.info("Clicked on 'Estimate Size Cost' button ");
			System.out.println("Clicked on 'Estimate Size Cost' button ");
		
	}
}


