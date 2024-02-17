package com.loop.step_definitions;

import com.loop.pages.DocupotAdvisorReceivedDocsPage;
import com.loop.pages.LoginPage;
import com.loop.utilities.utilities.BrowserUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

import static org.junit.Assert.assertEquals;

public class AdvisorFunctionValidationStepDefs {


    LoginPage loginPage = new LoginPage();
    DocupotAdvisorReceivedDocsPage advisorPage = new DocupotAdvisorReceivedDocsPage();


    @When("user login as a {string}")
    public void user_login_as_a(String string) {
        loginPage.loginAsAdvisorG1();
    }


    @Then("user validates status is {string}")
    public void user_validates_status_is_done(String status) {
// This part is suppose to validate each Doc status
//        List<WebElement> rows = advisorPage.table.findElements(By.xpath("//tr//td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td//span//span[@class='v-chip__content']"));
//
//                for (WebElement each: rows){
//            System.out.println("Status of Document: " + each.getText());
//            System.out.println();
//            assertEquals("Expected does NOT match actual",each.getText(), status);
//        }

//Single Doc status validation
        assertEquals("Expected does NOT match actual",advisorPage.statusDocs.getText(), status);
        BrowserUtilities.takeScreenshot();

    }

    @When("user adv clicks {string} button")
    public void user_adv_clicks_button(String button) {
        advisorPage.advClickButton(button);
    }

}
