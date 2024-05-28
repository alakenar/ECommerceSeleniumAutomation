package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

public class RegisterTest {

    private WebDriver driver;
    private RegisterPage registerPage;


    @BeforeEach
    void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        registerPage = new RegisterPage(driver);
        driver.get("https://www.trendyol.com/uyelik?cb=/");

    }

    @Test
    void givenCorrectMailAndPasswordAndCheckedConsentCheckboxWhenClickRegisterButtonThenShouldShowReCaptchaMessage() throws InterruptedException {

        registerPage.wait(registerPage.closeRegCookie);
        registerPage.clickId(registerPage.closeRegCookie);

        registerPage.wait(registerPage.registerEmail);
        registerPage.sendKeysCss(registerPage.registerEmail, "testtowork@gmail.com");

        registerPage.wait(registerPage.registerPass);
        registerPage.sendKeysCss(registerPage.registerPass, "test123.");

        registerPage.wait(registerPage.personalCheckbox);
        registerPage.clickCss(registerPage.personalCheckbox);

        registerPage.wait(registerPage.registerBtn);
        registerPage.clickCss(registerPage.registerBtn);

        registerPage.wait(registerPage.recaptchaMessage);
        String actualErrorMessage = registerPage.getElement(registerPage.recaptchaMessage).getText();
        String expectedErrorMessage = "Üyelik işlemini güvenli hale getirmek için \"Ben robot değilim\" alanına tıklayınız.";

        Assertions.assertEquals(expectedErrorMessage,actualErrorMessage);

    }

    @Test
    void givenRegisteredMailWhenClickRegisterButtonThenShouldShowUserAlreadyRegisterMessage() throws InterruptedException {

        registerPage.wait(registerPage.closeRegCookie);
        registerPage.clickId(registerPage.closeRegCookie);

        registerPage.wait(registerPage.registerEmail);
        registerPage.sendKeysCss(registerPage.registerEmail, "testtowork99@gmail.com");

        registerPage.wait(registerPage.registerPass);
        registerPage.sendKeysCss(registerPage.registerPass, "test123.");

        registerPage.wait(registerPage.registerBtn);
        registerPage.clickCss(registerPage.registerBtn);

        String elementErrorMessage = registerPage.getElement(registerPage.registerErrorMessage).getText();
        String expectedErrorMessage = "Bu e-posta adresi kullanılamaz. Lütfen başka bir e-posta adresi deneyiniz.";

        Assertions.assertEquals(expectedErrorMessage, elementErrorMessage);

        String backgroundColor = registerPage.getElement(registerPage.registerEmail).getCssValue("background-color");
        String actualEmailErrorBackground= Color.fromString(backgroundColor).asHex();
        String expectedEmailErrorBackground = "#fff1f1";

        Assertions.assertEquals(expectedEmailErrorBackground,actualEmailErrorBackground);

    }

    @Test
    void givenInvalidMailWhenClickRegisterButtonThenShouldShowUserErrorRegisterMessage() throws InterruptedException {

        registerPage.wait(registerPage.closeRegCookie);
        registerPage.clickId(registerPage.closeRegCookie);

        registerPage.wait(registerPage.registerEmail);
        registerPage.sendKeysCss(registerPage.registerEmail, "testtowork99@gmail");

        registerPage.wait(registerPage.registerPass);
        registerPage.sendKeysCss(registerPage.registerPass, "test123.");

        registerPage.wait(registerPage.registerBtn);
        registerPage.clickCss(registerPage.registerBtn);

        String elementErrorMessage = registerPage.getElement(registerPage.registerErrorMessage).getText();
        String expectedErrorMessage = "Lütfen geçerli bir email adresi giriniz.";

        Assertions.assertEquals(expectedErrorMessage, elementErrorMessage);

        String backgroundColor = registerPage.getElement(registerPage.registerEmail).getCssValue("background-color");
        String actualEmailErrorBackground= Color.fromString(backgroundColor).asHex();
        String expectedEmailErrorBackground = "#fff1f1";

        Assertions.assertEquals(expectedEmailErrorBackground,actualEmailErrorBackground);

    }

    @Test
    void givenMailAndShortPasswordWhenClickRegisterButtonThenShouldShowUserErrorRegisterMessage() throws InterruptedException {

        registerPage.wait(registerPage.closeRegCookie);
        registerPage.clickId(registerPage.closeRegCookie);

        registerPage.wait(registerPage.registerEmail);
        registerPage.sendKeysCss(registerPage.registerEmail, "testtowork@gmail.com");

        registerPage.wait(registerPage.registerPass);
        registerPage.sendKeysCss(registerPage.registerPass, "test");

        registerPage.wait(registerPage.registerBtn);
        registerPage.clickCss(registerPage.registerBtn);

        String elementErrorMessage = registerPage.getElement(registerPage.registerErrorMessage).getText();
        String expectedErrorMessage = "Şifreniz 7 ile 64 karakter arasında olmalıdır.";

        Assertions.assertEquals(expectedErrorMessage, elementErrorMessage);

        String backgroundColor = registerPage.getElement(registerPage.registerPass).getCssValue("background-color");
        String actualPassErrorBackground= Color.fromString(backgroundColor).asHex();
        String expectedPassErrorBackground = "#fff1f1";

        Assertions.assertEquals(expectedPassErrorBackground,actualPassErrorBackground);

    }

    @Test
    void givenMailAndUseNumberForPasswordWhenClickRegisterButtonThenShouldShowUserErrorRegisterMessage() throws InterruptedException {

        registerPage.wait(registerPage.closeRegCookie);
        registerPage.clickId(registerPage.closeRegCookie);

        registerPage.wait(registerPage.registerEmail);
        registerPage.sendKeysCss(registerPage.registerEmail, "testtowork@gmail.com");

        registerPage.wait(registerPage.registerPass);
        registerPage.sendKeysCss(registerPage.registerPass, "1234567");

        registerPage.wait(registerPage.registerBtn);
        registerPage.clickCss(registerPage.registerBtn);

        String elementErrorMessage = registerPage.getElement(registerPage.registerErrorMessage).getText();
        String expectedErrorMessage = "Şifreniz en az 1 harf içermelidir.";

        Assertions.assertEquals(expectedErrorMessage, elementErrorMessage);

        String backgroundColor = registerPage.getElement(registerPage.registerPass).getCssValue("background-color");
        String actualPassErrorBackground= Color.fromString(backgroundColor).asHex();
        String expectedPassErrorBackground = "#fff1f1";

        Assertions.assertEquals(expectedPassErrorBackground,actualPassErrorBackground);

    }

    @Test
    void givenMailAndUseCharForPasswordWhenClickRegisterButtonThenShouldShowUserErrorRegisterMessage() throws InterruptedException {

        registerPage.wait(registerPage.closeRegCookie);
        registerPage.clickId(registerPage.closeRegCookie);

        registerPage.wait(registerPage.registerEmail);
        registerPage.sendKeysCss(registerPage.registerEmail, "testtowork@gmail.com");

        registerPage.wait(registerPage.registerPass);
        registerPage.sendKeysCss(registerPage.registerPass, "mericom");

        registerPage.wait(registerPage.registerBtn);
        registerPage.clickCss(registerPage.registerBtn);

        String elementErrorMessage = registerPage.getElement(registerPage.registerErrorMessage).getText();
        String expectedErrorMessage = "Şifreniz en az 1 rakam içermelidir.";

        Assertions.assertEquals(expectedErrorMessage, elementErrorMessage);

        String backgroundColor = registerPage.getElement(registerPage.registerPass).getCssValue("background-color");
        String actualPassErrorBackground= Color.fromString(backgroundColor).asHex();
        String expectedPassErrorBackground = "#fff1f1";

        Assertions.assertEquals(expectedPassErrorBackground,actualPassErrorBackground);

    }

    @Test
    void givenCorrectMailAndPasswordAndUncheckedConsentCheckboxWhenClickRegisterButtonThenShowErrorCheckbox() throws InterruptedException {

        registerPage.wait(registerPage.closeRegCookie);
        registerPage.clickId(registerPage.closeRegCookie);

        registerPage.wait(registerPage.registerEmail);
        registerPage.sendKeysCss(registerPage.registerEmail, "testtowork@gmail.com");

        registerPage.wait(registerPage.registerPass);
        registerPage.sendKeysCss(registerPage.registerPass, "test123.");

        registerPage.wait(registerPage.registerBtn);
        registerPage.clickCss(registerPage.registerBtn);

        registerPage.wait(registerPage.clarificationText);
        String color = registerPage.getElement(registerPage.clarificationText).getCssValue("color");
        String actualColor = Color.fromString(color).asHex();
        String expectedColor = "#d21313";

        Assertions.assertEquals(expectedColor, actualColor);
    }

    @Test
    void givenInvalidMailAndPasswordAndUncheckedConsentCheckboxWhenClickRegisterButtonThenShowAlertMessage() throws InterruptedException {

        registerPage.wait(registerPage.closeRegCookie);
        registerPage.clickId(registerPage.closeRegCookie);

        registerPage.wait(registerPage.registerEmail);
        registerPage.sendKeysCss(registerPage.registerEmail, "testtoworkgmail.com");

        registerPage.wait(registerPage.registerPass);
        registerPage.sendKeysCss(registerPage.registerPass, "test123.");

        registerPage.wait(registerPage.registerBtn);
        registerPage.clickCss(registerPage.registerBtn);

        registerPage.wait(registerPage.clarificationText);
        String color = registerPage.getElement(registerPage.clarificationText).getCssValue("color");
        String actualColor = Color.fromString(color).asHex();
        String expectedColor = "#d21313";

        Assertions.assertEquals(expectedColor, actualColor);
    }

}


