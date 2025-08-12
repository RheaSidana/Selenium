package sampleapp.implementations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class MouseAndKeyboardEvents {

    private WebDriver driver;

    public MouseAndKeyboardEvents(WebDriver driver) {
        this.driver = driver;
    }

    private void hitUrl(){
        // website url to hit
        String url = "https://test.salesforce.com/";

        // hit the url
        driver.get(url);
    }

    private Actions initActions(){
        return new Actions(driver);
    }

    private void sleepForTwoSeconds(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void mouseRightClickOnInputField() {
        hitUrl();

        // WebElement to target
        WebElement webElement = driver.findElement(By.xpath("//input[contains(@type, 'email')]"));

        // action variable initialisation
        Actions actions = initActions();

        // build and perform the event
        actions.moveToElement(webElement).contextClick().build().perform();
    }

    public void mouseClickOnLogin(){
        hitUrl();

        WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
        WebElement username = driver.findElement(By.xpath("//input[contains(@type, 'email')]"));
        WebElement password = driver.findElement(By.xpath("//*[@id='password']"));

        username.sendKeys("rheaS");
        sleepForTwoSeconds();
        password.sendKeys("apsk@34");
        sleepForTwoSeconds();

        initActions().click(login).build().perform();
        sleepForTwoSeconds();
    }
}
