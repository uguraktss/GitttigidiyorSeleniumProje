package com.gittigidiyor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductDetailPage extends HomePage {
    private By lowPriceBy = By.id("sp-price-lowPrice");
    private By highPriceBy = By.id("sp-price-highPrice");
    private By addBasketBy = By.id("add-to-basket");
    private By cartIconBy = By.className("robot-header-iconContainer-cart");

    public ProductDetailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getProductPrice() {
        String productPrice = webDriver.findElement(lowPriceBy).getText();
        if (productPrice.isEmpty()) {
            return getText(highPriceBy);
        }
        return getText(lowPriceBy);
    }

    public void addBasket() {
        click(addBasketBy, 10);
    }

    public CartPage getCart() {
        click(cartIconBy, 5);
        return new CartPage(webDriver);
    }

}
