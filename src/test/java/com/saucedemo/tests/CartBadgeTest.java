package com.saucedemo.tests;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartBadgeTest extends TestBase {
    private LoginPage loginPage;
    private ProductsPage productsPage;

    @Test
    public void testCartBadgeCount() {
        // Login
        loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");
        productsPage = new ProductsPage(driver);

        // Add multiple items
        productsPage.addToCart("sauce-labs-backpack");
        productsPage.addToCart("sauce-labs-bike-light");
        productsPage.addToCart("sauce-labs-bolt-t-shirt");

        Assert.assertEquals(productsPage.getCartBadgeCount(), "3",
                "Badge count should be 3");

        // Remove one item
        productsPage.removeFromCart("sauce-labs-backpack");
        Assert.assertEquals(productsPage.getCartBadgeCount(), "2",
                "Badge count should be 2");
    }
}
