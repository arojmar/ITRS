package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchButtonPage extends PageObject {

    @FindBy(css="body > div.cookie-compliance.clearfix > div > button")
    private WebElementFacade cookiesButton;

    @FindBy(css="//*[@id='block-itrsgroup-com-main-menu']/ul/li[7]/div")
    private WebElementFacade searchButton;


    public void navigateToITRSPage() {
        getDriver().navigate().to("http://www.itrsgroup.com");
    }

    public void acceptCookies() {
        cookiesButton.waitUntilClickable().click();
    }
    public void clickSearchButton() {
        searchButton.setWindowFocus();
        searchButton.click();
    }

}
