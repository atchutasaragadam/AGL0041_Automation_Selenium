package pageFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.Log;

public class FindAllLinks_PF {
	
	@FindBy(how=How.TAG_NAME, using="a")
	public List<WebElement>  LOC_LINK_TOTALLINKS;
	
	boolean bIsValid = false;	
	public FindAllLinks_PF(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public void getLinksResponse_Execute() throws Exception {
		try {
			for(int i=0; i< LOC_LINK_TOTALLINKS.size(); i++){
				String url = LOC_LINK_TOTALLINKS.get(i).getAttribute("href");
				
				if(url!= null) {
					bIsValid=getResponseCode(url);
					
					if(bIsValid) {
						System.out.println("Response Status is < OK > ");
						Log.info("Response Status is < OK > ");
						
						System.out.println("Valid link: <<  " +url+ "  >>");
						Log.info("Valid link: <<  " +url+ "  >>");
						System.out.println("----------XXXX-----------XXXX----------XXXX-----------XXXX----------");
						Log.info("----------XXXX-----------XXXX----------XXXX-----------XXXX----------");
					    System.out.println();
						
					} else {
						System.out.println("Broken link: <<  " +url+ "  >>");
						Log.info("Broken link: <<  " +url+ "  >>");
						System.out.println("----------XXXX-----------XXXX----------XXXX-----------XXXX----------");
						Log.info("----------XXXX-----------XXXX----------XXXX-----------XXXX----------");
					    System.out.println();
					}
				} else {
					System.out.println("String null: <<  " +url+ "  >>");
					Log.info("String null: <<  " +url+ "  >>");
					System.out.println("----------XXXX-----------XXXX----------XXXX-----------XXXX----------");
					Log.info("----------XXXX-----------XXXX----------XXXX-----------XXXX----------");
				    System.out.println();
				    continue;
				}
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			Log.info(e.getMessage());
		}
	}
	
	public static boolean getResponseCode(String sCheckUrl) {
		boolean bValidResponse = false;
		try {
			//HttpResponse urlResp = new DefaultHttpClient().execute(new HttpGet(sCheckUrl));
			URL u = new URL(sCheckUrl);
            HttpURLConnection httpCon = (HttpURLConnection) u.openConnection();
            httpCon.setRequestMethod("GET");
            httpCon.setConnectTimeout(5000);
            
            httpCon.connect();
            String sResp_Status = httpCon.getResponseMessage();
			int iResp_Code = httpCon.getResponseCode();
						
			System.out.println("Response Code is : [ " +iResp_Code+ " ]");
			System.out.println("Response Status is : [ " +sResp_Status+ " ]");
			Log.info("Response Code is : [ " +iResp_Code+ " ]");
			Log.info("Response Status is : [ " +sResp_Status+ " ]");
			if((iResp_Code==404) || (iResp_Code==505)) {
				bValidResponse=false;
			} else {
				bValidResponse=true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Log.info(e.getMessage());
		}
		return bValidResponse;
		
	}

}
