package com.loop.pages;

import com.loop.utilities.utilities.BrowserUtilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DocuportAdv1099Page extends DocuportClientsPage{

    private static final Logger LOG = LogManager.getLogger();

    @FindBy(xpath = "//span[.='1099 Form']" )
    public WebElement form1099Btn;
    @FindBy(xpath = "//span[.='Export data']")
    public WebElement exportDataBtn;
    @FindBy(xpath = "//div[@class='v-select__selections']")
    public WebElement dropdownelem;
    @FindBy(xpath = "//div[.='Current year (2023)']//div//div")
    public WebElement currentYearOpt;
    @FindBy(xpath = "//span[.='Contractor list has been exported successfully']")
    public WebElement popUpMessage;

    public void advClickButton(String button){
        switch (button.toLowerCase()) {

            case "1099form":
                BrowserUtilities.waitForVisibility(form1099Btn,5).click();
                break;
            case "exportdata":
                BrowserUtilities.waitForVisibility(exportDataBtn,5).click();
                break;

            default:
                LOG.error("No such " + button + "exists");
                throw new IllegalArgumentException();

        }

    }



}
