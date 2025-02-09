package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class ProductsPage extends BasePage {
    @FindBy(className = "inventory_item")
    private List<WebElement> products;

    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(String productId) {
        driver.findElement(By.id("add-to-cart-" + productId)).click();
    }

    public void removeFromCart(String productId) {
        driver.findElement(By.id("remove-" + productId)).click();
    }

    public String getCartBadgeCount() {
        return cartBadge.getText();
    }

    public void sortProducts(String sortOption) {
        Select select = new Select(sortDropdown);
        select.selectByValue(sortOption);
    }

    public List<WebElement> getAllProducts() {
        return products;
    }
}
