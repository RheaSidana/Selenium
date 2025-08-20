package sampleapp.implementations;

import org.codehaus.groovy.classgen.asm.BinaryIntExpressionHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUpload {
    private WebDriver driver;


    public FileUpload(WebDriver driver) {
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
        driver.get("https://www.foundit.in/upload");
    }

    private void init(){
        hitUrl();

        WebElement button = driver.findElement(By.xpath("//*[@id=\"heroSection-container\"]/div[3]/div[2]"));

        button.click();
        sleepForTwoSeconds();
    }

    public void fileUploadUsingSendKey(){
        init();

        WebElement uploadBtn = driver.findElement(By.xpath("//*[@id=\"file-upload\"]"));

        String filePath = "C:\\Users\\MAX\\Downloads\\Cert6660471_AgentforceSpecialist_20250811.pdf";
        uploadBtn.sendKeys(filePath);
        sleepForTwoSeconds();
        sleepForTwoSeconds();
    }

    public void fileUploadUsingJSExecutor() throws AWTException {
        init();

        WebElement uploadBtn = driver.findElement(By.xpath("//*[@id=\"file-upload\"]"));
        sleepForTwoSeconds();

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click()", uploadBtn);

        sleepForTwoSeconds();
        sleepForTwoSeconds();

        String filePath = "C:\\Users\\MAX\\Downloads\\Cert6660471_AgentforceSpecialist_20250811.pdf";
        // Ctrl+C
        StringSelection ss = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);

        sleepForTwoSeconds();

        // Ctrl+V
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        sleepForTwoSeconds();
        sleepForTwoSeconds();

        // Clicking Enter Key
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        sleepForTwoSeconds();
        sleepForTwoSeconds();
    }
}
