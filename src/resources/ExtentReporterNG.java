package resources;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

 
public class ExtentReporterNG implements IReporter {
    private static ExtentReports extent;
    ExtentHtmlReporter htmlReporter;
 
	@Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
    	
        htmlReporter = new ExtentHtmlReporter(outputDirectory + File.separator + "htmlreport.html");
        

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
 
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();		
                buildTestNodes(context.getFailedTests(), Status.FAIL);
                buildTestNodes(context.getSkippedTests(), Status.SKIP);
                buildTestNodes(context.getPassedTests(), Status.PASS);
                buildTestNodes(context.getFailedConfigurations(), Status.FAIL);
            }
        }
 
        extent.flush();
    }
 

    private void buildTestNodes(IResultMap tests, Status status) {
        ExtentTest test;
		
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
       
                
                String message = "Test " + status.toString().toLowerCase() + "ed";
 
                if (result.getThrowable() != null) {
                    message = result.getThrowable().getMessage();
                }
                test = extent.createTest(result.getMethod().getMethodName());
                test.log(status, message);
                
            }
        }
    }
    
}