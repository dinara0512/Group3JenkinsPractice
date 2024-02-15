package com.loop.pages;

import com.loop.utilities.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ValidatingRow {

    @FindBy(xpath = "//div[@class='v-select__selection v-select__selection--comma' and text()='5']")
    public WebElement row5default;
    @FindBy(xpath = "//span[@class='body-1' and text()='Users']")
    public WebElement users;

    @FindBy(xpath = "//div[@class='v-list-item__title' and text()='5']")
    public WebElement rowTo5;

    @FindBy(xpath = "//div[@class='v-select__selection v-select__selection--comma' and text()='10']")
    public WebElement row10Default;

    @FindBy(xpath = "//span[@class='body-1' and text()='Leads']")
    public WebElement leads;

    public void changeRowsPerPageTo(int rowsPerPage) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(row10Default)).click();
        wait.until(ExpectedConditions.elementToBeClickable(rowTo5)).click();
        assertEquals(String.valueOf(rowsPerPage), row5default.getText());
    }


    public ValidatingRow() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
