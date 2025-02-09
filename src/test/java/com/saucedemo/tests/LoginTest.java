package com.saucedemo.tests;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    private LoginPage loginPage;

    @Test
    public void testValidLogin() {
        loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @Test
    public void testInvalidLogin() {
        loginPage = new LoginPage(driver);
        loginPage.loginAs("wrong_user", "secret_sauce");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"));
    }
}
