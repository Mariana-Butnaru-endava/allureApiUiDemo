package com.letskodeit.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final By logo = By.cssSelector("a.navbar-brand, .navbar-brand");
    private final By loginLink = By.xpath("//a[contains(normalize-space(),'Sign In') or contains(normalize-space(),'Login')]");
    private final By searchBox = By.cssSelector("input[placeholder*='Search'], input[type='search']");

    @Step("Verify home page is loaded")
    public boolean isLoaded() {
        return driver.getTitle().toLowerCase().contains("letskodeit") || isDisplayed(logo);
    }

    @Step("Click login/sign in")
    public LoginPage clickLogin() {
        click(loginLink);
        return new LoginPage();
    }

    @Step("Search course: {courseName}")
    public void searchForCourse(String courseName) {
        type(searchBox, courseName);
    }
}
