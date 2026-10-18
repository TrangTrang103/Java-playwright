package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeMethod
    public void setUp() {

        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        page = browser.newPage();
        page.setDefaultTimeout(4000);

    }

    @AfterMethod
    public void tearDown() {
        if(browser != null) browser.close();
        if(playwright != null) playwright.close();

    }

}
