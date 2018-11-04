package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import serenitySteps.SupportPageLinksSteps;

public class SupportPageLinksDefinitions {

    @Steps
    private SupportPageLinksSteps supportPageLinksSteps;

    @Given("^the support page is loaded and it is correctly displayed$")
    public void theSupportPageIsLoadedAndItIsCorrectlyDisplayed() {
        supportPageLinksSteps.loadSupportPage();
        supportPageLinksSteps.isSupportPageDisplayedCorrectly();
    }


    @When("^the \"([^\"]*)\" link is clicked$")
    public void theLinkIsClicked(String linkName) {
        supportPageLinksSteps.clickOnTheCategoriesLink(linkName);
    }

    @Then("^the page opened corresponds with the \"([^\"]*)\"$")
    public void thePageOpenedCorrespondsWithThe(String linkURL) {
        supportPageLinksSteps.assertIfURLopenIsCorrect(linkURL);

    }

    @When("^each of the \"([^\"]*)\" links are clicked$")
    public void eachOfTheLinksAreClicked(String section) {
        supportPageLinksSteps.clickOnLinks(section);
    }

    @Then("^the \"([^\"]*)\" pages is displayed correctly$")
    public void thePagesIsDisplayedCorrectly(String section)   {
        supportPageLinksSteps.areLinksOfSectionDisplayedCorrectly(section);
    }
}

