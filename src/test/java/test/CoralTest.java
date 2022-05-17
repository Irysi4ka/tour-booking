package test;

import org.testng.annotations.Test;
import pageobjects.BasePage;
import pageobjects.SearchToursPanelPage;

public class CoralTest extends AbstractTest {

    private String cityTo = "Египет";
    //private String departDate = "04.06";

    @Test
    public void testTourSearch() {
        BasePage basePage = new BasePage(driver)
                .openPage();

        SearchToursPanelPage searchToursPanelPage = new SearchToursPanelPage(driver)
                .selectCityTo(cityTo)
                .selectDateFrom();

    }
}
