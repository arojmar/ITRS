package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import serenitySteps.SearchButtonSteps;

public class SearchButtonDefinitions {

    @Steps
    SearchButtonSteps searchButtonSteps;


    @Given("^a user accesses to the main ITRS page$")
    public void aUserAccessesToTheMainITRSPage() {
        searchButtonSteps.userAccessToITRSPage();
    }

    @When("^user selects the search button$")
    public void userSelectsTheSearchButton() {
        searchButtonSteps.selectSearchButton();
    }

    @Then("^the searching bar is displayed$")
    public void theSearchingBarIsDisplayed() {
        searchButtonSteps.searchBarIsDisplayed();
    }

    @Then("^user types the word \"([^\"]*)\" in the searching bar$")
    public void userTypesTheWordInTheSearchingBar(String wordToSearch) {
        searchButtonSteps.typeWordInSearchingBar(wordToSearch);
    }

    @And("^the result page is displayed$")
    public void theResultPageIsDisplayed() {
        searchButtonSteps.resultPageIsDisplayed();
    }
}
