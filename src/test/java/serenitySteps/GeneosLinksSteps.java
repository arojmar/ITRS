package serenitySteps;

import net.thucydides.core.steps.ScenarioSteps;
import pages.GeneosLinksPage;

public class GeneosLinksSteps extends ScenarioSteps {

    private GeneosLinksPage getGeneosLinksPage() {
        return getPages().get(GeneosLinksPage.class);
    }

    public void loadGeneosPage() {
        getGeneosLinksPage().loadGeneosPage();
    }

    public void isGeneosPageDisplayedCorrectly() {
        getGeneosLinksPage().assertGeneosPageIsDisplayedCorrectly();
    }

    public void clickInAllGeneosLinks() {
        getGeneosLinksPage().clickInAllLinks();
    }

    public void areAllTheLinksInGeneosPageWorkingCorrectly() {
        getGeneosLinksPage().assertAllLinksClickedAreWorkingCorrectly();
    }
}