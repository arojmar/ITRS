package pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GeneosLinksPage extends PageObject {

    public static final String baseUrl = "https://resources.itrsgroup.com/docs/geneos/current/";
    @FindBy(css = "body > div.container.main-content > div > div:nth-child(1) > a > button")
    private WebElementFacade expandAllButton;

    @FindBy(css = "body > div.container.main-content > div > div.row.align-items-start")
    private WebElementFacade divAllLinks;

    public void loadGeneosPage() {
        getDriver().navigate().to(baseUrl);
    }

    public void assertGeneosPageIsDisplayedCorrectly() {
        assertThat("The Geneos page title is correct", getDriver().getTitle(), is("Geneos Home Page"));
        assertThat("The expand all/collapse all button is displayed", expandAllButton.isEnabled(), is(true));
        assertThat("The promoted articles section is displayed", divAllLinks.isDisplayed(), is(true));
    }

    public void clickInAllLinks() {

        List<WebElementFacade> linksToBeClicked = findAll("body > div.container.main-content > div a");
        ArrayList<String> currentListURLs = new ArrayList<>();
        ArrayList<WebElementFacade> currentCssSelectors = new ArrayList<>();
        List<String> urlsThatContainsHash = new ArrayList<>();
        Actions newWindow = new Actions(getDriver());
        String parentWindow = getDriver().getWindowHandle();

        for (WebElementFacade elementOfList : linksToBeClicked) {
            if (elementOfList.getAttribute("href").startsWith("http")) {
                currentListURLs.add(elementOfList.getAttribute("href"));
                currentCssSelectors.add(elementOfList);
                assertThat("The link "+elementOfList.getAttribute("href")+" is clickable", elementOfList.isEnabled(), is(true));
            }
        }

        for (WebElementFacade selector : currentCssSelectors) {
            if (!selector.getAttribute("href").contains("#")) {
                newWindow.keyDown(Keys.SHIFT).click(selector).keyUp(Keys.SHIFT).build().perform();
                getDriver().switchTo().window(parentWindow);

            } else {
                urlsThatContainsHash.add(selector.getAttribute("href"));
            }
        }

        for(String urlWithHash : urlsThatContainsHash) {
            String[] dataTarget = urlWithHash.split("#");
            getDriver().navigate().to(baseUrl+"Netprobe/netprobe_accord_links.htm");
            String pluginWindow = getDriver().getWindowHandle();
            WebElementFacade dataTargetWebElement = findBy("[data-target='#"+dataTarget[1]+"']");
            dataTargetWebElement.waitUntilClickable().click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Serenity.setSessionVariable("CURRENT_LIST_URL").to(currentListURLs);

    }

    public void assertAllLinksClickedAreWorkingCorrectly() {
        ArrayList<String> currentListURLs = Serenity.sessionVariableCalled("CURRENT_LIST_URL");
        ArrayList<String> clickedListURLs = new ArrayList<>();

        for (String urlStored : currentListURLs) {
            getDriver().navigate().to(urlStored);
            clickedListURLs.add(getDriver().getCurrentUrl());
        }
        Serenity.setSessionVariable("CLICKED_LIST_URL").to(clickedListURLs);

        assertThat(
                "The URL link is the same as in the a href",
                Serenity.sessionVariableCalled("CURRENT_LIST_URL").toString(),
                is(Serenity.sessionVariableCalled("CLICKED_LIST_URL").toString())
        );
    }
}
