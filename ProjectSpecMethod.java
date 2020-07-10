package testNG.base.revise;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import util.ReadExcelInput;
import utility.ReadExcel;

public class ProjectSpecMethod {
 public ChromeDriver driver;
 public String ExcelFileName;
@Parameters({"url","username","password"})	
@BeforeMethod
	public void OpenApp(String url,String uname, String pwd)
{
		// TODO Auto-generated method stub
	    System.out.println("Before method starts");
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		//Enter UserName and Password Using Id Locator
		driver.findElementById("username").sendKeys(uname);
		driver.findElementById("password").sendKeys(pwd);

		//Click on Login Button using Class Locator
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		System.out.println("Before method ends");
}

@AfterMethod
public void closeApp()
{
		System.out.println("After method starts");
		driver.close();
        System.out.println("After method ends");
	}

@DataProvider(name="cLead")
public String[][] sendData() throws IOException {
String[][] readExceldata = ReadExcelInput.readExceldata(ExcelFileName);
return readExceldata;
	
/*String[][] array = new String [2][3];
	
array[0][0]="TCS";
array[0][1]="div";
array[0][2]="avu";

array[1][0]="Mastercard";
array[1][1]="vid";
array[1][2]="avu";

return array;*/
}

@DataProvider(name="eLead")
public String[][] SendLead() throws IOException {
	
	String[][] data2 = ReadExcelInput.readExceldata(ExcelFileName);
	return data2;
	
	/*String[][] ar= new String[2][2];
	
	ar[0][0]="99";
	ar[0][1]="TCS";
	

	ar[1][0]="98";
	ar[1][1]="CTS";	
	return ar;*/
}

@DataProvider(name= "dLead")
public String[][] DelLead() throws IOException {
		String[][] data3 = ReadExcelInput.readExceldata(ExcelFileName);
		return data3;
/*String[][] darray = new String [2][1];

darray[0][0]="99";
darray[1][0]="98";
return darray;*/

}


@DataProvider(name= "mLead")
public String[][] MerLead() throws IOException {
		String[][] data4 = ReadExcelInput.readExceldata(ExcelFileName);
		return data4;


}}


