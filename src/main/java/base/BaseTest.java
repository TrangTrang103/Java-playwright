package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import utils.ExtentManager;
import utils.ScreenshotUtils;

import java.lang.reflect.Method;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    protected ExtentReports extent;

    protected ExtentTest test;

    @BeforeMethod
    public void setUp(Method method) {

        extent = ExtentManager.getInstance();
        test = extent.createTest(method.getName());
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        page = browser.newPage();
        page.setDefaultTimeout(4000);

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE){
            test.fail(result.getThrowable());

            String screenshotPath = ScreenshotUtils.takeScreenshot(page, result.getName());

            System.out.println("*** screenshotPath : "+screenshotPath);
            String projectPath = System.getProperty("user.dir");

            String absoluteScreenshotPath = projectPath+"/"+screenshotPath;
            System.out.println(" *** absoluteScreenshotPath : "+absoluteScreenshotPath);

            test.addScreenCaptureFromPath(absoluteScreenshotPath, "screenshot");
//			test.addScreenCaptureFromBase64String(absoluteScreenshotPath, "screenshot");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test passed");
        } else {
            test.skip("Test Skipped");
        }

        extent.flush();

        if(browser != null) browser.close();
        if(playwright != null) playwright.close();

    }

}
