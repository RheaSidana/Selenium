package sampleapp.implementations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InputTags {

    private WebDriver driver;

    public InputTags(WebDriver driver) {
        this.driver = driver;
    }

    private void hitUrl(){
        // website url to hit
        String url = "https://test.salesforce.com/";

        // hit the url
        driver.get(url);
    }

    private void hitUrlForRadioBtn(){
        // website url to hit
        String url = "https://www.html.am/html-codes/forms/html-radio-button-code.cfm#google_vignette";

        // hit the url
        driver.get(url);
    }

    private void hitUrlForDropdown(){
        // website url to hit
        String url = "https://tutorial.techaltum.com/htmlform.html";

        // hit the url
        driver.get(url);
    }

    private void sleepForTwoSeconds(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testTextBox(){
        hitUrl();

        WebElement username = driver.findElement(By.xpath("//input[contains(@type, 'email')]"));

        username.sendKeys("rheaS");
        sleepForTwoSeconds();

        username.clear();
        sleepForTwoSeconds();

        username.sendKeys("Rhea Sidana");
        System.out.println("Username tag: "+ username.getTagName());
        System.out.println("Username text: "+ username.getText());
        System.out.println("Username attribute=type: "+ username.getAttribute("type"));
        /*
        Username tag: input
Username text:
Username attribute=type: email
        * */
        System.out.println("username loc : "+ username.getLocation());
        System.out.println("username size : "+ username.getSize());
        System.out.println("username rect height: "+ username.getRect().getHeight());
        System.out.println("username rect width: "+ username.getRect().getWidth());
        /*
        * username loc : (272, 321)
username size : (338, 43)
username rect height: 43
username rect width: 338
        * */

        sleepForTwoSeconds();
    }

    public void testCheckBox(){
        hitUrl();

        WebElement checkBox = driver.findElement(By.xpath("//div[contains(@class, 'remember')]/child::input"));

        System.out.println("Checkbox visible: "+ checkBox.isDisplayed());

        if(!checkBox.isSelected()){
            checkBox.click();
        }
        sleepForTwoSeconds();
    }

    public void testRadioButton(){
        hitUrlForRadioBtn();

        WebElement radioBtn = driver.findElement(By.xpath("/html/body/div[1]/article/table[3]/tbody/tr[2]/td[2]/form/input[2]"));
        WebElement table = driver.findElement(By.xpath("/html/body/div[1]/article/table[3]"));

        System.out.println("Radio Button visible: "+ radioBtn.isDisplayed());
        sleepForTwoSeconds();
        if(radioBtn.isDisplayed()){
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", table);
        }
        sleepForTwoSeconds();

        if(!radioBtn.isSelected()){
            radioBtn.click();
        }
        sleepForTwoSeconds();
    }

    public void testDropdown(){
        hitUrlForDropdown();

        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"city1\"]"));

        if(dropdown.isDisplayed()){
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", dropdown);
        }
        sleepForTwoSeconds();

        Select select = new Select(dropdown);

        select.selectByIndex(2);
        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println("Selected option1: "+selectedOption.getText());
        sleepForTwoSeconds();

        select.selectByVisibleText("Los Angeles");
        selectedOption = select.getFirstSelectedOption();
        System.out.println("Selected option2: "+selectedOption.getText());
        sleepForTwoSeconds();

//        select.deselectByVisibleText("Los Angeles");
//        selectedOption = select.getFirstSelectedOption();
//        System.out.println("Selected option3: "+selectedOption.getText());
//        sleepForTwoSeconds();
    }
}
