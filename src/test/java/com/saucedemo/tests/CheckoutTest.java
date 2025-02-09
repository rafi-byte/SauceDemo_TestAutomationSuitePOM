package com.saucedemo.tests;

import com.saucedemo.pages.*;
import com.saucedemo.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends TestBase {
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private NavigationPage navigationPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @Test
    public void testCheckoutProcess() {
        // Login
        loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");

        // Add item to cart
        productsPage = new ProductsPage(driver);
        productsPage.addToCart("sauce-labs-backpack");

        // Go to cart
        navigationPage = new NavigationPage(driver);
        navigationPage.goToCart();

        // Start checkout
        cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        // Complete checkout
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterShippingDetails("John", "Doe", "12345");
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();

        Assert.assertEquals(checkoutPage.getConfirmationMessage(),
                "Thank you for your order!",
                "Order confirmation message should match");
    }
}
