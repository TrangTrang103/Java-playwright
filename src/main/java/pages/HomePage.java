package pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private final Page page;
    private final String timeLink = "oxd-text oxd-text--span oxd-main-menu-item--name0";

    public HomePage(Page page){
      this.page = page;
    }

    public void clickTimeLink(){
        page.locator(timeLink).click();
    }
}
