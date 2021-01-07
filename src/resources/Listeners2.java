package resources;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners2 implements ITestListener {
	
	@Override		
    public void onFinish(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onStart(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
		System.out.println("Failing with percentage test " + arg0.getMethod().getMethodName() + "...");

    }		

    @Override		
    public void onTestFailure(ITestResult arg0) {					
        // TODO Auto-generated method stub				
		System.out.println("Failing test " + arg0.getMethod().getMethodName() + "...");

    }		

    @Override		
    public void onTestSkipped(ITestResult arg0) {					
        // TODO Auto-generated method stub				
		System.out.println("Skipping test " + arg0.getMethod().getMethodName() + "...");

    }		

    @Override		
    public void onTestStart(ITestResult arg0) {					
        // TODO Auto-generated method stub	
		System.out.println("Starting test " + arg0.getMethod().getMethodName() + "...");
        		
    }		

    @Override		
    public void onTestSuccess(ITestResult arg0) {					
        // TODO Auto-generated method stub				
		System.out.println("Passing test " + arg0.getMethod().getMethodName() + "...");

    }		

}
