package com.loop.pages;


import com.loop.utilities.utilities.BrowserUtilities;
import com.loop.utilities.utilities.ConfigurationReader;
import com.loop.utilities.utilities.DocuportConstants;
import com.loop.utilities.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends DocuportBasePage {

    public void loginAsAdvisor() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        usernameInput.sendKeys(ConfigurationReader.getProperty("advisor_username"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("advisor_password"));
        loginButton.click();
    } public void loginAsAdvisorG1() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        usernameInput.sendKeys(ConfigurationReader.getProperty("advisorg1_username"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("advisorg1_password"));
        loginButton.click();
    }
    public void loginasSupervisor() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        usernameInput.sendKeys(ConfigurationReader.getProperty("supervisor_username"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("supervisor_password"));
        loginButton.click();
    }


    public void loginAsEmployee() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        usernameInput.sendKeys(ConfigurationReader.getProperty("employee_username"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("employee_password"));
        loginButton.click();
    }

    @FindBy(xpath = "//input[@id='input-14']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='input-15']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "*//span[contains(text(),' Continue ')]")
    public WebElement continueButton;

    @FindBy(xpath = "*//span[text()='Batch1 Group3']")
    public WebElement home;
    @FindBy(xpath = "//span[text()=\"Log out\"]")
    public WebElement LogOutButton;

    @FindBy(xpath = "(//div[@class='doc-card--text'])[1]")
    public WebElement recDoc;

    /**
     * logins to docuport
     *
     * @param username
     * @param password
     * @author Ramiz
     */


    public void loginDocuport(String username, String password) {
        BrowserUtilities.waitForInVisibility(usernameInput, DocuportConstants.small);
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        BrowserUtilities.waitForClickable(loginButton, DocuportConstants.small);
        BrowserUtilities.clickWithJS(loginButton);
        BrowserUtilities.justWait(DocuportConstants.small);

        if (continueButton.isDisplayed()) {
            continueButton.clear();
        }
    }

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}