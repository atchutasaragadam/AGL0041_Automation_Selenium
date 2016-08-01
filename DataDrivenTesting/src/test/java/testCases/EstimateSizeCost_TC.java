package testCases;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import pageFactory.AGLLogo_PF;
import pageFactory.AGL_GlobalFooter_PF;
import pageFactory.AGL_Header_PF;
import pageFactory.AGL_PreHeader_PF;
import pageFactory.AGL_RecommendedArticles_PF;
import pageFactory.AGL_SideNavigation_PF;
import pageFactory.EstimateSizeCost_PF;
import pageFactory.FindAllLinks_PF;
import utility.Constant;
import utility.Excel;
import utility.Log;

public class EstimateSizeCost_TC extends SuperClass {

	String TestCaseID;
	String methodName;

	@Test(description = "Verify logo on AGL", enabled = false)
	public void verifyAGLLogo(Method method) throws Exception {
              System.out.println("Can you run please.");
		try {

			methodName = method.getName();
			Log.startTestCase(methodName);
			AGLLogo_PF aglLogo_PF = new AGLLogo_PF(driver);
			aglLogo_PF.isLogoPresent();
		//	aglLogo_PF.getAttributeLogo_Execute();
			Log.endTestCase(methodName);

		} catch (Exception e) {
			getScreenshot(driver, methodName);
			Log.error(methodName);
		}

	}

	@Test(description = "Verify Pre Header", enabled = false)
	public void verifyAGLPreHeaders(Method method) throws Exception {
		try {
			methodName = method.getName();
			AGL_PreHeader_PF aglPreHdr_PF = new AGL_PreHeader_PF(driver);
			Log.startTestCase(methodName);
			aglPreHdr_PF.verifyPreHeader_Execute();
			Log.endTestCase(methodName);

		} catch (Exception e) {
			getScreenshot(driver, methodName);
			Log.error(methodName);
		}
	}

	@Test(description = "Verify Headers", enabled = true)
	public void verifyHeaders(Method method) throws Exception {
		try {
			methodName = method.getName();
			AGL_Header_PF aglHdr_PF = new AGL_Header_PF(driver);
			Log.startTestCase(methodName);
			aglHdr_PF.verifyHeader_Execute();
			aglHdr_PF.getElementsFromHeaderDropdown();
			Log.endTestCase(methodName);

		} catch (Exception e) {
			getScreenshot(driver, methodName);
			Log.error(methodName);
		}
	}

	@Test(description = "Verify Global Footer", enabled = false)
	public void verifyGlobalFooters(Method method) throws Exception {
		try {
			methodName = method.getName();
			AGL_GlobalFooter_PF agl_GblFtr_PF = new AGL_GlobalFooter_PF(driver);
			Log.startTestCase(methodName);
			agl_GblFtr_PF.verifyGlobalFooter_Execute();
			Log.endTestCase(methodName);
		} catch (Exception e) {
			getScreenshot(driver, methodName);
			Log.error(methodName);
		}
	}

	@Test(description = "Verify Side Navigation", enabled = false)
	public void verifySideNavigation(Method method) throws Exception {
		try {
			methodName = method.getName();
			AGL_SideNavigation_PF agl_sidenav_PF = new AGL_SideNavigation_PF(driver);
			Log.startTestCase(methodName);
			agl_sidenav_PF.verifySideNavigation_Execute();
			Log.endTestCase(methodName);
		} catch (Exception e) {
			getScreenshot(driver, methodName);
			Log.error(methodName);
		}
	}
	
	@Test(description = "Verify Recommended Articles", enabled = false)
	public void verifyRecommendedArticles(Method method) throws Exception {
		try {
			methodName = method.getName();
			AGL_RecommendedArticles_PF agl_recomArt_PF = new AGL_RecommendedArticles_PF(driver);
			Log.startTestCase(methodName);
			agl_recomArt_PF.verifyArticles_Execute();
			Log.endTestCase(methodName);
		} catch (Exception e) {
			getScreenshot(driver, methodName);
			Log.error(methodName);
		}
	}
	
