package serenitySteps;

import net.serenitybdd.core.Serenity;
import pages.SupportPageLinksPage;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;
import static org.junit.Assert.fail;

public class SupportPageLinksSteps {

    private SupportPageLinksPage getSupportPageLinksPage() {
        return getPages().get(SupportPageLinksPage.class);
    }

    public void loadSupportPage() {
        getSupportPageLinksPage().loadSupportPage();
    }

    public void isSupportPageDisplayedCorrectly() {
        getSupportPageLinksPage().assertSupportPageIsDisplayedCorrectly();
    }

    public void clickOnTheCategoriesLink(String linkName) {

        Serenity.setSessionVariable("LINK_NAME").to(linkName);
        switch (linkName) {
            case "Welcome":
                getSupportPageLinksPage().clickOnCategoriesLink(1);
                break;
            case "Geneos Self-Help":
                getSupportPageLinksPage().clickOnCategoriesLink(2);
                break;
            case "Geneos Plugin Help":
                getSupportPageLinksPage().clickOnCategoriesLink(3);
                break;
            case "User Guides":
                getSupportPageLinksPage().clickOnCategoriesLink(4);
                break;
            default:
                fail("The linkName doesn't exists.");
                break;
        }
    }

    public void assertIfURLopenIsCorrect(String linkUrl) {
        getSupportPageLinksPage().assertIfURLopenIsCorrect(linkUrl);
    }

    public void clickOnLinks(String section) {
        getSupportPageLinksPage().clickOnSectionLink(section);
    }

    public void areLinksOfSectionWorkingCorrectly(String section) {
        getSupportPageLinksPage().assertLinksAreWorkingCorrectly(section);
    }
}
