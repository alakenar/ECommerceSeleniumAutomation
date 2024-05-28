package pages;

import org.openqa.selenium.WebDriver;

public class RegisterPage extends Page {

    public final String closeRegCookie="onetrust-accept-btn-handler";
    public final String registerEmail ="input#register-email";
    public final String registerPass ="input#register-password-input";
    public final String clarificationText=".personal-error-checkbox .ty-checkbox-text";
    public final String registerBtn= "form > .q-button.q-button-medium.q-fluid.q-primary.submit";
    public final String registerErrorMessage="div#error-box-wrapper > .message";
    public final String personalCheckbox=".personal-checkbox [class='ty-display-flex ty-mgt-1']";
    public final String recaptchaMessage=".captcha-box-error";



    public RegisterPage(WebDriver driver) {
        super(driver);
    }
}
