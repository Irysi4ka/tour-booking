package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class AbstractPage {
    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger();

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

}
