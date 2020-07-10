package leads;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testNG.base.revise.ProjectSpecMethod;

public class EditLead extends ProjectSpecMethod{
	@BeforeTest	
	public void SetData() {
		ExcelFileName="TC002";
	}

	@Test(dataProvider="eLead")
	public  void TC002(String ph, String cname) throws InterruptedException {
		
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//span[text()='Phone']").click();
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(ph);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		driver.findElementByLinkText("Edit").click();
		driver.findElementById("updateLeadForm_companyName").sendKeys(cname);
		driver.findElementByName("submitButton").click();

	}
}






