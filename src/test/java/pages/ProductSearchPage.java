package pages;

import org.openqa.selenium.WebDriver;

public class ProductSearchPage extends Page {


    public final String  search= "/html//div[@id='sfx-discovery-search-suggestions']//input";
    public final String selectProduct="div:nth-of-type(4) > .card-border.p-card-chldrn-cntnr";


    public ProductSearchPage(WebDriver driver) {super(driver);}
}
