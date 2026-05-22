package com.letskodeit.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By emailInput = By.cssSelector("input[type='email'], input[name='email']");
    private final By passwordInput = By.cssSelector("input[type='password'], input[name='password']");
    private final By submitButton = By.id("login");
    private final By errorMsg = By.id("incorrectdetails");

    @Step("Verify login page is displayed")
    public boolean isDisplayed() {
        return isDisplayed(emailInput) && isDisplayed(passwordInput);
    }

    @Step("Login with email and password")
    public void login(String email, String password) {
        type(emailInput, email);
        type(passwordInput, password);
        click(submitButton);
    }

    @Step("Error message displayed")
    public boolean errorDisplayed() {
        return isDisplayed(errorMsg);
    }
}
