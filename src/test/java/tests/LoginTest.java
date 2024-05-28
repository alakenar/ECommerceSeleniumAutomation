package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;

public class LoginTest {

    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;


    @BeforeEach
    void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        driver.get("https://www.trendyol.com/giris?cb=/");

    }

    @Test
    void givenCorrectMailAndPasswordWhenClickLoginButtonThenShouldSuccessLogin() throws InterruptedException {


        mainPage.wait(mainPage.closeCookie);
        mainPage.clickId(mainPage.closeCookie);

        mainPage.wait(mainPage.myAcc);
        mainPage.clickCss(mainPage.myAcc);

        loginPage.wait(loginPage.loginEmail);
        loginPage.sendKeysCss(loginPage.loginEmail, "testtowork99@gmail.com");

        loginPage.wait(loginPage.loginPass);
        loginPage.sendKeysCss(loginPage.loginPass, "test123.");

        loginPage.wait(loginPage.loginBtn);
        loginPage.clickCss(loginPage.loginBtn);

    }

    @Test
    void givenWrongMailAndPasswordWhenClickLoginButtonThenShouldShowErrorMessage() throws InterruptedException {

        mainPage.wait(mainPage.closeCookie);
        mainPage.clickId(mainPage.closeCookie);

        mainPage.wait(mainPage.myAcc);
        mainPage.clickCss(mainPage.myAcc);

        loginPage.wait(loginPage.loginEmail);
        loginPage.sendKeysCss(loginPage.loginEmail, "testtowork99@gmail.com");

        loginPage.wait(loginPage.loginPass);
        loginPage.sendKeysCss(loginPage.loginPass, "test123");

        loginPage.wait(loginPage.loginBtn);
        loginPage.clickCss(loginPage.loginBtn);

        loginPage.wait(loginPage.loginErrorMessage);
        String elementErrorMessage = loginPage.getElement(loginPage.loginErrorMessage).getText();
        String expectedErrorMessage = "E-posta adresiniz ve/veya şifreniz hatalı.";

        Assertions.assertEquals(expectedErrorMessage, elementErrorMessage);


    }

    @Test
    void givenWrongFormatMailWhenClickLoginButtonThenShouldShowErrorMessage() throws InterruptedException {


        mainPage.wait(mainPage.closeCookie);
        mainPage.clickId(mainPage.closeCookie);

        mainPage.wait(mainPage.myAcc);
        mainPage.clickCss(mainPage.myAcc);

        loginPage.wait(loginPage.loginEmail);
        loginPage.sendKeysCss(loginPage.loginEmail, "testtoworkgmail.com");

        loginPage.wait(loginPage.loginPass);
        loginPage.sendKeysCss(loginPage.loginPass, "test123.");

        loginPage.wait(loginPage.loginBtn);
        loginPage.clickCss(loginPage.loginBtn);

        loginPage.wait(loginPage.loginErrorMessage);
        String elementErrorMessage = loginPage.getElement(loginPage.loginErrorMessage).getText();
        String expectedErrorMessage = "Lütfen geçerli bir e-posta adresi giriniz.";

        Assertions.assertEquals(expectedErrorMessage, elementErrorMessage);


    }

    @Test
    void givenEmptyPasswordWhenClickLoginButtonThenShouldShowErrorMessage() throws InterruptedException {

        mainPage.wait(mainPage.closeNot);
        mainPage.clickId(mainPage.closeNot);

        mainPage.wait(mainPage.closeCookie);
        mainPage.clickId(mainPage.closeCookie);

        mainPage.wait(mainPage.myAcc);
        mainPage.clickCss(mainPage.myAcc);

        loginPage.wait(loginPage.loginEmail);
        loginPage.sendKeysCss(loginPage.loginEmail, "testtowork99@gmail.com");

        loginPage.wait(loginPage.loginBtn);
        loginPage.clickCss(loginPage.loginBtn);

        loginPage.wait(loginPage.loginErrorMessage);
        String elementErrorMessage = loginPage.getElement(loginPage.loginErrorMessage).getText();
        String expectedErrorMessage = "Lütfen şifrenizi giriniz.";

        Assertions.assertEquals(expectedErrorMessage, elementErrorMessage);
    }

    @Test
    void givenEmptyMailAndPasswordWhenClickLoginButtonThenShouldShowErrorMessage() throws InterruptedException {

        mainPage.wait(mainPage.closeNot);
        mainPage.clickId(mainPage.closeNot);

        mainPage.wait(mainPage.closeCookie);
        mainPage.clickId(mainPage.closeCookie);

        mainPage.wait(mainPage.myAcc);
        mainPage.clickCss(mainPage.myAcc);

        loginPage.wait(loginPage.loginBtn);
        loginPage.clickCss(loginPage.loginBtn);

        loginPage.wait(loginPage.loginErrorMessage);
        String elementErrorMessage = loginPage.getElement(loginPage.loginErrorMessage).getText();
        String expectedErrorMessage = "Lütfen geçerli bir e-posta adresi giriniz.";

        Assertions.assertEquals(expectedErrorMessage, elementErrorMessage);

    }
}


