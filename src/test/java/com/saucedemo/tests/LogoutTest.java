package com.saucedemo.tests;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.NavigationPage;
import com.saucedemo.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase {
    private LoginPage loginPage;
    private NavigationPage navigationPage;

    @Test
    public void testLogout() {
        // Login
        loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");

        // Logout
        navigationPage = new NavigationPage(driver);
        navigationPage.logout();

        // Verify return to login page
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"),
                "Should be redirected to login page");
    }
}
