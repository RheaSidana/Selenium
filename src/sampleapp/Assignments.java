package sampleapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sampleapp.implementations.Assignment1;
import sampleapp.implementations.FileUpload;
import sampleapp.implementations.InputTags;
import sampleapp.implementations.MouseAndKeyboardEvents;

import java.awt.*;

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

//        driver.manage().window().maximize();

//        callTestTextBox();
//        callTestCheckBox();
//        callTestRadioButton();
//        callTestDropdown();
//        callMouseAndKeyboardEvents();
//        callAssignment1();
        callFileUploadMethods();

        driver.quit();
    }

    private static void callFileUploadMethods(){
        FileUpload fileUpload = new FileUpload(driver);

//        fileUpload.fileUploadUsingSendKey();
        try{
            fileUpload.fileUploadUsingJSExecutor();
        }
        catch (AWTException ex){

        }
    }

    private static void callAssignment1(){
        Assignment1 assignment = new Assignment1(driver);
        assignment.solution();
    }

    private static void callTestTextBox() {
        InputTags inputTags = new InputTags(driver);
        inputTags.testTextBox();
    }

    private static void callTestCheckBox(){
        InputTags inputTags = new InputTags(driver);
        inputTags.testCheckBox();
    }

    private static void callTestRadioButton(){
        InputTags inputTags = new InputTags(driver);
        inputTags.testRadioButton();
    }

    private static void callTestDropdown(){
        InputTags inputTags = new InputTags(driver);
        inputTags.testDropdown();
    }

    static void callMouseAndKeyboardEvents(){
        MouseAndKeyboardEvents mouseAndKeyboardEvents = new MouseAndKeyboardEvents(driver);
//        mouseAndKeyboardEvents.mouseRightClickOnInputField();
        mouseAndKeyboardEvents.mouseClickOnLogin();
    }
}
