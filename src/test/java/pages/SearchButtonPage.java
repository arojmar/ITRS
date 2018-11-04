package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SearchButtonPage extends PageObject {

    @FindBy(css = "body > div.cookie-compliance.clearfix > div > button")
    private WebElementFacade cookiesButton;

    @FindBy(xpath = "//*[@id='block-itrsgroup-com-main-menu']/ul/li[7]/div")
    private WebElementFacade searchButton;

    @FindBy(css = "[id='block-algolia-search-search-top'] .algolia-search-autocomplete")
    private WebElementFacade topBar;

    @FindBy(className = "search-results")
    private WebElementFacade resultPage;


    public void navigateToITRSPage() {
        getDriver().navigate().to("http://www.itrsgroup.com");
    }

    public void acceptCookies() {
        cookiesButton.waitUntilClickable().click();
    }

    public void clickSearchButton() {
        searchButton.waitUntilClickable().click();
    }

    public void isSearchBarDisplayed() {
        assertThat("The Searching Bar is Displayed in the top of the web", topBar.waitUntilVisible().isDisplayed(), is(true));
    }

    public void typeWordinSearchingBar(String wordToType) {
        topBar.sendKeys(wordToType);
    }

    public void isResultPageDisplayed() {
        assertThat("The Result Page is Displayed under the Search Bar", resultPage.waitUntilVisible().isDisplayed(), is(true));
    }
}
