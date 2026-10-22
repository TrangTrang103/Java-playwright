package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import javax.naming.ldap.ExtendedRequest;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance(){
        if(extent == null){
            ExtentSparkReporter reporter = new ExtentSparkReporter("z-output/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
}
