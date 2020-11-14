package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import javax.xml.xpath.XPath;
import java.util.List;

public class CalendarEvents extends BasePage {

    @FindBy(xpath = "//div[contains (text(),'Title')]")
    private WebElement titleManageFiltersOption;

    @FindBy(xpath = "(//div[@class='value-field-frame']/input)[1]")
    private WebElement textInputFilterManageTitle;

    @FindBy(xpath = "//div[@class='value-field-frame']/button")
    private WebElement updateButtonFilterManageTitle;

    @FindBy(xpath = "//a[.='...']")
    private WebElement threeDotButton;

    @FindBy(xpath = "//div[@class='dropdown-menu']//input[@type='checkbox']")
    private List<WebElement> filterCheckboxList;


    protected String threeDotOptionsXpath = "//a[contains(@class,'mode-icon-only')][@title='%s']";
    /**
     * Dynamic locator that is responsible for Filters, Refresh, Reset buttons on the grid
     * All you need to do is: driver.findElement(By.xpath(String.format(gridButtonsXpath,"Word")))
     * replace "Word" with a desired button name.
     */
    protected String gridButtonsXpath = "//a[@title='%s']";
    protected String gridOptionsButton = "//a[@title='%s']";
    protected String checkboxFilterXpath = "//label[.='%s']//..//..//input[@type='checkbox']";




    public void testersMeetingCalendarEvent(String title){
        BrowserUtils.clickOnElement(driver.findElement(By.xpath(String.format(gridButtonsXpath,"Filters"))));
        BrowserUtils.clickOnElement(titleManageFiltersOption);
        BrowserUtils.enterText(textInputFilterManageTitle,title);
        BrowserUtils.clickOnElement(updateButtonFilterManageTitle);
    }

    /**
     * In this method we're creating the Action object, because we need to hover the thee dots
     * Otherwise, three dots options, such as: view, edit or delete will be not displayed and assertion will fail
     */
    public void hoverThreeDot(){
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(threeDotButton).perform();
    }

    /**
     * This method will take 3 parameters and return the boolean value(true/false)
     * @param view - button that will be located by dynamic locator: %s will be replaced with "String view" parameter
     * @param edit - button that will be located by dynamic locator: %s will be replaced with "String edit" parameter
     * @param delete - button that will be located by dynamic locator: %s will be replaced with "String delete" parameter
     * @return boolean value for the assertion
     */
    public boolean threeDotOptionVerification(String view, String edit, String delete){
        WebElement viewThreeDotOption = driver.findElement(By.xpath(String.format(threeDotOptionsXpath,view)));
        WebElement editThreeDotOption = driver.findElement(By.xpath(String.format(threeDotOptionsXpath,edit)));
        WebElement deleteThreeDotOption = driver.findElement(By.xpath(String.format(threeDotOptionsXpath,delete)));

        return  viewThreeDotOption.isDisplayed()&& editThreeDotOption.isDisplayed()&& deleteThreeDotOption.isDisplayed();
    }


    @FindBy(xpath = "//a[@title='Create Calendar event']")
    private WebElement createCalendarEventBtn;

    @FindBy(xpath ="//a[@title='Cancel']")
    private WebElement cancelBtnUnderCreateEventBtn;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    private WebElement AllCalendarEventTitle;

    public void clickCreateCalendarEventBtn(){
        BrowserUtils.clickOnElement(createCalendarEventBtn);
    }

    public void clickCancelBtn(){
        BrowserUtils.clickOnElement(cancelBtnUnderCreateEventBtn);
    }
    public String getAllCalendarEventTitle(){

        return AllCalendarEventTitle.getText().trim();
    }


    //TC3
    @FindBy(xpath = "//a[@title='Create Calendar event']")
    private WebElement createCalendarEventButton;

    @FindBy(xpath = "//a[@class='btn-success btn dropdown-toggle']")
    private WebElement expandSaveAndCloseButton;

   protected String saveAndCloseDropdownOption = "//li/button[contains(text(),'%s')]";


     public void clickCreateCalendarEventButton(){
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

     public void clickOnGridOptionsButton(String option){
        BrowserUtils.clickOnElement( driver.findElement(By.xpath(String.format(gridOptionsButton,option))));
     }
    public void GridSettingFilterCheckbox(String filter){
        wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(By.xpath(String.format(checkboxFilterXpath, filter)))));
        BrowserUtils.clickOnElement(Driver.getDriver().findElement(By.xpath(String.format(checkboxFilterXpath, filter))));
    }
    public boolean titleFilterVerification(){
        String expectedResult = "renderable";
        String actualResult = Driver.getDriver().findElement(By.xpath("(//label[.='Title']//..//..)[1]")).getAttribute("class");
        return expectedResult.equals(actualResult);
    }


    @FindBy(xpath = "//input[@data-name='recurrence-repeat']")
    private WebElement repeatCheckbox;

    @FindBy(xpath = "//input[@value='monday']")
    private WebElement mondayCheckBox;

    @FindBy(xpath = "//input[@value='friday']")
    private WebElement fridayCheckBox;


    public void clickRepeatCheckbox(){
        BrowserUtils.clickOnElement(repeatCheckbox);
    }

    public void selectFromRepeatsDropdown() {
        Select selectFromRepeatsDropdown = new Select(driver.findElement(By.xpath("//select[@data-name='recurrence-repeats']")));
        selectFromRepeatsDropdown.selectByVisibleText("Weekly");
    }

    public void clickOnMondayCheckbox(){
        BrowserUtils.clickOnElement(mondayCheckBox);
    }

    public void clickOnFridayCheckbox(){
        BrowserUtils.clickOnElement(fridayCheckBox);
    }

    public void verifyMondayAndFridayDisplayed(){
        mondayCheckBox.isDisplayed();
        fridayCheckBox.isDisplayed();
    }

    public boolean displayedMessageVerification(){
        String expectedMessage = "Weekly every 1 week on Monday, Friday";
        String actualMessage = Driver.getDriver().findElement(By.xpath("//div[@data-name='recurrence-summary']")).getText();
        return expectedMessage.equals(actualMessage);
    }



}
