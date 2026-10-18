package pages;

import com.microsoft.playwright.Page;

public class LoginPage {


    private Page page;
    private final String userNameInput = "input[name='username']";
    private final String passwordInput = "input[name='password']";
    private final String loginButton = "button[type='submit'].orangehrm-login-button";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void addUserName(String userName){
        page.fill(userNameInput, userName);
    }

    public void addPassword(String password){
        page.fill(passwordInput, password);
    }

    public void clickButton(){
        page.click(loginButton);
    }

    public void login(String userName, String password){
        page.fill(userNameInput, userName);
        page.fill(passwordInput, password);
        page.click(loginButton);
    }

}
