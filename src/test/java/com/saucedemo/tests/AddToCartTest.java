package com.saucedemo.tests;

import com.saucedemo.pages.*;
import com.saucedemo.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private NavigationPage navigationPage;
    private CartPage cartPage;

    @Test
    public void testAddToCart() {
        loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");

        productsPage = new ProductsPage(driver);
        productsPage.addToCart("sauce-labs-backpack");
        productsPage.addToCart("sauce-labs-bike-light");

        navigationPage = new NavigationPage(driver);
        navigationPage.goToCart();

        cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getCartItemCount(), 2, "Cart should contain 2 items");
    }

    @Test
    public void testAddRemoveItems() {
        loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");

        productsPage = new ProductsPage(driver);
        productsPage.addToCart("sauce-labs-backpack");
        Assert.assertEquals(productsPage.getCartBadgeCount(), "1");

        productsPage.removeFromCart("sauce-labs-backpack");
        try {
            productsPage.getCartBadgeCount();
            Assert.fail("Cart badge should not be visible");
        } catch (Exception e) {
            // Expected: badge should not be present
        }
    }
}
