package com.gft.helloselenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class CartSuiteTest {
    CartPage cartPage = new CartPage();

    @BeforeAll
    public static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true).savePageSource(false));

        DesiredCapabilities capabilites = new DesiredCapabilities();
        capabilites.setCapability("enableVNC", true);
        capabilites.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilites;
    }

    @BeforeEach
    public void setUp() {
        open("/");
    }

    @Test
    public void startTest() {
        cartPage.getCheckoutButton().shouldBe(disabled);
    }

    @Test
    public void colaTest() {
        cartPage.addCola();
        cartPage.total().shouldBe(text("€1.25"));
        cartPage.addCola();
        cartPage.total().shouldBe(text("€2.50"));
    }

    @Test
    public void beerTest() {
        cartPage.addBeer();
        cartPage.total().shouldBe(text("€2.00"));
        cartPage.addBeer();
        cartPage.total().shouldBe(text("€4.00"));
    }

    @Test
    public void wineTest() {
        cartPage.addWine();
        cartPage.total().shouldBe(text("€3.00"));
        cartPage.addWine();
        cartPage.total().shouldBe(text("€6.00"));
    }

    @Test
    public void goCheckoutTest() {
        cartPage.getCheckoutButton().shouldBe(disabled);
        cartPage.addCola();
        cartPage.addBeer();
        cartPage.addWine();
        cartPage.getCheckoutButton().shouldBe(enabled);
        cartPage.checkout();
    }
}
