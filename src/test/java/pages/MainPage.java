package pages;

import org.openqa.selenium.WebDriver;

public class MainPage extends Page {

    public final String closeNot= "Rating-Review";
    public final String closeCookie="onetrust-accept-btn-handler";
    public final String myAcc=".account-user";

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
