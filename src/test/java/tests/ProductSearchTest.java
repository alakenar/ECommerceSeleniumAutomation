package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.ProductSearchPage;

import java.util.concurrent.TimeUnit;

public class ProductSearchTest {

    private WebDriver driver;
    private ProductSearchPage productSearchPage;

    private MainPage mainPage;


    @BeforeEach
    void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        productSearchPage= new ProductSearchPage(driver);
        mainPage= new MainPage(driver);
        driver.get("https://www.trendyol.com/");
    }

    @Test
    void givenSearchProductWhenClickEnterButtonThenShowProducts() throws InterruptedException {

        mainPage.wait(mainPage.closeNot);
        mainPage.clickId(mainPage.closeNot);

        mainPage.wait(mainPage.closeCookie);
        mainPage.clickId(mainPage.closeCookie);

        productSearchPage.wait(productSearchPage.search);
        productSearchPage.sendKeysXpath(productSearchPage.search, "gloss");
        productSearchPage.clickKeyboard(productSearchPage.search, Keys.ENTER);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        productSearchPage.wait(productSearchPage.selectProduct);
        productSearchPage.clickCss(productSearchPage.selectProduct);
    }
}
