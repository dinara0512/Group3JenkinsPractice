package com.loop.pages;

import com.loop.utilities.utilities.BrowserUtilities;
import com.loop.utilities.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreatingNewClientPage {
    public CreatingNewClientPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//span[.='Clients']")
    public WebElement clientsBtn;

    @FindBy(xpath = "//span[.='Create new client']//span")
    public WebElement createNewClientBtn;
    @FindBy(xpath = "//span[.='Personal']")
    public WebElement personalBtn;
    @FindBy(xpath = "//div[label[.='First name']]//input")
    public WebElement firstNameInp;
    @FindBy(xpath = "//div[label[.='Last name']]//input")
    public WebElement lastNameInp;
    @FindBy(xpath = "//label[.='Create new user']")
    public WebElement checkBoxNewUser;
    @FindBy(xpath = "//div[label[.='Email address']]//input")
    public WebElement emailInp;
    @FindBy(xpath = "//div[.='Batch1 Group3']//div//div")
    public WebElement dropdownOpt;
    @FindBy(xpath = "//div[label[.='Advisor']]//input")
    public WebElement dropdownBtn;
    @FindBy(xpath = "//div[label[.='Phone number']]//input")
    public WebElement phoneNumInp;
    @FindBy(xpath = "//div[label[.='Password']]//input")
    public WebElement passwordInp;
    @FindBy(xpath = "//div[label[.='Confirm password']]//input")
    public WebElement confirmPasswordInp;
    @FindBy(xpath = "//span[.=' Save ']")
    public WebElement saveBtn;
//    @FindBy(xpath = "//div[span[.='Last name']]/following-sibling::div//span")
//    public WebElement lastName;
    public void newClientCreation(List<String> list){
        createNewClientBtn.click();
        personalBtn.click();
        BrowserUtilities.waitForClickable(firstNameInp, 5);
        firstNameInp.sendKeys(list.get(0) + Keys.ENTER);
        BrowserUtilities.waitForClickable(lastNameInp, 5);
        lastNameInp.sendKeys(list.get(1)+ Keys.ENTER);
        BrowserUtilities.waitForVisibility(checkBoxNewUser, 5).click();
        BrowserUtilities.waitForClickable(emailInp, 5);
        emailInp.sendKeys(list.get(2)+ Keys.ENTER);
        dropdownBtn.click();
        BrowserUtilities.waitForVisibility(dropdownOpt, 5).click();
        BrowserUtilities.waitForClickable(phoneNumInp, 5);
        phoneNumInp.sendKeys(list.get(3)+Keys.ENTER);
        BrowserUtilities.waitForClickable(passwordInp, 5);
        passwordInp.sendKeys(list.get(4)+ Keys.ENTER);
        BrowserUtilities.waitForClickable(confirmPasswordInp, 5);
        confirmPasswordInp.sendKeys(list.get(4)+ Keys.ENTER);
        BrowserUtilities.waitForVisibility(saveBtn, 5).click();


    }






}
