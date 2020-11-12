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

    @FindBy(css = "[class='loader-mask']")
    protected List<WebElement> loaderMask;

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
