package com.loop.pages;

import com.loop.utilities.utilities.BrowserUtilities;
import com.loop.utilities.utilities.DocuportConstants;
import com.loop.utilities.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DocuportBasePage {

        public DocuportBasePage() {
            PageFactory.initElements(Driver.getDriver(),this);
        }

        private static final Logger LOG = LogManager.getLogger();





        @FindBy(xpath ="//span[.='Home']")
        public WebElement homeButton;

//    public void clickButton(String button) {
//        switch (button.toLowerCase()) {
//            case "continue":
//                continueButton.click();
//                break;
//            case "home":
//                homeButton.click();
//                break;
//            default:
//                LOG.error("No such " + button + "exists");
//                throw new IllegalArgumentException();
//        }
//    }

        @FindBy(xpath = "//span[.=' Continue ']")
        public WebElement continueButton;


        public static String getElementText(String text){
            String xpath = "//*[normalize-space()='"+ text + "']";
            return Driver.getDriver().findElement(By.xpath(xpath)).getText();
        }


        public void clickButton(String button){
            switch (button.toLowerCase()) {
                case "continue":
                    continueButton.click();
                    break;
                case "home":
                    WebElement homeButton = Driver.getDriver().findElement(By.xpath("//span[.='Home']"));
                    BrowserUtilities.waitForVisibility(homeButton,10);
                    BrowserUtilities.clickWithJS(homeButton);
                    //homeButton.click();
                    break;
                case "invitations":
                    WebElement invitationButton = Driver.getDriver().findElement(By.xpath("//span[.='Invitations']"));
                    BrowserUtilities.waitForVisibility(invitationButton,5);
                    BrowserUtilities.clickWithJS(invitationButton);
                    //invitationButton.click();
                    break;
                default:
                    LOG.error("No such " + button + "exists");
                    throw new IllegalArgumentException();
            }

        }


        public static WebElement getElement(String text){
            String xpath = "//*[normalize-space()='"+ text + "']";
            return Driver.getDriver().findElement(By.xpath(xpath));
        }
        @FindBy (xpath ="//span[text()='Batch1 Group3']")
        public WebElement logo;

        @FindBy (xpath = "//span[.='Profile']")
        public WebElement profile;

        @FindBy (xpath = "//span[.='Log out']")
        public WebElement logOutButton;
         @FindBy (xpath = "//span[.='Client ']")
         public WebElement user_type;


        @FindBy (xpath = "//div[@class='v-data-footer__pagination']")
        public WebElement totalResultCount; //1-10 of 869

        @FindBy (xpath = "//span[.='Users']")
        public WebElement usersMenu;

        @FindBy (xpath = "//span[text()='Clients']")
        public WebElement clientsMenu;
        @FindBy (xpath = "//span[@class='v-btn__content']//span[.='Search']")
        public WebElement search;


        @FindBy (xpath ="//label[text()='Email address']")
        public WebElement emailSearchWindow;


        @FindBy (xpath ="//button[@type='submit']")
        public WebElement searchButton;


        public void searchForTheClient(Map<String, String> inputs) {
            search.click();
            emailSearchWindow.sendKeys(inputs.get("email"), Keys.ENTER);
            searchButton.click();
        }





        @FindBy (xpath = "//div[@class='menu mr-2']//a")
        static List<WebElement> menuList;
        public static void navigateMenu(String menuName) {
            for (WebElement each : menuList) {
                if (each.getText().equals(menuName)) {
                    each.click();
                }
            }
        }
        public List<String> listOfItems () {
            BrowserUtilities.waitForVisibility(logo, DocuportConstants.large);
            List<WebElement> menu = new ArrayList<>();
            String xPath = "//div[@role ='listbox']/a/div/following-sibling::div/div/span";
            menu = Driver.getDriver().findElements(By.xpath(xPath));
            List<String> StringSidelist = new ArrayList<>();
            for (WebElement each : menu) {
                StringSidelist.add(each.getText());
            }
            return StringSidelist;
        }
    }



