package testCases;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utility.Constant;
import utility.Log;


public class SuperClass {

	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest(alwaysRun=true)
	public void browserExecute(String browser) throws Exception{
		try {
			
		
		DOMConfigurator.configure("log4j.xml");
		
		
		if(browser.equalsIgnoreCase("mac os EI Capitan-firefox")){
					
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile myprofile = profile.getProfile("Atchuta");
			driver = new FirefoxDriver(myprofile);
			//driver = new FirefoxDriver();
			Log.info("New Firefox driver instantiated");
			System.out.println("New firefox driver instantiated");
			
		} else if(browser.equalsIgnoreCase("mac os EI Capitan-chrome")) {
			driver = new ChromeDriver();
			Log.info("New Chrome driver instantiated");
			System.out.println("New Chrome driver instantiated");
			
		} else if(browser.equalsIgnoreCase("mac os EI Capitan-safari")) {
			SafariOptions options = new SafariOptions();
			options.setUseCleanSession(true);
			DesiredCapabilities capabilities = DesiredCapabilities.safari();
			capabilities.setCapability(SafariOptions.CAPABILITY, options);
			
			driver = new SafariDriver(capabilities);
			//Actions builder = new Actions(driver);
			Log.info("New safari driver instantiated");
			System.out.println("New safari driver instantiated");
		} if(browser.equalsIgnoreCase("win10-firefox")){
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			capabilities.setCapability("browser", "Firefox");
			capabilities.setCapability("browser_version", "46.0");
			capabilities.setCapability("os", "Windows");
			capabilities.setCapability("os_version", "10");
			capabilities.setCapability("resolution", "1024x768");
			driver = new RemoteWebDriver(new URL("https://cheproximity:j3Hepy4RMEvPez9bNKhP@hub-cloud.browserstack.com/wd/hub"),capabilities);
		Log.info("New Firefox driver instantiated via browser stack");
		System.out.println("New firefox driver instantiated via browser stack");
		
	} else if(browser.equalsIgnoreCase("win10-chrome")) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browser", "Chrome");
		capabilities.setCapability("browser_version", "51.0");
		capabilities.setCapability("os", "Windows");
		capabilities.setCapability("os_version", "10");
		capabilities.setCapability("resolution", "1024x768");
		Log.info("New Chrome driver instantiated via browser stack");
		System.out.println("New Chrome driver instantiated via browser stack");
		driver = new RemoteWebDriver(new URL("https://cheproximity:j3Hepy4RMEvPez9bNKhP@hub-cloud.browserstack.com/wd/hub"),capabilities);
		
	} else if(browser.equalsIgnoreCase("win10-ie")) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browser", "Edge");
		capabilities.setCapability("browser_version", "13.0");
		capabilities.setCapability("os", "Windows");
		capabilities.setCapability("os_version", "10");
		capabilities.setCapability("resolution", "1024x768");
		Log.info("New IE Edge driver instantiated via browser stack");
		System.out.println("New IE Edge driver instantiated via browser stack");
		driver = new RemoteWebDriver(new URL("https://cheproximity:j3Hepy4RMEvPez9bNKhP@hub-cloud.browserstack.com/wd/hub"),capabilities);
	}
		
		driver.get(Constant.URL);
		Log.info("navigated to " +Constant.URL);
		System.out.println("navigated to " +Constant.URL);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}catch (Exception e) {
			System.out.println("Class : SuperClass || Method : browserExecute || Description : "+e.getMessage());
			Log.error("Error in Class : SuperClass || Method : browserExecute");
		}
	}
	
	public static void getScreenshot(WebDriver driver, String sTestCaseID) throws Exception {
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Constant.ScreenshotPath+"/screenshot"+ sTestCaseID+".png"));
		} catch(Exception e){
			Log.error("Class : SuperClass || Method: getScreenshot || Desciption: " +e.getMessage());
			throw new Exception();
		}
		
		
	}
	@AfterTest
	//@AfterMethod
	public void quitBrowser() throws Exception {
		Thread.sleep(10000);
		driver.quit();
	}
}
