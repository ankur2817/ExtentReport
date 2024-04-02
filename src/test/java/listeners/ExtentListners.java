package listeners;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentListners implements ITestListener {
    static Date d = new Date();
    static String fileName = "Extent_Report" + d.toString().replace(":", "_");

    private static ExtentReports extent = ExtentManager.settingUpReport("./extentReports/"+fileName);

    // Useful during parallel testing
    public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();


    @Override
    public void onTestStart(ITestResult result) {

	ExtentTest test =  extent.createTest(result.getTestClass().getName() + result.getMethod().getMethodName());
	testReport.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
	Markup m = MarkupHelper.createLabel("<b>" + "Test case: " + result.getMethod().getMethodName().toUpperCase() + " PASSED" + "</b>", ExtentColor.GREEN);
	testReport.get().pass(m);
    }

    @Override
    public void onTestFailure(ITestResult result) {
	Markup m = MarkupHelper.createLabel("<b>" + "Test case: " + result.getMethod().getMethodName().toUpperCase() + " FAILED" + "</b>", ExtentColor.RED);
	testReport.get().fail(m);
	testReport.get().fail(Arrays.toString(result.getThrowable().getStackTrace()).replaceAll(",", "<br>"));
	
    }

    @Override
    public void onTestSkipped(ITestResult result) {
	Markup m = MarkupHelper.createLabel("<b>" + "Test case: " + result.getMethod().getMethodName().toUpperCase() + " SKIPPED" + "</b>", ExtentColor.AMBER);
	testReport.get().skip(m);
	testReport.get().skip(Arrays.toString(result.getThrowable().getStackTrace()).replaceAll(",", "<br>"));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
	if (extent != null) 
	    extent.flush();
    }

}
