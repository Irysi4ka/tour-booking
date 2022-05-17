package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchToursPanelPage extends AbstractPage {

    public SearchToursPanelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='fastSearch']")
    private WebElement inputCityTo;
    @FindBy(xpath = "//a[@id='toggleAvailableCountries']")
    private WebElement buttonCityTo;
    @FindBy(xpath = "//div[@class='search-panel_calendar']")
    private WebElement inputCalendar;
    @FindBy(xpath = "(//div[@class='persons-dropdown_option'])[1]")
    private WebElement buttonNightsFrom;
    @FindBy(xpath = "(//div[@class='selectric'])[2]")
    private WebElement buttonNightsTo;
    @FindBy(xpath = "(//div[@class='search-panel_field-content'])[4]")
    private WebElement buttonNumberOfPeople;
    @FindBy(xpath = "(//div[@class='selectricWrapper'])[3]")
    private WebElement buttonNumberOfAdults;
    @FindBy(xpath = "(//div[@class='selectric'])[4]")
    private WebElement buttonNumberOfChildren;
    @FindBy(xpath = "//input[@class='input-1']")
    private WebElement inputFirstChildAge;
    @FindBy(xpath = "//input[@class='input-1']")
    private WebElement inputSecondChildAge;
    @FindBy(xpath = "//div[@class='persons-dropdown_action']//button")
    private WebElement buttonReadyPeople;
    @FindBy(xpath = "//div[@class='search-panel_action btnSearch']//button")
    private WebElement buttonSearchTours;
    private String resultCityTo = "//a[@class='available_flights_list_country']";
    private String resultFirstMonth = "(//div[@class='datepick-month-header'])[1]";
    private String dateFour = "//a[@class='dp1654333200000   datepick-weekend']";
    @FindBy(xpath = "//div[@class='datepick-month first']//td")
    private WebElement dayOfMonthFirst;

    public SearchToursPanelPage fillFormTours(String cityTo, String departDate, String a) {
        inputCityTo.sendKeys(cityTo);
        inputCalendar.sendKeys(departDate);
        buttonNightsFrom.click();
        return this;
    }

    public SearchToursPanelPage selectCityTo(String selectedCity) {
        buttonCityTo.click();
        List<WebElement> cities = driver.findElements(By.xpath(resultCityTo));
        for (WebElement city : cities) {
            if (selectedCity.equals(city.getText().trim())) {
                logger.info(city.getText());
                city.click();
                break;
            }
        }
        return this;
    }

    public SearchToursPanelPage selectDateFrom() throws InterruptedException {
        inputCalendar.click();
        String dateFirst = "15";
        while (!driver.findElement(By.xpath(resultFirstMonth)).getText().contains("Июнь")) {
            driver.findElement(By.xpath("//a[@class='datepick-cmd datepick-cmd-next ']")).click();
        }
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='datepick-month first']//td"));
        for (WebElement element : elements) {
            if (element.getText().equals(dateFirst)) {
                element.click();
                break;
            }
        }
        Thread.sleep(8000);
        /*
        while (!driver.findElement(By.xpath(resultFirstMonth)).getText().contains("Июнь")) {
            driver.findElement(By.xpath("//a[@class='datepick-cmd datepick-cmd-next ']")).click();
        }
        int count = driver.findElements(By.xpath(dateFour)).size();
        for (int i = 0; i < count; i++) {
            String text = driver.findElement(By.xpath(dateFour)).getText();
            if (text.equalsIgnoreCase("4")) {
                driver.findElement(By.xpath(dateFour)).click();
                driver.findElement(By.xpath("//a[@class='datepick-cmd datepick-cmd-close ']")).click();
                logger.info(text);
            }
        }*/
        return this;
    }

    public SearchToursPanelPage selectNightsFrom() {
        buttonNightsFrom.click();
        String dateNightFromWith11 = driver.findElement(By.xpath("//div[@class='selectricItems']//li[11]")).getText();
        driver.findElement(By.xpath("//div[@class='selectricItems']//li[11]")).click();
        logger.info(dateNightFromWith11);
        return this;
    }

    public SearchToursPanelPage selectNightsTo() {
        buttonNightsTo.click();
        String dateNightToWith11 = driver.findElement(By.xpath("(//div[@class='selectricItems']//li[1])[2]")).getText();
        driver.findElement(By.xpath("(//div[@class='selectricItems']//li[1])[2]")).click();
        logger.info(dateNightToWith11);
        return this;
    }

    public SearchToursPanelPage selectNumberOfPeople() {
        buttonNumberOfPeople.click();
        buttonNumberOfAdults.click();
        driver.findElement(By.xpath("(//div[@class='search-panel_dropdown-menu']//div[@class='selectricItems']//li[2])[1]")).click();
        buttonNumberOfChildren.click();
        driver.findElement(By.xpath("(//div[@class='search-panel_dropdown-menu']//div[@class='selectricItems']//li[3])[2]")).click();
        driver.findElement(By.xpath("(//div[@class='persons-dropdown_row']//input[@class='input-1 accError'])[1]")).clear();
        driver.findElement(By.xpath("(//div[@class='persons-dropdown_row']//input[@class='input-1 accError'])[1]")).sendKeys("6");
        driver.findElement(By.xpath("(//div[@class='persons-dropdown_row']//input[@class='input-1 accError'])[1]")).clear();
        driver.findElement(By.xpath("(//div[@class='persons-dropdown_row']//input[@class='input-1 accError'])[1]")).sendKeys("8");
        driver.findElement(By.xpath("//div[@class='persons-dropdown_action']//button[@class='btn btn-1 persons-dropdown_btn __orange']")).click();
        return this;
    }

    public SearchToursPanelPage clickButtonSearchTours() {
        buttonSearchTours.click();
        return this;
    }

}
