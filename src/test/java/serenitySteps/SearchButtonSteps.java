package serenitySteps;

import net.thucydides.core.steps.ScenarioSteps;
import pages.SearchButtonPage;

public class SearchButtonSteps extends ScenarioSteps {

    private SearchButtonPage getSearchButtonPage() { return getPages().get(SearchButtonPage.class);}


    public void userAccessToITRSPage() {
        getSearchButtonPage().navigateToITRSPage();
        getSearchButtonPage().acceptCookies();
    }

    public void selectSearchButton() {
        getSearchButtonPage().clickSearchButton();
    }

    public void searchBarIsDisplayed() {

    }

    public void typeWordInSearchingBar(String wordToSearch) {

    }

    public void resultPageIsDisplayed() {

    }
}
