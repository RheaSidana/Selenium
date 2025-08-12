package sampleapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sampleapp.implementations.MouseAndKeyboardEvents;

public class Assignments {
    private static WebDriver driver;

    private static void setChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    private static void setFirefoxDriver(){
        System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.36.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    public static void main(String[] args) {
//        setChromeDriver();
        setFirefoxDriver();

        MouseAndKeyboardEvents mouseAndKeyboardEvents = new MouseAndKeyboardEvents(driver);
//        mouseAndKeyboardEvents.mouseRightClickOnInputField();
        mouseAndKeyboardEvents.mouseClickOnLogin();

        driver.quit();
    }
}
