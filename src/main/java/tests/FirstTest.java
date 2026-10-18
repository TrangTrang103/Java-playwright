package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {
    @Test
    public void verifyTitle() {
        page.navigate("https://google.com/ncr");
        // Optional: Handle cookie popup
        if (page.isVisible("button:has-text('Accept all')")) {
            page.click("button:has-text('Accept all')");
        }

    }
}
