package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testCases.SuperClass;
import utility.Log;

public class AGLLogo_PF extends SuperClass{

	@FindBy(how=How.ID,using="logo")
	public WebElement  LOC_IMG_AGLLOGO;
	
	public AGLLogo_PF(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
	
	//verifies logo is present or not
	public void isLogoPresent() {
		try {
			Thread.sleep(2000);
			LOC_IMG_AGLLOGO.isDisplayed();
			if(LOC_IMG_AGLLOGO.isDisplayed()){
				System.out.println("AGL Logo is present");
				Log.info("AGL Logo is present");

			}else {
				System.out.println("AGL Logo is not present");
				Log.info("AGL Logo is not present");
			}
		} catch(Exception e) {
			
			System.out.println("Error encountered while executing  ");
			System.out.println("In Class: AGLLogo_PF || In Method : isLogoPresent || Description of error :  " +e);
			
			Log.info("Error encountered while executing n Class: AGLLogo_PF || In Method : isLogoPresent ");
			
		}
		
		
	}
	//get the src of the image (logo)
	public void getAttributeLogo_Execute() throws Exception {
		Thread.sleep(2000);
		String sSrclogo = LOC_IMG_AGLLOGO.getAttribute("src");
		System.out.println("Source of logo is + " +sSrclogo);
		Log.info("Source of logo is + " +sSrclogo);
	}
	
}
