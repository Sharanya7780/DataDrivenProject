package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import applicationLayer.AddEmployee;
import config.Base;
import utilities.ExcelFileUtil;

public class AppTest extends Base {
String inputpath ="./FileInput/EmpData.xlsx";
String Outputpath ="./FileOutput/DataDrivenResults.xlsx";
ExtentReports report;
ExtentTest logger;
String TCSheet = "AddEmp";
@Test
public void startTest() throws Throwable
{
	//define path to generate html reports
	report = new ExtentReports("./target/Reports/AddEmp.html");
	ExcelFileUtil xl = new ExcelFileUtil(inputpath);
	int rc = xl.rowcount(TCSheet);
	Reporter.log("No of rows are::"+rc,true);
	for(int i=1;i<=rc;i++)
	{
		logger = report.startTest("Add Employee");
		logger.assignAuthor("Ranga");
	String FirstName = xl.getCellData(TCSheet, i, 0);
	String Middlename = xl.getCellData(TCSheet, i, 1);
	String LastName = xl.getCellData(TCSheet, i, 2);
	logger.log(LogStatus.INFO, FirstName+"  "+Middlename+"  "+LastName);
	AddEmployee emp = PageFactory.initElements(driver, AddEmployee.class);
	boolean res = emp.verifyEmp(FirstName, Middlename, LastName);
	if(res)
	{
		xl.setCellData(TCSheet, i, 3,"Pass",Outputpath);
		logger.log(LogStatus.PASS, "Add Employee Success");
	}
	else
	{
		xl.setCellData(TCSheet, i, 3,"Fail",Outputpath);
		logger.log(LogStatus.FAIL, "Add Employee Fail");
	}
	report.endTest(logger);
	report.flush();
	
	}
}
}
