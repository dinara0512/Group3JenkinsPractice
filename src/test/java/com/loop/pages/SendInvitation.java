package com.loop.pages;

import com.loop.utilities.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendInvitation {


    @FindBy(xpath = "//div[@class='v-avatar primary']/span")
    public WebElement avatar;

    @FindBy(xpath = "//span[text()='Send invitation']")
    public WebElement sendInvitation;

    @FindBy(xpath = "//input[@type='text'] ")
    public WebElement emailInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement send;

    public SendInvitation() {
        PageFactory.initElements(Driver.getDriver(), this);
    }







}
