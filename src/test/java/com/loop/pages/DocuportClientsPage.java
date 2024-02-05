package com.loop.pages;

import com.loop.utilities.utilities.BrowserUtilities;
import com.loop.utilities.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

    public class DocuportClientsPage extends DocuportBasePage {

        @FindBy(xpath = "//h3[.='Choose account']")
        public WebElement chooseAccountText;

        @FindBy(xpath = "//span[text()='Create new client']")
        public WebElement createNewClient;

        @FindBy(xpath = "//span[text()='Personal']")
        public WebElement personalClient;

        @FindBy(xpath = "//label[text()='First name']/following-sibling::input")
        public WebElement firstNameInput;

        @FindBy(xpath = "//label[text()='Last name']/following-sibling::input")
        public WebElement lastNameInput;

        @FindBy(xpath = "//input[@id='input-4967']")
        public WebElement ownerInput;

        @FindBy(xpath = "//div[@class='v-input--selection-controls__ripple']")
        public WebElement checkBox;

        @FindBy(xpath = "//button[@fdprocessedid='6oipvc']")
        public WebElement saveButton;

        @FindBy(xpath = "//label[text()='Email address']/following-sibling::input")
        public WebElement email;

        @FindBy(xpath = "//label[text()='Advisor']/following-sibling::input")
        public WebElement chooseAdvisor;

        @FindBy(xpath = "//div[text()='advisor advisor']")
        public WebElement advisorAdvisor;

        @FindBy(xpath = "//label[text()='Phone number']/following-sibling::input")
        public WebElement phoneNumber;

        @FindBy(xpath = "//label[text()='Password']/following-sibling::input")
        public WebElement password;

        @FindBy(xpath = "//label[text()='Confirm password']/following-sibling::input")
        public WebElement confirmPassword;

        @FindBy(xpath = "//button[@type='submit']")
        public WebElement saveButton2;

        @FindBy(xpath = "//label[text()='Social Security Number']/following-sibling::input")
        public WebElement ssn;

        @FindBy(xpath = "(//div[@class='v-select__selections'])[1]")
        public WebElement services;

        @FindBy(xpath = "(//div[@class='v-simple-checkbox'])[6]")
        public WebElement checkBoxTesting;

        @FindBy(xpath = "(//div[text()='Bookkeeping'])")
        public WebElement bookkeeping;

        @FindBy(xpath = "//button[@type='submit']")
        public WebElement save;

        @FindBy (xpath = "(//span[text()='UL'])[1]")
        public WebElement logOutMenu;

        @FindBy (xpath = "//span[text()='Log out']")
        public WebElement logOutButton;

        @FindBy (xpath ="//td[@class='text-start'][2]")
        public WebElement userTable;

        public void createNewClient(Map<String, String> inputs) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            createNewClient.click();
            personalClient.click();
            BrowserUtilities.waitForClickable(firstNameInput, 8);
            firstNameInput.sendKeys(inputs.get("first name"), Keys.ENTER);
            lastNameInput.sendKeys(inputs.get("last name"), Keys.ENTER);
            checkBox.click();
            //saveButton2.click();
            BrowserUtilities.waitForClickable(firstNameInput, 8);
            email.sendKeys(inputs.get("email"), Keys.ENTER);
            chooseAdvisor.click();
            BrowserUtilities.waitForClickable(advisorAdvisor, 8);
            advisorAdvisor.click();
            phoneNumber.sendKeys(inputs.get("phone number"), Keys.ENTER);
            password.sendKeys(inputs.get("password"), Keys.ENTER);
            confirmPassword.sendKeys(inputs.get("password"), Keys.ENTER);
            saveButton2.click();
            ssn.sendKeys(inputs.get("ssn"), Keys.ENTER);
            chooseAdvisor.click();
            advisorAdvisor.click();
            services.click();
            bookkeeping.click();
            //  js.executeAsyncScript("window.scrollBy(0,100)");
            checkBoxTesting.click();
            BrowserUtilities.justWait(3000);
            save.click();
        }


    }

