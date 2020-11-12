package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    @FindBy(id="prependedInput")
    private WebElement username;

    @FindBy(id="prependedInput2")
    private WebElement password;

    @FindBy(id="_submit")
    private WebElement submitBtn;

    public void login(String position){
        String usernameValue = "";
        String passwordValue = ConfigurationReader.getProperty("password");

        if (position.equals("store manager")){
            usernameValue = ConfigurationReader.getProperty("storemanager.username");
        }else if(position.equals("sales manager")){
            usernameValue = ConfigurationReader.getProperty("salesmanager.username");
        }else if(position.equals("driver")){
            usernameValue = ConfigurationReader.getProperty("driver.username");
        }else{
            throw new IllegalArgumentException("Wrong Input!");
        }

        BrowserUtils.enterText(username,usernameValue);
        BrowserUtils.enterText(password,passwordValue);

        BrowserUtils.clickOnElement(submitBtn);
    }

    public boolean getTitle(String title){
        wait.until(ExpectedConditions.titleContains(title));
        return Driver.getDriver().getTitle().equals(title);
    }





}
