package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import pages.LoginPage;
import pages.MainPage;
import pages.MyBasketPage;

public class MyBasketTests {


    private WebDriver driver;
    private MyBasketPage myBasketPage;
    private LoginPage loginPage;
    private MainPage mainPage;


    @BeforeEach
    void setup(){

        driver= new ChromeDriver();
        driver.manage().window().maximize();
        myBasketPage = new MyBasketPage(driver);
        loginPage= new LoginPage(driver);
        mainPage= new MainPage(driver);
        driver.get("https://www.trendyol.com/sepet");
    }


    @Test
    void givenIncreaseOfProductWhenClickButtonShowSuccessToastScreen() throws InterruptedException {

        mainPage.wait(mainPage.closeCookie);
        mainPage.clickId(mainPage.closeCookie);
        Thread.sleep(500);

        mainPage.wait(mainPage.myAcc);
        mainPage.clickCss(mainPage.myAcc);

        loginPage.wait(loginPage.loginEmail);
        loginPage.sendKeysCss(loginPage.loginEmail, "testtowork99@gmail.com");

        loginPage.wait(loginPage.loginPass);
        loginPage.sendKeysCss(loginPage.loginPass, "test123.");

        loginPage.wait(loginPage.loginBtn);
        loginPage.clickCss(loginPage.loginBtn);
        Thread.sleep(2000);

        myBasketPage.wait(myBasketPage.plusButton);
        myBasketPage.clickCss(myBasketPage.plusButton);

        myBasketPage.wait(myBasketPage.successToast);

        String actualSuccessMessage =myBasketPage.getElement(myBasketPage.successToast).getText();
        String expectedSuccessMessage= "Sepet başarıyla güncellendi";

        Assertions.assertEquals(expectedSuccessMessage,actualSuccessMessage);

        String color = myBasketPage.getElement(myBasketPage.successToast).getCssValue("background-color");
        String actualColor = Color.fromString(color).asHex();
        String expectedColor = "#51a351";

        Assertions.assertEquals(expectedColor, actualColor);

    }

    @Test
    void givenIncreaseOfProductWhenClickButtonShowUnSuccessToastScreen() throws InterruptedException {

        mainPage.wait(mainPage.closeCookie);
        mainPage.clickId(mainPage.closeCookie);
        Thread.sleep(1000);

        mainPage.wait(mainPage.myAcc);
        mainPage.clickCss(mainPage.myAcc);

        loginPage.wait(loginPage.loginEmail);
        loginPage.sendKeysCss(loginPage.loginEmail, "testtowork99@gmail.com");

        loginPage.wait(loginPage.loginPass);
        loginPage.sendKeysCss(loginPage.loginPass, "test123.");

        loginPage.wait(loginPage.loginBtn);
        loginPage.clickCss(loginPage.loginBtn);
        Thread.sleep(2000);

        myBasketPage.wait(myBasketPage.plusButton2);
        myBasketPage.clickCss(myBasketPage.plusButton2);
        Thread.sleep(500);

        myBasketPage.wait(myBasketPage.unsuccessToast);

        String actualSuccessMessage =myBasketPage.getElement(myBasketPage.unsuccessToast).getText();
        String expectedSuccessMessage= "Sepetinize eklemek istediğiniz üründen şu anda stoklarımızda 3 adet mevcuttur.";

        Assertions.assertEquals(expectedSuccessMessage,actualSuccessMessage);

        String color = myBasketPage.getElement(myBasketPage.unsuccessToast).getCssValue("background-color");
        String actualColor = Color.fromString(color).asHex();
        String expectedColor = "#bd362f";

        Assertions.assertEquals(expectedColor, actualColor);
    }

    @Test
    void givenSelectCheckBoxWhenClickButtonShowSuccessToastScreen() throws InterruptedException {

        mainPage.wait(mainPage.closeCookie);
        mainPage.clickId(mainPage.closeCookie);
        Thread.sleep(1000);

        mainPage.wait(mainPage.myAcc);
        mainPage.clickCss(mainPage.myAcc);

        loginPage.wait(loginPage.loginEmail);
        loginPage.sendKeysCss(loginPage.loginEmail, "testtowork99@gmail.com");

        loginPage.wait(loginPage.loginPass);
        loginPage.sendKeysCss(loginPage.loginPass, "test123.");

        loginPage.wait(loginPage.loginBtn);
        loginPage.clickCss(loginPage.loginBtn);
        Thread.sleep(2000);

        myBasketPage.wait(myBasketPage.checkBox);
        myBasketPage.clickCss(myBasketPage.checkBox);

        myBasketPage.wait(myBasketPage.successToast);

        String actualSuccessMessage =myBasketPage.getElement(myBasketPage.successToast).getText();
        String expectedSuccessMessage= "Sepet başarıyla güncellendi";

        Assertions.assertEquals(expectedSuccessMessage,actualSuccessMessage);

        String backgroundColor = myBasketPage.getElement(myBasketPage.successToast).getCssValue("background-color");
        String backgroundActualColor = Color.fromString(backgroundColor).asHex();
        String backgroundExpectedColor = "#51a351";

        Assertions.assertEquals(backgroundExpectedColor, backgroundActualColor);

        String color = myBasketPage.getElement(myBasketPage.checkedBox).getCssValue("background-color");
        String actualColor = Color.fromString(color).asHex();
        String expectedColor = "#f27a1a";

        Assertions.assertEquals(expectedColor, actualColor);
    }
}
