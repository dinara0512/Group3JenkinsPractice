package com.loop.pages;

import com.loop.utilities.utilities.BrowserUtilities;
import com.loop.utilities.utilities.DocuportConstants;
import com.loop.utilities.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath = "//input[@id='input-14']")
    public WebElement loginInput;

    @FindBy(xpath = "//input[@id='input-15']")
    public WebElement passwordInput;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//button[@type='submit']//span")
    public WebElement continueButton;


    @FindBy(xpath = "//span[@class='body-1 white--text']")
    public WebElement homePage;


    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**
     * logins to docuport
     *
     * @param username
     * @param password
     * @author nsh
     */


    public void loginDocuport(String username, String password){
        //BrowserUtilities.waitForVisibility(loginInput, DocuportConstants.small);
        loginInput.clear();
        loginInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
        if (BrowserUtilities.waitForVisibility(continueButton, DocuportConstants.small).isDisplayed()){
            continueButton.click();
        }
    }

    public void clickCategory (String category) throws InterruptedException {
        Thread.sleep(5000);
        Driver.getDriver().findElement(By.xpath("//a[contains(.,'" + category + "')]")).click();

    }

}
