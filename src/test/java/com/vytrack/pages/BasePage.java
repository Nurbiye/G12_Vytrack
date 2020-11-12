package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import jdk.management.resource.internal.inst.DatagramDispatcherRMHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    protected WebDriver driver= Driver.getDriver();

    protected WebDriverWait wait = new WebDriverWait(driver, 20);

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    /**
     * loader mask -  is css/JavaScript animation that is not allowing driver to make any interactions with a webpage.
     * There is 5 web-elements that are related tom this animation.
     * We use List to store them and css locator to find.
     */
    @FindBy(css = "[class='loader-mask']")
    protected List<WebElement> loaderMask;

    /**
     * This method is responsible for a creation of Dynamic xpath for 2 buttons. You can specify them by giving this method 2 arguments below:
     * @param global - is a String responsible for: Dashboards, Fleet, Customers, Sales, Activities, Marketing, Reports & Segments, System menu options on the navigation bar
     * @param subMenu - is a String responsible for any other submenus from the options above.
     * In this method we have different types of wait:
     *    invisibilityOfAllElements(loaderMask) - we will wait until loader-mask animation will disappear
     *    presenceOfElementLocated(element) - we will wait until the element will be present, very important wait for the drop-downs
     *    And also, because we use  BrowserUtils.clickOnElement - we wait until element will be clickable.
     *    This approach will avoid a lot of exceptions and with this kind of logic your framework will be very stable
     */
    public void navigateTo(String global,String subMenu){
        String menuXpath ="//span[.='%s']";
        String globalMenuXpath="(//span[contains(text(), '%s')])[1]";

        wait.until(ExpectedConditions.invisibilityOfAllElements(loaderMask));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(globalMenuXpath,global))));
        BrowserUtils.clickOnElement(driver.findElement(By.xpath(String.format(globalMenuXpath,global))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(menuXpath,subMenu))));
        BrowserUtils.clickOnElement(driver.findElement(By.xpath(String.format(menuXpath,subMenu))));

    }






}
