package tests;

import base.BaseTest;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest3() {
        LoginPage loginpage = new LoginPage(page);
//		HomePage homepage = new HomePage(page);

        test.info("Navigating to login page");
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        test.info("Adding username");
        loginpage.addUserName("Admin");

        test.info("Adding password");
        loginpage.addPassword("admin123");

        test.info("Clicking login button");
        loginpage.clickButton();

        test.info("checking homepage");
//		homepage.clickTimeLink();

        test.info("all steps completed");
    }

    @Test
    public void loginTest1() {
        LoginPage loginpage = new LoginPage(page);
        HomePage homepage = new HomePage(page);

        test.info("Navigating to login page");
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        test.info("Adding username");
        loginpage.addUserName("Admin");

        test.info("Adding password");
        loginpage.addPassword("admin123");

        test.info("Clicking login button");
        loginpage.clickButton();

        test.info("checking homepage");
        homepage.clickTimeLink();

        test.info("all steps completed");
    }

    @Test
    public void loginTest2() {

        test.skip("Skipping this test");
        throw new SkipException("Skipping this test");
    }



}



