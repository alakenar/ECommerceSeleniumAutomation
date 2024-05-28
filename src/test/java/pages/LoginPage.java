package pages;

import org.openqa.selenium.WebDriver;
import pages.Page;

public class LoginPage extends Page {

   public final String loginEmail="input#login-email";
   public final String loginPass="input#login-password-input";
   public final String loginBtn="[type='submit']";
   public final String loginErrorMessage ="div#error-box-wrapper > .message";

   public LoginPage(WebDriver driver) {
      super(driver);
   }
}
