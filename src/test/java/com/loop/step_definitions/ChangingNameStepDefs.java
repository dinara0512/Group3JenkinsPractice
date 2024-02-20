package com.loop.step_definitions;

import com.loop.pages.ChangeNamesPage;
import com.loop.utilities.db_utils.DB_Utility;
import com.loop.utilities.utilities.BrowserUtilities;
import com.loop.utilities.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.ResultSet;

import static org.junit.Assert.assertEquals;

public class ChangingNameStepDefs {


    ChangeNamesPage changeNames = new ChangeNamesPage();

    @Then("click Profile button")
    public void click_profile_button() {
        BrowserUtilities.waitForVisibility(changeNames.profileBtn, 5).click();
    }
    @When("validates First name is {string}, Last name is {string}")
    public void validates_first_name_is_last_name_is(String firstName, String lastName) {
        Driver.getDriver().navigate().refresh();
        assertEquals("Actual does NOT match expected", firstName, changeNames.firstName.getText());
        assertEquals("Actual does NOT match expected", lastName, changeNames.lastName.getText());
    }
    @When("change names to {string}, {string} in DB")
    public void change_names_to_in_db(String firstName, String lastName) {
        DB_Utility.createConnection("jdbc:postgresql://35.222.62.70:5432/postgres", "tstadmin", "hoxBam-jaghuj-7cette");
        ResultSet rs = DB_Utility.runQuery("update document.users set last_name = '"+lastName+"', first_name = '"+firstName+"' where email_address = 'b1g3_advisor@gmail.com'");
        rs = DB_Utility.runQuery("update identity.users set last_name = '"+lastName+"', first_name = '"+firstName+"' where email_address = 'b1g3_advisor@gmail.com'");



    }

}
