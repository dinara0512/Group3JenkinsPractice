package com.loop.step_definitions;

import com.loop.pages.LoginPage;
import com.loop.utilities.utilities.BrowserUtilities;
import com.loop.utilities.utilities.ConfigurationReader;
import com.loop.utilities.utilities.DocuportConstants;
import com.loop.utilities.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class LoginStepDefs {


        LoginPage loginPage = new LoginPage();

        @Given("user is on Docuport login page")
        public void user_is_on_docuport_login_page() {
            // String envFromJenkins = System.getenv("env");//will read from Jenkins
            // Driver.getDriver().get(ConfigurationReader.getProperty(envFromJenkins ));
            Driver.getDriver().get(ConfigurationReader.getProperty("env"));
            BrowserUtilities.takeScreenshot();
            BrowserUtilities.waitForClickable(loginPage.loginButton, DocuportConstants.large);
        }

        @When("user enters username for client")
        public void user_enters_username_for_client() {
            loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_CLIENT);
        }

        @When("user enters password for client")
        public void user_enters_password_for_client() {
            loginPage.passwordInput.sendKeys(DocuportConstants.VALID_PASSWORD);

        }

        @When("user clicks login button")
        public void user_clicks_login_button() {
            BrowserUtilities.waitForClickable(loginPage.loginButton, DocuportConstants.small).click();
        }

//    @Then("user should see the home page for client")
//    public void user_should_see_the_home_page_for_client() {
//        Assert.assertTrue(loginPage.homePage.isDisplayed());
//        System.out.println("this is then");
//    }

        @Then("user should see the home page for client")
        public void user_should_see_the_home_page_for_client() {
            BrowserUtilities.takeScreenshot();
        }

        @When("user enters username for employee")
        public void user_enters_username_for_employee() {
            BrowserUtilities.waitForClickable(loginPage.loginButton, DocuportConstants.large);
            loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
        }

        @When("user enters password for employee")
        public void user_enters_password_for_employee() throws InterruptedException {
            loginPage.passwordInput.sendKeys(DocuportConstants.VALID_PASSWORD);
            //  loginPage.loginButton.click();;
        }

        @Then("user should see the home page for employee")
        public void user_should_see_the_home_page_for_employee() {
            System.out.println("this is then");
        }

        @When("user enters username for advisor")
        public void user_enters_username_for_advisor() {

        }

        @When("user enters password for advisor")
        public void user_enters_password_for_advisor() {

        }

        @Then("user should see the home page for advisor")
        public void user_should_see_the_home_page_for_advisor() {

        }


        @When("user enters username for supervisor")
        public void user_enters_username_for_supervisor() {

        }

        @When("user enters password for supervisor")
        public void user_enters_password_for_supervisor() {
        }

        @Then("user should see the home page for supervisor")
        public void user_should_see_the_home_page_for_supervisor() {


        }

        @When("user enters credentials")
        public void user_enters_credentials(Map<String, String> credentials) {

//        for (Map.Entry <String, String> entry : credentials.entrySet() ){
//            String key = entry.getKey();
//            System.out.println("key = " + key);
//            String value = entry.getValue();
//            System.out.println("value = " + value);
//            System.out.println("===================");
//        }

            loginPage.loginDocuport(credentials.get("username"), credentials.get("password"));
        }
    }
