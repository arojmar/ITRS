package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import serenitySteps.GeneosLinksSteps;

public class GeneosLinksDefinitions {

    @Steps
    private GeneosLinksSteps geneosPageSteps;

    @Given("^the Geneos page is loaded and it is correctly displayed$")
    public void GeneosPageDefinitions() {
        geneosPageSteps.loadGeneosPage();
        geneosPageSteps.isGeneosPageDisplayedCorrectly();
    }

    @When("^each of the links in Geneos Page are clicked$")
    public void eachOfTheLinksInGeneosPageAreClicked() {
        geneosPageSteps.clickInAllGeneosLinks();
    }

    @Then("^the opened pages corresponds with the URL in the links clicked$")
    public void theOpenedPagesCorrespondsWithTheURLInTheLinksClicked() {
        geneosPageSteps.areAllTheLinksInGeneosPageWorkingCorrectly();
    }
}
