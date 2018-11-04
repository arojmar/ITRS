package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GeneosLinksPage extends PageObject {

    @FindBy(css="body > div.container.main-content > div > div:nth-child(1) > a > button")
    private WebElementFacade expandAllButton;

    @FindBy(css="body > div.container.main-content > div > div.row.align-items-start")
    private WebElementFacade divAllLinks;

    public void loadGeneosPage() {
        getDriver().navigate().to("https://resources.itrsgroup.com/docs/geneos/current/");
    }

    public void assertGeneosPageIsDisplayedCorrectly() {
        assertThat("The Geneos page title is correct", getDriver().getTitle(), is("Geneos Home Page"));
        assertThat("The expand all/collapse all button is displayed", expandAllButton.isEnabled(), is(true));
        assertThat("The promoted articles section is displayed", divAllLinks.isDisplayed(), is(true));
    }

    public void clickInAllLinks() {

    }

    public void assertAllLinksClickedAreWorkingCorrectly() {

    }
}
