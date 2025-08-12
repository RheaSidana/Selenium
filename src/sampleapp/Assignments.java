package sampleapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sampleapp.implementations.InputTags;
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

    private static void setEdgeDriver(){
        System.setProperty("webdriver.edge.driver", "E:\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    public static void main(String[] args) {
        setChromeDriver();
//        setFirefoxDriver();
//        setEdgeDriver();

        driver.manage().window().maximize();

        callTestTextBox();
//        callMouseAndKeyboardEvents();

        driver.quit();
    }

    private static void callTestTextBox() {
        InputTags inputTags = new InputTags(driver);
//        inputTags.testTextBox();
//        inputTags.testCheckBox();
//        inputTags.testRadioButton();
        inputTags.testDropdown();
    }

    static void callMouseAndKeyboardEvents(){
        MouseAndKeyboardEvents mouseAndKeyboardEvents = new MouseAndKeyboardEvents(driver);
//        mouseAndKeyboardEvents.mouseRightClickOnInputField();
        mouseAndKeyboardEvents.mouseClickOnLogin();
    }
}
