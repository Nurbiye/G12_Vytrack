package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;

public class CalendarEvents extends BasePage {

    @FindBy(xpath = "//a[@title='Filters']")
    private WebElement filtersGridButton;

    @FindBy(xpath = "//div[contains (text(),'Title')]")
    private WebElement titleManageFiltersOption;

    @FindBy(xpath = "(//div[@class='value-field-frame']/input)[1]")
    private WebElement textInputFilterManageTitle;

    @FindBy(xpath = "//div[@class='value-field-frame']/button")
    private WebElement updateButtonFilterManageTitle;

    @FindBy(xpath = "//a[.='...']")
    private WebElement threeDotButton;

    protected String threeDotOptionsXpath = "//a[contains(@class,'mode-icon-only')][@title='%s']";


    public void testersMeetingCalendarEvent(String title){

        BrowserUtils.clickOnElement(filtersGridButton);
        BrowserUtils.clickOnElement(titleManageFiltersOption);
        BrowserUtils.enterText(textInputFilterManageTitle,title);
        BrowserUtils.clickOnElement(updateButtonFilterManageTitle);

    }

    public void hoverThreeDot(){
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(threeDotButton).perform();
    }

    public boolean threeDotOptionVerification(String view, String edit, String delete){

        WebElement viewThreeDotOption = driver.findElement(By.xpath(String.format(threeDotOptionsXpath,view)));
        WebElement editThreeDotOption = driver.findElement(By.xpath(String.format(threeDotOptionsXpath,edit)));
        WebElement deleteThreeDotOption = driver.findElement(By.xpath(String.format(threeDotOptionsXpath,delete)));

        return  viewThreeDotOption.isDisplayed()&& editThreeDotOption.isDisplayed()&& deleteThreeDotOption.isDisplayed();

    }

    @FindBy(xpath = "//a[@title='Create Calendar event']")
    private WebElement createCalendarEventButton;

    @FindBy(xpath = "//a[@class='btn-success btn dropdown-toggle']")
    private WebElement expandSaveAndCloseButton;

   protected String saveAndCloseDropdownOption = "//li/button[contains(text(),'%s')]";





     public void clickCreateCalendarEventButton(){
        // BrowserUtils.wait(2);
        // wait.until(ExpectedConditions.visibilityOf(createCalendarEventButton));
         wait.until(ExpectedConditions.invisibilityOfAllElements(loaderMask));
         BrowserUtils.clickOnElement(createCalendarEventButton);
     }

     public void clickExpandSaveAndCloseButton(){
         BrowserUtils.clickOnElement(expandSaveAndCloseButton);
     }

     public boolean optionsVerification(String SaveAndClose, String SaveAndNew, String Save){

         WebElement SaveAndCloseVerification = driver.findElement(By.xpath(String.format(saveAndCloseDropdownOption,SaveAndClose)));
         WebElement SaveAndNewVerification = driver.findElement(By.xpath(String.format(saveAndCloseDropdownOption,SaveAndNew)));
         WebElement SaveVerification = driver.findElement(By.xpath(String.format(saveAndCloseDropdownOption,Save)));

        return SaveAndCloseVerification.isDisplayed() && SaveAndNewVerification.isDisplayed() && SaveVerification.isDisplayed();


     }




}
