package com.loop.pages;

import com.loop.utilities.utilities.BrowserUtilities;
import com.loop.utilities.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DocupotAdvisorReceivedDocsPage extends DocuportClientsPage{

    private static final Logger LOG = LogManager.getLogger();

    @FindBy(xpath = "//tr[1]/td//div[@class='v-data-table__checkbox v-simple-checkbox']")
    public WebElement checkBox;

    @FindBy(xpath = "//span[.='Change status']")
    public WebElement changeStatus;

    @FindBy(xpath = "//div[@role='radiogroup']//div[3]")
    public WebElement doneRadio;

    @FindBy(xpath = "//span[.=' Save ']")
    public WebElement saveBtn;

    @FindBy(xpath = "//tr[1]//td[7]//span//span")
    public WebElement statusDocs;

    @FindBy(xpath = "//table")
    public WebElement table;


    @FindBy(xpath = "//span[.='Received docs']")
    public WebElement receivedDocs;






    public void advClickButton(String button){
        switch (button.toLowerCase()) {

            case "receiveddocs":
                BrowserUtilities.waitForVisibility(receivedDocs,5).click();
                //invitationButton.click();
                break;
            case "checkbox":
                BrowserUtilities.waitForVisibility(checkBox,5).click();
                break;
            case "changestatus":
                BrowserUtilities.waitForVisibility(changeStatus,5).click();
                break;
            case "doneradio":
                BrowserUtilities.waitForClickable(doneRadio,5).click();
                break;
            case "savebtn":
                BrowserUtilities.waitForVisibility(saveBtn,5).click();
                break;

            default:
                LOG.error("No such " + button + "exists");
                throw new IllegalArgumentException();

        }

    }





}

