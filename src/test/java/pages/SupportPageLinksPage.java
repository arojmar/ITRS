package pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

public class SupportPageLinksPage extends PageObject {

    private static final String baseUrl = "https://support.itrsgroup.com";

    @FindBy(css="body > main > div > section.section.knowledge-base > section.categories.blocks > ul")
    private WebElementFacade categoriesSection;

    @FindBy(css="body > main > div > section.section.knowledge-base > section.articles > ul > li")
    private WebElementFacade articlesSection;

    @FindBy(css="body > main > div > section.section.activity > div > div > ul")
    private WebElementFacade recentActivitySection;


    public void loadSupportPage(){
        getDriver().navigate().to(baseUrl);
    }

    public void assertSupportPageIsDisplayedCorrectly(){
        assertThat("The support page title is correct", getDriver().getTitle(), is("ITRS"));
        assertThat("The categories section is displayed", categoriesSection.isDisplayed(), is(true));
        assertThat("The promoted articles section is displayed", articlesSection.isDisplayed(), is(true));
    }

    public void clickOnCategoriesLink(int index) {
        WebElementFacade categoriesSections = element(categoriesSection.findElement(By.cssSelector(String.format("li:nth-child(%s)", index))));
        categoriesSections.click();
    }


    public void clickOnSectionLink(String section) {

        List<WebElementFacade> linksToBeClicked = new ArrayList<>();

        switch (section) {
            case "categorie blocks":
                linksToBeClicked = findAll("body > main > div > section.section.knowledge-base > section.categories.blocks a");
                break;
            case "articles":
                linksToBeClicked = findAll("body > main > div > section.section.knowledge-base > section.articles a");
                break;
            case "activity":
                linksToBeClicked = findAll("body > main > div > section.section.activity > div > div a");
                break;
            default:
                fail("The section doesn't exists.");
                break;
        }
        ArrayList<String> currentListURLs = new ArrayList<>();
        ArrayList<String> clickedListURLs = new ArrayList<>();
        Actions newWindow = new Actions(getDriver());
        String parentWindow = getDriver().getWindowHandle();

        for(WebElementFacade elementOfList : linksToBeClicked) {
            currentListURLs.add(elementOfList.getAttribute("href"));
            newWindow.keyDown(Keys.SHIFT).click(elementOfList).keyUp(Keys.SHIFT).build().perform();
            clickedListURLs.add(getDriver().getCurrentUrl());
            getDriver().switchTo().window(parentWindow);
        }
        Serenity.setSessionVariable("CURRENT_LIST_URL_"+section).to(currentListURLs);
        Serenity.setSessionVariable("CLICKED_LIST_URL_"+section).to(currentListURLs);
    }

    public void assertIfURLopenIsCorrect(String linkUrl) {
        String linkName = Serenity.sessionVariableCalled("LINK_NAME");
        assertThat("The URL for "+linkName+" is correct", getDriver().getCurrentUrl() ,is(baseUrl+linkUrl));
        getDriver().navigate().back();
    }

    public void assertLinksDisplayedCorrectly(String section) {
        assertThat(
                "The URL link is the same as in the a href",
                Serenity.sessionVariableCalled("CURRENT_LIST_URL_"+section).toString(),
                is(Serenity.sessionVariableCalled("CLICKED_LIST_URL_"+section).toString())
        );
    }
}
