package com.gittigidiyor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class SearchResultPage extends HomePage {
    private By selectPageNumber = By.linkText("2");
    private By secondPageNumber = By.className("current");
    private By randomSelectProduct;

    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void choosePage() {
        click(selectPageNumber, 10);
    }

    public String secondPage() {
        return getText(secondPageNumber);
    }

    public By getRandomSelectProduct() {
        Random random = new Random();
        int rand = random.nextInt(48) + 1;
        return By.cssSelector(".products-container > li:nth-child(" + rand + ")");
    }

    public ProductDetailPage getProductDetail() {
        randomSelectProduct = getRandomSelectProduct();
        click(randomSelectProduct, 10);
        return new ProductDetailPage(webDriver);
    }

}
