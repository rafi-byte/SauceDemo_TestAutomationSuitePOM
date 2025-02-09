package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CartPage extends BasePage {
    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartItemCount() {
        return cartItems.size();
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

    public List<WebElement> getCartItems() {
        return cartItems;
    }
}

