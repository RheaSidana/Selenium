package sampleapp.implementations;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SwitchingWindows {

    private WebDriver driver;

    public SwitchingWindows(WebDriver driver) {
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
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
    }

    public void openMultipleTabsAndWindows(){
        hitUrl();

        String parentTab = driver.getWindowHandle();
        System.out.println("Parent Window: "+ parentTab);

        WebElement newTabsWindowsBtn = driver.findElement(By.xpath("//button[@id='newTabsWindowsBtn']"));
        newTabsWindowsBtn.click();
        sleepForTwoSeconds();

        Set<String> tabHandles = driver.getWindowHandles();
        tabHandles.remove(parentTab);   // only child windows are present
        sleepForTwoSeconds();

        Map<String,String> windowMap = new HashMap<String,String>();

        for (String childWindow : tabHandles){
            System.out.println("Child : "+ childWindow);
            String childWindowUrl = driver.switchTo().window(childWindow).getCurrentUrl();
            System.out.println(childWindowUrl);
            if(childWindowUrl.contains("controls")){
                windowMap.put("Controls", childWindow);
            }else if(childWindowUrl.contains("alert")){
                windowMap.put("Alert", childWindow);
            }else if(childWindowUrl.contains("containers")){
                windowMap.put("Containers", childWindow);
            }else{
                windowMap.put("Contact", childWindow);
            }
        }
        sleepForTwoSeconds();

        driver.switchTo().window(windowMap.get("Controls"));
        driver.manage().window().maximize();
        WebElement inputTag = driver.findElement(By.xpath("//input[@id='firstName']"));
        inputTag.sendKeys("Rhea");
        sleepForTwoSeconds();
        sleepForTwoSeconds();
        driver.close();

        sleepForTwoSeconds();
        driver.switchTo().window(windowMap.get("Containers"));
        driver.manage().window().maximize();
        inputTag = driver.findElement(By.xpath("//*[@id=\"post-body-299858861183690484\"]/div/form/div[1]/input[1]"));
        inputTag.sendKeys("Rhea");
        sleepForTwoSeconds();
        sleepForTwoSeconds();
        driver.close();

        sleepForTwoSeconds();
        driver.switchTo().window(windowMap.get("Alert"));
        driver.manage().window().maximize();
        WebElement simpleAertBtn = driver.findElement(By.xpath("//button[@id='alertBox']"));
        simpleAertBtn.click();
        sleepForTwoSeconds();

        driver.switchTo().alert().accept();
        sleepForTwoSeconds();
        sleepForTwoSeconds();
        driver.close();

        sleepForTwoSeconds();
        driver.switchTo().window(windowMap.get("Contact"));
        driver.manage().window().maximize();
        inputTag = driver.findElement(By.xpath("//input[@id='ContactForm1_contact-form-name']"));
        inputTag.sendKeys("Rhea");
        sleepForTwoSeconds();
        sleepForTwoSeconds();
        driver.close();

        driver.switchTo().window(parentTab);
        driver.manage().window().maximize();
        WebElement inputBox = driver.findElement(By.xpath("//input[@id='name']"));
        inputBox.sendKeys("Sidana");
        sleepForTwoSeconds();
        sleepForTwoSeconds();
    }

    public void openMultipleTabs(){
        hitUrl();

        String parentTab = driver.getWindowHandle();
        System.out.println("Parent Window: "+ parentTab);

        WebElement newTabsBtn = driver.findElement(By.xpath("//button[@id='newTabsBtn']"));
        newTabsBtn.click();
        sleepForTwoSeconds();

        Set<String> tabHandles = driver.getWindowHandles();
        tabHandles.remove(parentTab);   // only child windows are present
        sleepForTwoSeconds();

        Map<String,String> windowMap = new HashMap<String,String>();

        for (String childWindow : tabHandles){
            System.out.println("Child : "+ childWindow);
            String childWindowUrl = driver.switchTo().window(childWindow).getCurrentUrl();
            System.out.println(childWindowUrl);
            if(childWindowUrl.contains("controls")){
                windowMap.put("Controls", childWindow);
            }else{
                windowMap.put("Alert", childWindow);
            }
        }
        sleepForTwoSeconds();

        driver.switchTo().window(windowMap.get("Controls"));
        WebElement inputTag = driver.findElement(By.xpath("//input[@id='firstName']"));
        inputTag.sendKeys("Rhea");
        sleepForTwoSeconds();
        sleepForTwoSeconds();
        driver.close();

        sleepForTwoSeconds();
        driver.switchTo().window(windowMap.get("Alert"));
        WebElement simpleAertBtn = driver.findElement(By.xpath("//button[@id='alertBox']"));
        simpleAertBtn.click();
        sleepForTwoSeconds();

        driver.switchTo().alert().accept();
        sleepForTwoSeconds();
        sleepForTwoSeconds();
        driver.close();

        driver.switchTo().window(parentTab);
        WebElement inputBox = driver.findElement(By.xpath("//input[@id='name']"));
        inputBox.sendKeys("Sidana");
        sleepForTwoSeconds();
        sleepForTwoSeconds();
    }

    public void openMultipleWindows(){
        hitUrl();

        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window: "+ parentWindow);

        WebElement newWindowsBtn = driver.findElement(By.xpath("//button[@id='newWindowsBtn']"));
        newWindowsBtn.click();

        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.remove(parentWindow);   // only child windows are present
        sleepForTwoSeconds();

        Map<String,String> windowMap = new HashMap<String,String>();

        for (String childWindow : windowHandles){
            System.out.println("Child : "+ childWindow);
            String childWindowUrl = driver.switchTo().window(childWindow).getCurrentUrl();
            System.out.println(childWindowUrl);
            if(childWindowUrl.contains("controls")){
                windowMap.put("Controls", childWindow);
            }else{
                windowMap.put("Containers", childWindow);
            }
        }
        sleepForTwoSeconds();

        driver.switchTo().window(windowMap.get("Controls"));
        driver.manage().window().maximize();
        WebElement inputTag = driver.findElement(By.xpath("//input[@id='firstName']"));
        inputTag.sendKeys("Rhea");
        sleepForTwoSeconds();
        sleepForTwoSeconds();
        driver.close();

        sleepForTwoSeconds();
        driver.switchTo().window(windowMap.get("Containers"));
        driver.manage().window().maximize();
        inputTag = driver.findElement(By.xpath("//*[@id=\"post-body-299858861183690484\"]/div/form/div[1]/input[1]"));
        inputTag.sendKeys("Rhea");
        sleepForTwoSeconds();
        sleepForTwoSeconds();
        driver.close();

        driver.switchTo().window(parentWindow);
        driver.manage().window().maximize();
        WebElement inputBox = driver.findElement(By.xpath("//input[@id='name']"));
        inputBox.sendKeys("Sidana");
        sleepForTwoSeconds();
        sleepForTwoSeconds();
    }

    public void openAndSwitchToNewTab(){
        hitUrl();

        String parentTab = driver.getWindowHandle();
        System.out.println("Parent Window: "+ parentTab);

        WebElement newTabBtn = driver.findElement(By.xpath("//button[@id='newTabBtn']"));
        newTabBtn.click();

        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.remove(parentTab);

        String newTab = windowHandles.stream().findFirst().get();
        System.out.println("New tab: "+ newTab);

        driver.switchTo().window(newTab);
        WebElement simpleAertBtn = driver.findElement(By.xpath("//button[@id='alertBox']"));
        simpleAertBtn.click();
        sleepForTwoSeconds();

        driver.switchTo().alert().accept();
        sleepForTwoSeconds();
        sleepForTwoSeconds();
        driver.close();

        driver.switchTo().window(parentTab);
        WebElement inputBox = driver.findElement(By.xpath("//input[@id='name']"));
        inputBox.sendKeys("Sidana");
        sleepForTwoSeconds();
        sleepForTwoSeconds();
    }

    public void openAndSwitchToNewWindow(){
        hitUrl();

        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window: "+ parentWindow);

        WebElement newWindowBtn = driver.findElement(By.xpath("//button[@id='newWindowBtn']"));

        newWindowBtn.click();
        sleepForTwoSeconds();

        Set<String> allWindowHandles = driver.getWindowHandles();
        allWindowHandles.remove(parentWindow);

        System.out.println("New Window" + allWindowHandles.stream().findFirst().get());
        String newWindow = allWindowHandles.stream().findFirst().get();
        sleepForTwoSeconds();

        driver.switchTo().window(newWindow);
        WebElement inputTag = driver.findElement(By.xpath("//input[@id='firstName']"));
        inputTag.sendKeys("Rhea");
        sleepForTwoSeconds();
        sleepForTwoSeconds();
        driver.close();

        driver.switchTo().window(parentWindow);
        WebElement inputBox = driver.findElement(By.xpath("//input[@id='name']"));
        inputBox.sendKeys("Sidana");
        sleepForTwoSeconds();
        sleepForTwoSeconds();
    }
}
