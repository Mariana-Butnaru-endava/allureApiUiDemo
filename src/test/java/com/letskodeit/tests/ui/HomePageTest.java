package com.letskodeit.tests.ui;

import com.letskodeit.base.BaseTest;
import com.letskodeit.pages.HomePage;
import com.letskodeit.pages.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("UI Tests")
@Feature("Home Page")
public class HomePageTest extends BaseTest {

    @Test(description = "Verify LetsKodeIt home page loads successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User opens home page")
    public void shouldLoadHomePage() {
        HomePage homePage = new HomePage();
        String title = homePage.getPageTitle();
        System.out.println("Page title: " + title);

        Assert.assertTrue(homePage.isLoaded(), "Home page should be loaded");
        Assert.assertTrue(title.toLowerCase().contains("home page"),
                "Page title should contain Home Page");
    }

    @Test(description = "Verify login successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User opens login page")
    public void shouldLoginSuccessfully() {
        LoginPage loginPage = new HomePage().clickLogin();

        Assert.assertTrue(loginPage.isDisplayed(), "Login page should be displayed");
        Assert.assertTrue(loginPage.getPageTitle().toLowerCase().contains("login"),
                "Page title should contain Login");
    }

    @Test(description = "User incorrectly login")
    @Severity(SeverityLevel.NORMAL)
    @Story("Incorrect User does not login")
    public void incorrectUserShouldNotLoginSuccessfully() {
        LoginPage loginPage = new HomePage().clickLogin();
        loginPage.login("test@incorrect.com", "incorrect");

        Assert.assertTrue(loginPage.errorDisplayed(), "Error message should be displayed");
    }
}
