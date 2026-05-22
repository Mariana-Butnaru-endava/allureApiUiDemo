package com.letskodeit.base;

import com.letskodeit.config.ConfigReader;
import com.letskodeit.driver.DriverFactory;
import com.letskodeit.driver.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;

public abstract class BaseTest {
    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional String browser) {
        WebDriver driver = DriverFactory.createDriver(browser);
        DriverManager.setDriver(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.manage().window().maximize();
        openBaseUrl();
    }

    @Step("Open base URL")
    public void openBaseUrl() {
        DriverManager.getDriver().get(ConfigReader.get("baseUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
