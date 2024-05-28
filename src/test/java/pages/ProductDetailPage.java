package pages;

import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends Page{

    public final String addToBasket=".add-to-basket";
    public final String addToBasketSuccess=".product-container .add-to-basket.success";
    public final String favorite=".fv";
    public final String addedFavorite=".i-heart-orange:before";
    public final String couponCollect=".collectable-coupons-content .coupon-item-wrapper:nth-of-type(1) .coupon-collect-button";
    public final String closePopUp="div[title='Kapat'] > svg";

    public final String photo=".gallery-container  .styles-module_slider__o0fqa > div:nth-of-type(1)";
    public final String selectPhoto=".gallery-container .product-slide-container .product-slide.focused";
    public final String otherProduct="[title='Turuncu']";
    public final String selectOtherProduct="#product-detail-app .slicing-attributes .slc-img.selected ";
    public final String  search= "/html//div[@id='sfx-discovery-search-suggestions']//input";
    public final String selectProduct="div:nth-of-type(4) > .card-border.p-card-chldrn-cntnr";
    public final String favorites=".account-favorites.account-nav-item  .link-text";




    public ProductDetailPage(WebDriver driver) {super(driver);
    }
}


