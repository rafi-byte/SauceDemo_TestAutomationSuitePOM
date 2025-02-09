package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationPage extends BasePage {
    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    public void clickMenu() {
        menuButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
    }

    public void logout() {
        clickMenu();
        logoutLink.click();
    }

    public void goToCart() {
        cartLink.click();
    }
}
