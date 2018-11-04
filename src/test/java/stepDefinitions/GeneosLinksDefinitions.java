package stepDefinitions;

import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import serenitySteps.GeneosLinksSteps;

public class GeneosLinksDefinitions {

    @Steps
    GeneosLinksSteps geneosPageSteps;

    @Given("^the Geneos page is loaded and it is correctly displayed$")
    public void GeneosPageDefinitions() {
            geneosPageSteps.loadGeneosPage();
            geneosPageSteps.isGeneosPageDisplayedCorrectly();
    }


}
