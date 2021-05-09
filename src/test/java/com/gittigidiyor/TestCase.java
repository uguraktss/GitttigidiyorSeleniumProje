package com.gittigidiyor;

import com.gittigidiyor.pages.*;
import com.gittigidiyor.users.User;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;


public class TestCase extends BaseTest {
    @Test
    public void GoGittiGidiyor() throws InterruptedException {
        String homePageTitle = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";
        String myUsername = "uguraktas954135";
        String keyword = "bilgisayar";
        String pageNumber = "2";
        String productInfo = "Ürün Toplamı (2 Adet)";
        String basketEmpty = "Sepetinizde ürün bulunmamaktadır.";

        JavascriptExecutor js = (JavascriptExecutor) webDriver; //scroll için aşağı indirme

        //gittigidiyor'a girildiğini kontrol eder
        HomePage homePage = new HomePage(webDriver);
        String driverTitle = homePage.getHomePageTitle();
        Log4j.info("Driver Title : " + driverTitle);
        Assert.assertEquals(driverTitle, homePageTitle);

        homePage.touchLoginButton();
        LoginPage loginPage = homePage.getLoginPage();
        User user = new User();
        String email = user.getEmail();
        String password = user.getPassword();
        Log4j.info("Email : " + email + " - Password : " + password);
        loginPage.login(email, password);
        String userName = homePage.getUserName();
        Log4j.info("Username : " + userName);
        Assert.assertEquals(userName, myUsername);


        SearchResultPage searchResultPage = homePage.search(keyword);
        Log4j.info("The word 'computer' is entered in the search box");
        js.executeScript("window.scrollBy(0,7200)");
        searchResultPage.choosePage();
        String selectPageNumber = searchResultPage.secondPage();
        Assert.assertEquals(pageNumber, selectPageNumber);
        Log4j.info("The selected page is two");

        ProductDetailPage productDetailPage = searchResultPage.getProductDetail();
        String selectProductPrice = productDetailPage.getProductPrice();
        Log4j.info("Selected product price : " + selectProductPrice);
        js.executeScript("window.scrollBy(0,800)");
        productDetailPage.addBasket();
        Log4j.info("The product has been added to the cart");
        productDetailPage.getCart();
        CartPage cartPage = new CartPage(webDriver);
        String cardPrice = cartPage.getCartPrice();
        Assert.assertEquals(selectProductPrice, cardPrice);
        Log4j.info("Cart price is equal to product price");

        cartPage.increaseProduct();
        Thread.sleep(3000);
        String totalProductInfo = cartPage.getTotalProduct();
        Assert.assertEquals(productInfo, totalProductInfo);
        Log4j.info("The number of products in the cart is equal to the number of products");

        cartPage.getEmptyCart();
        String noProduct = cartPage.getNoProductInfo();
        Assert.assertEquals(basketEmpty, noProduct);
        Log4j.info("Cart is empty");

    }

}
