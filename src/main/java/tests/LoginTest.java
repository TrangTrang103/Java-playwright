package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {


    @Test
    public void Test(){
        LoginPage loginpage = new LoginPage(page);
        HomePage homepage = new HomePage(page);
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginpage.addUserName("Admin");
        loginpage.addPassword("admin123");
        loginpage.clickButton();
        homepage.clickTimeLink();
    }


}
