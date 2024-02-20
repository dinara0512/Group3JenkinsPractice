package com.loop.pages;

import com.loop.utilities.utilities.BrowserUtilities;
import com.loop.utilities.utilities.DocuportConstants;

public class ValidationPage extends LoginPage {
    public void loginsDocuport(String username, String password){
        BrowserUtilities.waitForVisibility(usernameInput, DocuportConstants.small);
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
        if (BrowserUtilities.waitForVisibility(continueButton, DocuportConstants.small).isDisplayed()){
            //continueButton.click();
        }
    }

}
