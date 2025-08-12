//package sampleapp.implementations;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//
//public class Assignment1 {
//
//    private WebDriver driver;
//
//    public Assignment1(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    private void hitUrl(){
//        // website url to hit
//        String url = "https://test.salesforce.com/";
//
//        // hit the url
//        driver.get(url);
//    }
//
////    private Actions initActions(){
////        return new Actions(driver);
////    }
//
//    private void sleepForTwoSeconds(){
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void solution(){
//        hitUrl();
//
//        WebElement checkbox = driver.findElement(By.xpath("//div[contains(@class, 'remember')]/child::input"));
//
//        // verify
//        boolean isCheckboxVisible = checkbox.isDisplayed();
////        SoftAssert assert =
//
//    }
//}
