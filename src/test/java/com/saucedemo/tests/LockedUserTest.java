package com.saucedemo.tests;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LockedUserTest extends TestBase {
    private LoginPage loginPage;

    @Test
    public void testLockedOutUser() {
        loginPage = new LoginPage(driver);
        loginPage.loginAs("locked_out_user", "secret_sauce");

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("locked out"),
                "Error message should indicate user is locked out");
    }
}
