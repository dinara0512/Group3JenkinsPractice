package com.loop.step_definitions;

import com.loop.pages.LoginPage;
import com.loop.pages.SendInvitation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AdvisorSendInvitation {
    LoginPage LoginPage = new LoginPage();
    SendInvitation sendInvitation = new SendInvitation();

    @Given("login as {string}")
    public void login_as(String advisor) {
        LoginPage.loginAsAdvisor();
    }
    @Then("click on Avatar")
    public void click_on_avatar() {
        sendInvitation.avatar.click();
    }
    @Then("Click send invitation")
    public void click_send_invitation() {
       sendInvitation.sendInvitation.click();
    }
    @Then("add email {string}")
    public void add_email(String email) {
        sendInvitation.emailInput.sendKeys(email);
    }
    @Then("click send")
    public void click_send() {
        sendInvitation.send.click();
    }



}
