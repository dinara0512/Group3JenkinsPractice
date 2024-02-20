package com.loop.step_definitions;

import com.loop.pages.DocuportAdv1099Page;
import com.loop.utilities.utilities.BrowserUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Advisor1099ExportstepDefs {


    DocuportAdv1099Page docuport1099Page = new DocuportAdv1099Page();
    @When("user adv clicks {string}")
    public void user_adv_clicks_form(String button) {
        docuport1099Page.advClickButton(button);

    }
    @Then("user adv selects and validates current year")
    public void user_adv_selects_and_validates_current_year() {
        BrowserUtilities.waitForClickable(docuport1099Page.dropdownelem, 5).click();
        BrowserUtilities.waitForClickable(docuport1099Page.currentYearOpt, 5).click();
    }

    @Then("user adv validates approved pop-up is displayed")
    public void user_adv_validates_approved_pop_up_is_displayed() {
        assertTrue(BrowserUtilities.waitForVisibility(docuport1099Page.popUpMessage, 5).isDisplayed());
        BrowserUtilities.takeScreenshot();
    }
}
