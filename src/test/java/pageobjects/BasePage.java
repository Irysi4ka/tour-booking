package pageobjects;

import org.openqa.selenium.WebDriver;

public class BasePage extends AbstractPage {
    private final String BASE_URL = "https://www.coral.by/";

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public BasePage openPage() {
        driver.get(BASE_URL);
        return this;
    }

}
