package com.gittigidiyor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends HomePage {

    private By totalPriceBy = By.className("total-price");
    private By numberOfProductBy = By.cssSelector("option[value='2']");
    private By totalProductBy = By.cssSelector("li[class='clearfix total-price-sticky-container']>:nth-child(1)");
    private By deleteCartBy = By.cssSelector("a[title='Sil']");
    private By noProductBy = By.cssSelector("div[class='gg-w-22 gg-d-22 gg-t-21 gg-m-18']>:nth-child(1)");

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getCartPrice() {
        return getText(totalPriceBy);
    }

    public void increaseProduct() {
        click(numberOfProductBy, 10);
    }

    public String getTotalProduct() {
        return getText(totalProductBy);
    }

    public void getEmptyCart() {
        click(deleteCartBy, 10);
    }

    public String getNoProductInfo() {
        return getText(noProductBy);
    }

}
