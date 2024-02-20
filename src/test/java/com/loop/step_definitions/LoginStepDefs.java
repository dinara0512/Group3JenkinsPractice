package com.loop.step_definitions;

import com.loop.pages.DocuportBasePage;
import com.loop.pages.LoginPage;
import com.loop.utilities.utilities.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class LoginStepDefs {


    LoginPage loginPage = new LoginPage();
    DocuportBasePage basePage = new DocuportBasePage();

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

    @When("user enters their username for {string}")
    public void user_enters_their_username_for(String user_type) {
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty(user_type + "_username"));
    }

    @When("user enters their password for {string}")
    public void user_enters_their_password(String password_type) {
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty(password_type + "_password"));
    }

    @When("user clicks the login button for {string}")
    public void user_clicks_the_login_button(String user_type) {
        loginPage.loginButton.click();
        switch (user_type) {
            case "client":
                BrowserUtilities.waitForClickable(loginPage.continueButton, DocuportConstants.extraSmall);
                loginPage.continueButton.click();
        }
    }

    @Then("user should see the home page for {string}")
    public void user_should_see_the_home_page_for(String expected) {
        String updatedUsertype = expected.substring(0, 1).toUpperCase();
        updatedUsertype += expected.substring(1) + " ";

        basePage.logo.click();
        basePage.profile.click();
        String actual = getElement(updatedUsertype).getText();

        Assert.assertTrue("Expected user type is not matching to logged user!", expected.equalsIgnoreCase(actual));

    }

    public static WebElement getElement(String text) {
        String xpath = "//span[.='" + text + "']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    @Then("user should logout from Docuport System")
    public void user_should_logout_from_docuport_system() {
        basePage.logo.click();
        basePage.logOutButton.click();
        BrowserUtilities.waitForVisibility(loginPage.loginButton,DocuportConstants.small);

    }
}
