package com.loop.step_definitions;

import com.loop.pages.DocuportBasePage;
import com.loop.pages.DocuportLoginPage;
import com.loop.utilities.utilities.BrowserUtilities;
import com.loop.utilities.utilities.DocuportConstants;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class NavigateStepDefs {

        DocuportBasePage docuportBasePage = new DocuportBasePage();
        DocuportLoginPage docuportLoginPage = new DocuportLoginPage();
        @Then("user is on home page Docuport {string}")
        public void user_is_on_home_page_docuport(String role) {
            String username = "";
            switch (role){
                case "client":
                    username = DocuportConstants.USERNAME_CLIENT;
                    break;
                case "employee":
                    username = DocuportConstants.USERNAME_EMPLOYEE;
                    break;
                case"advisor":
                    username = DocuportConstants.USERNAME_ADVISOR;
                default:
                    System.out.println("Not a user!");
            }
            docuportLoginPage.loginDocuport(username,DocuportConstants.VALID_PASSWORD);

        }
        @Then("validate left navigator items of Docuport for all {string}")
        public void validate_left_navigator_items_of_docuport_for_all(String role, Map<String, List<String>> navigateItems) {
            List<String> expectedNavigateItems = navigateItems.get(role).stream().filter(item->item != null).toList();
            List <String> actualNavigateItems=docuportBasePage.listOfItems();
            BrowserUtilities.takeScreenshot();
            assertEquals(expectedNavigateItems,actualNavigateItems);
        }

    }


