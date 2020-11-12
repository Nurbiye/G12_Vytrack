package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Driver {
    private Driver(){ };
    private static WebDriver driver;

    public static WebDriver getDriver(){

        if (driver==null){
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "remote-chrome":
                    try{
                        //DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        ChromeOptions chromeOptions = new ChromeOptions(); //chrome option is child of Desirecapabilities interface's
                        URL gridUrl = new URL("http://18.208.194.45:4444/wd/hub");
                        driver = new RemoteWebDriver(gridUrl,chromeOptions);
                    }catch( Exception e){
                        e.printStackTrace();
                    }
                    break;


                default:
                    throw new RuntimeException("No such a browser yet!");
            }

        }

        return driver;
    }



    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
