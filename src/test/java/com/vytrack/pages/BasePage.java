package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import jdk.management.resource.internal.inst.DatagramDispatcherRMHooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver= Driver.getDriver();

    protected WebDriverWait wait = new WebDriverWait(driver, 20);

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
