package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;

public class MainTest {

    private WebDriver driver;
    private MainPage mainPage;



    @BeforeEach
    void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        driver.get("https://www.trendyol.com/");

    }

    @Test
    void givenOpenThePageWhenClickCloseCookiesThenShouldSuccessMainPage() throws InterruptedException {

        mainPage.wait(mainPage.closeNot);
        mainPage.clickId(mainPage.closeNot);

        mainPage.wait(mainPage.closeCookie);
        mainPage.clickId(mainPage.closeCookie);


    }

}
