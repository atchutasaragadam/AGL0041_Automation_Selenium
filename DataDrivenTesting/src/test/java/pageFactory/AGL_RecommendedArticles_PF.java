package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.Log;

public class AGL_RecommendedArticles_PF {
	String sRecommendArticle;
	
	@FindBy(how=How.CSS, using="#main > section.l-recommended-article > div > header > h2")
	public WebElement  LOC_TXTAREA_HDR_RECOMMENDEDARTICLE;
	
	
	@FindBy(how=How.CSS, using="#main > section.l-recommended-article > div")
	public WebElement LOC_TXTAREA_ARTICLES;

	public AGL_RecommendedArticles_PF(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void areArticlesHdrPresent(WebElement element) throws Exception{
		try {
			Thread.sleep(2000);
			sRecommendArticle = element.getText();
			if(element.isDisplayed()) {
				
				sRecommendArticle = element.getText();
				System.out.println("Element < " +sRecommendArticle+ " > is present");
				Log.info("Element < " +sRecommendArticle+ " > is present");
				
			}
			
		} catch(Exception e) {
			System.out.println("Element < " +sRecommendArticle+ " > is not present");
			Log.info("Element < " +sRecommendArticle+ " > is not present.");
			
			System.out.println("Error is : < " +e.getMessage()+ " >");
			Log.info("Error is : < " +e.getMessage()+ " >");
		}
	}
	
	
	public void verifyArticles_Execute() throws Exception {
		areArticlesHdrPresent(LOC_TXTAREA_HDR_RECOMMENDEDARTICLE);
		areArticlesHdrPresent(LOC_TXTAREA_ARTICLES);
	}
}
