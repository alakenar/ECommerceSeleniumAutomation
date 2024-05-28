package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {

    WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void wait(String elementId) throws InterruptedException {Thread.sleep(400);}
    public void clickId(String clickId) {
        driver.findElement(By.id(clickId)).click();
    }
    public void clickCss(String clickCss) {
        driver.findElement(By.cssSelector(clickCss)).click();
    }
    public void clickXpath(String clickXpath) {
        driver.findElement(By.xpath(clickXpath)).click();
    }

    public void sendKeysCss(String elementId, String sendKeysCss) {
        driver.findElement(By.cssSelector(elementId)).sendKeys(sendKeysCss);
    }
    public void sendKeysXpath(String elementId, String sendKeysXpath){
        driver.findElement(By.xpath(elementId)).sendKeys(sendKeysXpath);
    }
    public WebElement getElement(String elementId) {
        return driver.findElement(By.cssSelector(elementId));
    }

    public void clickKeyboard(String elementId, Keys keyboard){
        driver.findElement(By.xpath(elementId)).sendKeys(keyboard);
    }


}




