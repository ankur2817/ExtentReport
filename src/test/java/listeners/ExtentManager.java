package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    
    static ExtentReports extent;
    
    public static ExtentReports settingUpReport(String fileName) {
	ExtentSparkReporter objExtentSparkReporter = new ExtentSparkReporter(fileName);
	
	objExtentSparkReporter.config().setEncoding("utf-8");
	objExtentSparkReporter.config().setTheme(Theme.DARK);
	objExtentSparkReporter.config().setDocumentTitle(fileName);
	objExtentSparkReporter.config().setReportName(fileName);
	
	extent = new ExtentReports();
	extent.attachReporter(objExtentSparkReporter);
	
	extent.setSystemInfo("Organization", "Open sourced");
	extent.setSystemInfo("QA", "Ankur Gupta");
	
	return extent;
    }
    

}
