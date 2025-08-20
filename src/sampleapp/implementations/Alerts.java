package sampleapp.implementations;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Alerts {
    private WebDriver driver;

    public Alerts(WebDriver driver) {
        this.driver = driver;
    }

    private void sleepForTwoSeconds(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void hitUrl(){
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
    }

    public void simpleAlert(){
        hitUrl();
        WebElement alertInitBtn = driver.findElement(By.xpath("//button[contains(@id, 'alertBox')]"));

        alertInitBtn.click();
        Alert simpleAlert = driver.switchTo().alert();

        System.out.println("alert text: "+ simpleAlert.getText());
        sleepForTwoSeconds();

        simpleAlert.accept(); // pressing OK btn

        WebElement outputDiv = driver.findElement(By.xpath("//div[@id='output']"));
        System.out.println("alert output: "+ outputDiv.getText());
        sleepForTwoSeconds();
    }

    public void confirmationAlertAccept(){
        hitUrl();
        WebElement alertInitBtn = driver.findElement(By.xpath("//button[contains(@id, 'confirmBox')]"));

        alertInitBtn.click();
        Alert confirmationAlert = driver.switchTo().alert();

        System.out.println("alert text: "+ confirmationAlert.getText());
        sleepForTwoSeconds();

        confirmationAlert.accept();

        WebElement outputDiv = driver.findElement(By.xpath("//div[@id='output']"));
        System.out.println("alert output: "+ outputDiv.getText());
        sleepForTwoSeconds();
    }

    public void confirmationAlertDismiss(){
        hitUrl();
        WebElement alertInitBtn = driver.findElement(By.xpath("//button[contains(@id, 'confirmBox')]"));

        alertInitBtn.click();
        Alert confirmationAlert = driver.switchTo().alert();

        System.out.println("alert text: "+ confirmationAlert.getText());
        sleepForTwoSeconds();

        confirmationAlert.dismiss();

        WebElement outputDiv = driver.findElement(By.xpath("//div[@id='output']"));
        System.out.println("alert output: "+ outputDiv.getText());
        sleepForTwoSeconds();
    }

    public void promptAlert(){
        hitUrl();
        WebElement alertInitBtn = driver.findElement(By.xpath("//button[contains(@id, 'promptBox')]"));

        alertInitBtn.click();
        Alert promptAlert = driver.switchTo().alert();

        System.out.println("alert text: "+ promptAlert.getText());
        sleepForTwoSeconds();

        promptAlert.sendKeys("Rhea");
        sleepForTwoSeconds();

        promptAlert.accept();

        WebElement outputDiv = driver.findElement(By.xpath("//div[@id='output']"));
        System.out.println("alert output: "+ outputDiv.getText());
        sleepForTwoSeconds();
    }
}
