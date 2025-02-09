package com.saucedemo.tests;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class SortingTest extends TestBase {
    private LoginPage loginPage;
    private ProductsPage productsPage;

    @Test
    public void testProductSorting() {
        // Login
        loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");
        productsPage = new ProductsPage(driver);

        // Test price low to high
        productsPage.sortProducts("lohi");
        List<WebElement> products = productsPage.getAllProducts();
        Assert.assertTrue(isPriceSortedLowToHigh(products),
                "Products should be sorted by price low to high");

        // Test price high to low
        productsPage.sortProducts("hilo");
        products = productsPage.getAllProducts();
        Assert.assertTrue(isPriceSortedHighToLow(products),
                "Products should be sorted by price high to low");

        // Test name A to Z
        productsPage.sortProducts("az");
        products = productsPage.getAllProducts();
        Assert.assertTrue(isNameSortedAToZ(products),
                "Products should be sorted by name A to Z");
    }

    private boolean isPriceSortedLowToHigh(List<WebElement> products) {
        double previousPrice = 0;
        for (WebElement product : products) {
            String priceText = product.findElement(By.className("inventory_item_price"))
                    .getText().replace("$", "");
            double currentPrice = Double.parseDouble(priceText);
            if (currentPrice < previousPrice) return false;
            previousPrice = currentPrice;
        }
        return true;
    }

    private boolean isPriceSortedHighToLow(List<WebElement> products) {
        double previousPrice = Double.MAX_VALUE;
        for (WebElement product : products) {
            String priceText = product.findElement(By.className("inventory_item_price"))
                    .getText().replace("$", "");
            double currentPrice = Double.parseDouble(priceText);
            if (currentPrice > previousPrice) return false;
            previousPrice = currentPrice;
        }
        return true;
    }

    private boolean isNameSortedAToZ(List<WebElement> products) {
        String previousName = "";
        for (WebElement product : products) {
            String currentName = product.findElement(By.className("inventory_item_name")).getText();
            if (currentName.compareTo(previousName) < 0) return false;
            previousName = currentName;
        }
        return true;
    }
}
