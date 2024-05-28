package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import pages.LoginPage;
import pages.MainPage;
import pages.ProductDetailPage;

public class ProductDetailTest {

    private WebDriver driver;
    private ProductDetailPage productDetailPage;
    private MainPage mainPage;
    private LoginPage loginPage;


    @BeforeEach
    void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        productDetailPage = new ProductDetailPage(driver);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        driver.get("https://www.trendyol.com/show-by-pastel/show-your-lumos-clear-gloss-dudak-parlaticisi-p-331866917?boutiqueId=61&merchantId=344325");
    }

    @Test
    void givenAddToBasketWhenClickButtonThenShouldSuccess() throws InterruptedException {

        mainPage.wait(mainPage.closeCookie);
        mainPage.clickId(mainPage.closeCookie);

        productDetailPage.wait(productDetailPage.addToBasket);
        productDetailPage.clickCss(productDetailPage.addToBasket);
        Thread.sleep(500);

        String backgroundColor = productDetailPage.getElement(productDetailPage.addToBasketSuccess).getCssValue("background-color");
        String actualBackgroundColor = Color.fromString(backgroundColor).asHex();
        String expectedBackgroundColor = "#008040";

        Assertions.assertEquals(expectedBackgroundColor, actualBackgroundColor);
    }


    @Test
    void givenAddToFavoriteWhenClickButtonAndShowLoginScreenThenAddedFavorites() throws InterruptedException {

        mainPage.wait(mainPage.closeCookie);
        mainPage.clickId(mainPage.closeCookie);

        productDetailPage.wait(productDetailPage.favorite);
        productDetailPage.clickCss(productDetailPage.favorite);

        loginPage.wait(loginPage.loginEmail);
        loginPage.sendKeysCss(loginPage.loginEmail, "testtowork99@gmail.com");

        loginPage.wait(loginPage.loginPass);
        loginPage.sendKeysCss(loginPage.loginPass, "test123.");

        loginPage.wait(loginPage.loginBtn);
        loginPage.clickCss(loginPage.loginBtn);
        Thread.sleep(600);

        String color = productDetailPage.getElement(productDetailPage.addedFavorite).getCssValue("color");
        String actualColor = Color.fromString(color).asHex();
        String expectedColor = "#f27a1a";

        Assertions.assertEquals(expectedColor, actualColor);
    }

    @Test
    void givenCouponCollectWhenClickButtonThenShowPopUpScreen() throws InterruptedException {

        mainPage.wait(mainPage.closeCookie);
        mainPage.clickId(mainPage.closeCookie);

        productDetailPage.wait(productDetailPage.couponCollect);
        productDetailPage.clickCss(productDetailPage.couponCollect);

        loginPage.wait(loginPage.loginEmail);
        loginPage.sendKeysCss(loginPage.loginEmail, "testtowork99@gmail.com");

        loginPage.wait(loginPage.loginPass);
        loginPage.sendKeysCss(loginPage.loginPass, "test123.");

        loginPage.wait(loginPage.loginBtn);
        loginPage.clickCss(loginPage.loginBtn);
        Thread.sleep(600);

        productDetailPage.wait(productDetailPage.closePopUp);
        productDetailPage.clickCss(productDetailPage.closePopUp);

    }

    @Test
    void givenSelectPhotoWhenClickButtonThenShowPhoto() throws InterruptedException {

        mainPage.wait(mainPage.closeCookie);
        mainPage.clickId(mainPage.closeCookie);

        productDetailPage.wait(productDetailPage.photo);
        productDetailPage.clickCss(productDetailPage.photo);

        String color = productDetailPage.getElement(productDetailPage.selectPhoto).getCssValue("border-bottom-color");
        String actualColor = Color.fromString(color).asHex();
        String expectedColor = "#f27a1a";

        Assertions.assertEquals(expectedColor, actualColor);

    }

    @Test
    void givenSelectProductWhenClickButtonThenShowProduct() throws InterruptedException {

        mainPage.wait(mainPage.closeCookie);
        mainPage.clickId(mainPage.closeCookie);

        productDetailPage.wait(productDetailPage.otherProduct);
        productDetailPage.clickCss(productDetailPage.otherProduct);

        String color = productDetailPage.getElement(productDetailPage.selectOtherProduct).getCssValue("border-bottom-color");
        String actualColor = Color.fromString(color).asHex();
        String expectedColor = "#f27a1a";

        Assertions.assertEquals(expectedColor, actualColor);

    }
}
