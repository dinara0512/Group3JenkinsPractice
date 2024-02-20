package com.loop.pages;

import com.loop.utilities.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangeNamesPage {
    public ChangeNamesPage(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//div[span[.='First name']]/following-sibling::div//span")
    public WebElement firstName;

    @FindBy(xpath = "//div[span[.='Last name']]/following-sibling::div//span")
    public WebElement lastName;
    @FindBy(xpath = "//span[.='Profile']")
    public WebElement profileBtn;

}
