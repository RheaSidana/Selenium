package sampleapp.implementations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Assignment1 {

    private WebDriver driver;

    public Assignment1(WebDriver driver) {
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

    public void solution(){
        hitUrl();
        sleepForTwoSeconds();

        // softAssert
        verifyLoginPageLaunchedAndRememberMeCheckboxIsThere();
        sleepForTwoSeconds();

        loginWithValidUsernameAndInvalidPassword();
        sleepForTwoSeconds();
        sleepForTwoSeconds();

        //assert
        verifyErrorMessageIsDisplayedAndUserNotLoggedIn();
        sleepForTwoSeconds();
    }

    private void verifyErrorMessageIsDisplayedAndUserNotLoggedIn(){
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='error' and @class='loginError']"));

        Assert.assertEquals(errorMessage.isDisplayed(), true, "error is not displayed");
//        System.out.println("error msg: "+ errorMessage.getText());
        //error msg: Error: Please check your username and password. If you still can't log in, contact your Salesforce administrator.

        Assert.assertNotNull(errorMessage);
        Assert.assertEquals(errorMessage.getText().contains("Error"), true, "error not found");

        Assert.assertTrue(driver.getCurrentUrl().contains("test.salesforce.com"));
    }

    private void loginWithValidUsernameAndInvalidPassword(){
        WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
        WebElement username = driver.findElement(By.xpath("//input[contains(@type, 'email')]"));
        WebElement password = driver.findElement(By.xpath("//*[@id='password']"));

        username.sendKeys("rheasidana3125");
        sleepForTwoSeconds();
        password.sendKeys("apsk@34");
        sleepForTwoSeconds();

        initActions().click(login).build().perform();
    }

    private void verifyLoginPageLaunchedAndRememberMeCheckboxIsThere(){
        WebElement checkbox = driver.findElement(By.xpath("//div[contains(@class, 'remember')]/child::input"));

        // verify
        boolean isCheckboxVisible = checkbox.isDisplayed();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isCheckboxVisible, "checkbox is not visible");

        if(isCheckboxVisible)
            System.out.println("checkbox is visible");
        sleepForTwoSeconds();

        softAssert.assertAll();
    }
}
