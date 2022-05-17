package test;

import org.testng.annotations.Test;
import pageobjects.BasePage;
import pageobjects.SearchToursPanelPage;

public class CoralTest extends AbstractTest {

    private String cityTo = "Египет";

    @Test
    public void testTourSearch() throws InterruptedException {
        BasePage basePage = new BasePage(driver)
                .openPage();

        SearchToursPanelPage searchToursPanelPage = new SearchToursPanelPage(driver)
                .selectCityTo(cityTo)
                .selectDateFrom()
                .selectNightsFrom()
                .selectNightsTo()
                .selectNumberOfPeople();

        Thread.sleep(5000);
    }
}
