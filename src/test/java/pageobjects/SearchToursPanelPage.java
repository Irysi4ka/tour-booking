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
    @FindBy(xpath = "//div[@class='selectricWrapper selectricOpen']")
    private WebElement buttonNightsFrom;
    @FindBy(xpath = "(//div[@class='selectricWrapper'])[2]")
    private WebElement buttonNightsTo;
    @FindBy(xpath = "//div[@class='search-panel_field-select search-panel_dropdown __opened']")
    private WebElement buttonNumberOfPeople;
    @FindBy(xpath = "(//div[@class='selectricWrapper'])[3]")
    private WebElement buttonNumberOfAdults;
    @FindBy(xpath = "(//div[@class='selectricWrapper'])[4]")
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
    private String resultFirstDate = "(//table[@class='datepick-month-table']//tbody)[1]";
    private String resultSecondMonth = "(//div[@class='datepick-month-header'])[2]";
    private String resultSecondDate = "(//table[@class='datepick-month-table']//tbody)[2]";
    private String dateFour = "//a[@class='dp1654333200000   datepick-weekend']";

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

    public SearchToursPanelPage selectDateFrom() {
        inputCalendar.click();
        while (!driver.findElement(By.xpath(resultFirstMonth)).getText().contains("Июнь")) {
            driver.findElement(By.xpath("//a[@class='datepick-cmd datepick-cmd-next ']")).click();
        }
        int count = driver.findElements(By.xpath(dateFour)).size();
        for (int i = 0; i < count; i++) {
            String text = driver.findElement(By.xpath(dateFour)).getText();
            if(text.equalsIgnoreCase("4")){
                driver.findElement(By.xpath(dateFour)).click();
                driver.findElement(By.xpath("//a[@class='datepick-cmd datepick-cmd-close ']")).click();
                logger.info(text);
            }
        }
        return this;
    }


}
