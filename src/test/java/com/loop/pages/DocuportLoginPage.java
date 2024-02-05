package com.loop.pages;

import com.loop.utilities.utilities.BrowserUtilities;
import com.loop.utilities.utilities.ConfigurationReader;
import com.loop.utilities.utilities.DocuportConstants;
import com.loop.utilities.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DocuportLoginPage extends DocuportBasePage {

    @FindBy(className = "v-btn__content")
    public WebElement loginButton;
    @FindBy(xpath = "//input[@id='input-14']")
    public WebElement loginInput;

    @FindBy (xpath = "//label[text()='Username or email']/following-sibling::input")
    public WebElement userNameLogin;

    @FindBy (xpath = "//label[text()='Password']/following-sibling::input")
    public WebElement userPassword;


    @FindBy(xpath = "//input[@id='input-15']")
    public WebElement passwordInput;


    @FindBy(xpath = "//button[@type='submit']//span")
    public WebElement continueButton;

    @FindBy(xpath = "//span[@class='body-1 white--text']")
    public WebElement homePage;

    @FindBy(xpath = "//div[@class='v-list-item__title']//span")
    List<WebElement> allOptions;

    public List<String> getCategory() throws InterruptedException {
        Thread.sleep(5000);
        List<String> actual = new ArrayList<>();
        for (WebElement each : allOptions) {
            Thread.sleep(5000);
            actual.add(each.getText());
            Thread.sleep(5000);
        }
        return actual;
    }

    DocuportBasePage docuportBasePage = new DocuportBasePage();


    public void login(String userType) {

        String username = ConfigurationReader.getProperty(userType + "_username");
        String password = ConfigurationReader.getProperty(userType + "_password");


        loginInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        if (BrowserUtilities.waitForVisibility(continueButton, DocuportConstants.small).isDisplayed()) {
            continueButton.click();
        }
    }


    public void loginDocuport(String username, String password) {
        //BrowserUtilities.waitForVisibility(loginInput, DocuportConstants.small);
        loginInput.clear();
        loginInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
//        if (BrowserUtilities.waitForVisibility(continueButton, DocuportConstants.small).isDisplayed()) {
//            continueButton.click();
        }

    @FindBy(xpath = "//input[@id='input-14']")
    public WebElement usernameInput;

//    @FindBy(xpath = "//input[@id='input-15']")
//    public WebElement passwordInput;
//
//    @FindBy(xpath = "//button[@type='submit']")
//    public WebElement loginButton;
//
//    @FindBy(xpath = "//button[@type='submit']//span")
//    public WebElement continueButton;

    @FindBy(xpath = "Customize Toolbar...")
    public WebElement loginText;

    public static String getElementText(String text){
        String xpath = "//*[normalize-space()='"+ text + "']";
        return Driver.getDriver().findElement(By.xpath(xpath)).getText();
    }

}



//public void navigateModule(String moduleName) {
//    for (WebElement each : allOptions) {
//        if (each.getText().equals(moduleName)) {
//            each.click();
//        }
//
//
//    }
//}
//}