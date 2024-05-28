package pages;

import org.openqa.selenium.WebDriver;

public class MyBasketPage extends Page{

    public final String plusButton=".pb-wrapper .pb-merchant-group:nth-of-type(3) [aria-label='Ürün adedi arttırma']";
    public final String plusButton2=".pb-wrapper .pb-merchant-group:nth-of-type(2) [aria-label='Ürün adedi arttırma']";
    public final String textValue="/html//div[@id='pb-container']/div[@class='pb-wrapper']/div[3]/div[@class='pb-basket-item-wrapper-v2']//input[@value='3']";
    public final String successToast=".success.toastrElement";
    public final String unsuccessToast=".error.toastrElement";

    public final String checkBox= ".pb-wrapper .pb-merchant-group:nth-of-type(3) .pb-basket-item-wrapper-v2:nth-of-type(2) .ty-check";
    public final String checkedBox =".ty-checkbox-wrapper.ty-checkbox-active .ty-checkbox";






    public MyBasketPage(WebDriver driver) {super(driver);}
}
