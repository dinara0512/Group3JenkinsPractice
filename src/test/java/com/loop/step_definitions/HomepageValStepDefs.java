package com.loop.step_definitions;

import com.loop.pages.DocuportLoginPage;
import com.loop.pages.LoginPage;
import com.loop.pages.ValidationPage;
import com.loop.utilities.utilities.BrowserUtilities;
import com.loop.utilities.utilities.ConfigurationReader;
import com.loop.utilities.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.SoftAssertions;
import java.util.Map;
import org.assertj.core.api.SoftAssertions;

import static org.junit.Assert.assertEquals;


public class HomepageValStepDefs {

    LoginPage loginPage = new LoginPage();

    ValidationPage validationPage = new ValidationPage();

   private SoftAssertions softAssertions = new SoftAssertions();
    @Given("user is on the Docuport login page")
    public void user_is_on_the_docuport_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        BrowserUtilities.takeScreenshot();
    }

    @Then("user validate {string} text is displayed")
    public void user_validate_text_is_displayed(String text) {
        //assertTrue(loginPage.getElement(text).isDisplayed());
        String actual = loginPage.getElementText(text);
        //assertEquals("Actual text: " + actual + " does NOT match expected: " + text, actual, text);
        softAssertions.assertThat(actual).isEqualTo(text);

    }

    @When("user enter credentials")
    public void user_enter_credentials(Map<String, String> credentials) {
        validationPage.loginsDocuport(credentials.get("username"), credentials.get("password"));
    }

    @When("user validate all assertions")
    public void user_validate_all_assertions() {
        softAssertions.assertAll();
    }

}
