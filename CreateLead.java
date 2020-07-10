package leads;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testNG.base.revise.ProjectSpecMethod;

public class CreateLead extends ProjectSpecMethod{
@BeforeTest	
public void SetData() {
	ExcelFileName="Updated Data";
}
@Test(dataProvider = "cLead")
	public void TC001(String cname, String fname,String lname) {
		System.out.println("test method starts");
		
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys(cname);
		driver.findElementById("createLeadForm_firstName").sendKeys(fname);
		driver.findElementById("createLeadForm_lastName").sendKeys(lname);
		driver.findElementByName("submitButton").click();
		System.out.println("test method ends");
		
}
}






