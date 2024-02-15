package com.loop.step_definitions;

import com.loop.pages.LoginPage;
import com.loop.pages.ValidatingRow;
import com.loop.utilities.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class AdvisorValidatingRows_step_defs {
    private final com.loop.pages.LoginPage LoginPage = new LoginPage();
    private final ValidatingRow validatingRow = new ValidatingRow();
    private final WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));


    @Given("user login as {string}")
    public void user_login_as(String advisor) {
        LoginPage.loginAsAdvisor();
    }

    @When("user click on Leads")
    public void user_click_on_leads() {
        validatingRow.leads.click();
    }

    @Then("user validate that Rows Per Page defaults to 10")
    public void user_validate_that_rows_per_page_defaults_to_10() {
        wait.until(ExpectedConditions.visibilityOf(validatingRow.row10Default));
        assertEquals("10", validatingRow.row10Default.getText());
    }

    @When("user change Rows Per Page to {int}")
    public void user_change_rows_per_page_to(Integer rowsPerPage) {
        validatingRow.changeRowsPerPageTo(rowsPerPage);
    }

    @When("user click on {string}")
    public void user_click_on_specific(String users) {

        validatingRow.users.click();
    }

    @Then("user validate that Rows per Page defaults to {int}")
    public void user_validate_that_rows_per_page_defaults_to(Integer expectedRows) {
        wait.until(ExpectedConditions.visibilityOf(validatingRow.row10Default));
        assertEquals("10", validatingRow.row10Default.getText());
    }

    @Then("user validate that it shows only {int}")
    public void user_validate_that_it_shows_only(Integer expectedRows) {
        wait.until(ExpectedConditions.visibilityOf(validatingRow.row5default));
        assertEquals("5", validatingRow.row5default.getText());
    }
}




