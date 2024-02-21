package com.loop.step_definitions;

import com.loop.pages.CreatingNewClientPage;
import com.loop.utilities.db_utils.DB_Utility;
import com.loop.utilities.utilities.BrowserUtilities;
import com.loop.utilities.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CreatingNewClientStepDefs {


    CreatingNewClientPage creatingPage = new CreatingNewClientPage();

    @When("user creates new client")
    public void user_creates_new_client(List<String> credentials) {
        creatingPage.newClientCreation(credentials);


    }

    @When("user clicks Client")
    public void user_clicks_client() {
        BrowserUtilities.waitForVisibility(creatingPage.clientsBtn, 5).click();


    }

    @Then("user validates client is created in DB {string}")
    public void user_validates_client_is_created_in_db(String email) throws SQLException {
        String expected = "User";
        DB_Utility.createConnection("jdbc:postgresql://35.222.62.70:5432/postgres", "tstadmin", "hoxBam-jaghuj-7cette");
        ResultSet rs = DB_Utility.runQuery("select * from identity.users where email_address = '"+email+"'");
        //System.out.println(rs.getString("last_name"));
        if(rs.next()) {
            assertEquals("Expected does NOT match actual", expected, rs.getString("last_name"));
        }



    }

    @Then("user delete created client in DB {string}")
    public void user_delete_created_client_in_db(String email) throws SQLException {
        DB_Utility.createConnection("jdbc:postgresql://35.222.62.70:5432/postgres", "tstadmin", "hoxBam-jaghuj-7cette");

        ResultSet rs = DB_Utility.runQuery("delete from document.users where email_address = '"+email+"'");


        rs = DB_Utility.runQuery("delete from identity.users where email_address = '"+email+"'");



    }


}