	@Test(description = "verify all the links are directing to correct page , no broken links", enabled = false)
	public void verifyLinks(Method method) throws Exception{
		
		try {
			methodName = method.getName();
			FindAllLinks_PF findLinks_PF = new FindAllLinks_PF(driver);
			Log.startTestCase(methodName);
			findLinks_PF.getLinksResponse_Execute();
			Log.endTestCase(methodName);	
		} catch(Exception e) {
			getScreenshot(driver, methodName);
			Log.error(methodName);
		}
		
	}
	
	
	@Test(description = "Estimation os Size and Cost", enabled = false)
	public void verifyEstimateSizeCost(Method method) throws Exception {

		try {
			methodName = method.getName();
			EstimateSizeCost_PF estSizeCost_PF = new EstimateSizeCost_PF(driver);
			Log.startTestCase(methodName);
			estSizeCost_PF.clickBtnScrollTo();
			System.out.println("clicked on scrolled to estimate size and cost");

			// String str_ExcelFile = System.getProperty("user.dir")+
			// "/src/test/java/testData/TestData_DataDrivenTesting.xlsx";
			// String str_SheetName= "Sheet1";

			int i_RowCount = Excel.getRowCount(Constant.ExcelFilePath, Constant.SheeEstSizeCost);
			for (int i = 1; i <= i_RowCount; i++) {

				TestCaseID = Excel.getCellValue(Constant.ExcelFilePath, Constant.SheeEstSizeCost, i,
						Constant.Col_TestCaseID);
				String sRunMode = Excel.getCellValue(Constant.ExcelFilePath, Constant.SheeEstSizeCost, i,
						Constant.Col_RunMOde);
				if (sRunMode.equalsIgnoreCase("yes")) {

					Log.startTestCase(TestCaseID);
					System.out.println();
					System.out.println(
							"************            Test case number : " + TestCaseID + "            ************");
					System.out.println();
					String HomeType = Excel.getCellValue(Constant.ExcelFilePath, Constant.SheeEstSizeCost, i,
							Constant.Col_HomeType);
					String State = Excel.getCellValue(Constant.ExcelFilePath, Constant.SheeEstSizeCost, i,
							Constant.Col_State);
					String Region = Excel.getCellValue(Constant.ExcelFilePath, Constant.SheeEstSizeCost, i,
							Constant.Col_Region);
					String NoOfPeople = Excel.getCellValue(Constant.ExcelFilePath, Constant.SheeEstSizeCost, i,
							Constant.Col_NumOfPeople);
					String Energyuse = Excel.getCellValue(Constant.ExcelFilePath, Constant.SheeEstSizeCost, i,
							Constant.Col_EnergyUse);

					estSizeCost_PF.estSizeCost_Execute(HomeType, State, Region, NoOfPeople, Energyuse);
					if (!(HomeType.equals("apartment") || State.equals("ACT") || State.equals("NT")
							|| State.equals("TAS") || State.equals("WA"))) {
						Thread.sleep(1000);
						estSizeCost_PF.clickBtnEstimate();
						// System.out.println("Test case number : " +i+ " is
						// passed"
						// );
					}

					Log.endTestCase(TestCaseID);
					System.out.println("***********           Test case  number : " + TestCaseID
							+ " is passed             ************");
					Thread.sleep(1000);
				} else {
					System.out.println("Run Mode for Test case id : " + TestCaseID + "is " + sRunMode);
					Log.info("Run Mode for Test case id : " + TestCaseID + "is " + sRunMode);

				}
			} 
			Log.endTestCase(methodName);
		} catch (Exception e) {
			getScreenshot(driver, TestCaseID);
			System.out.println(e.getMessage());
			Log.error(TestCaseID);
			Log.error(methodName);
		}

	}

}
