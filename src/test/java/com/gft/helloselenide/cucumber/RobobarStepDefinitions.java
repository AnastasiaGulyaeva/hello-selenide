package com.gft.helloselenide.cucumber;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.gft.helloselenide.CartPage;
import com.gft.helloselenide.CheckoutPage;
import com.gft.helloselenide.OrderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class RobobarStepDefinitions {
    private final CartPage cartPage = new CartPage();
    private CheckoutPage checkoutPage;
    private OrderPage orderPage;

    @Given("user opens robobar website")
    public void openRobobar() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );

        DesiredCapabilities capabilites = new DesiredCapabilities();
        capabilites.setCapability("enableVNC", true);
        capabilites.setCapability("enableVNC", true);
        Configuration.browserCapabilities = capabilites;

        open("/");
        checkoutPage = null;
    }

    @When("user adds a cola")
    public void userAddsACola() {
        cartPage.addCola();
    }

    @When("user adds a beer")
    public void userAddsABeer() {
        cartPage.addBeer();
    }

    /*
    @Then("total should be €{double}")
    public void totalShouldBe€(Double total) {
        cartPage.total().shouldBe(text(total.toString()));
    }
    */
    @Then("total should be €{double}")
    public void totalShouldBe(Double total) {
        cartPage.total().shouldBe(exactText(String.format("€%.2f", total)));
    }

    @When("user goes to checkout")
    public void userGoesToCheckout() {
        checkoutPage = cartPage.checkout();
    }

    @When("user puts their age as {string}")
    public void userPutsTheirAgeAs(String age) {
        checkoutPage.setAge(age);
    }

    @And("user confirms the order")
    public void userConfirmsTheOrder() {
        orderPage = checkoutPage.order();
    }

    @Then("alert should be visible")
    public void alertShouldBeVisible() {
        orderPage.getAlertAge().shouldBe(visible);
    }

    @Then("alert should be {string}")
    public void alertShouldBe(String message) {
        orderPage.getConfirmationMessage().shouldBe(exactText(message));
    }

    @Then("user adds a cola and a beer")
    public void userAddsAColaAndABeer() {
        cartPage.addCola();
        cartPage.addBeer();
    }

    @Then("user adds {int} colas")
    public void userAddsCola(int n) {
        for(int i=0; i<n; i++) {
            cartPage.addCola();
        }
    }

    @When("user adds {int} beers")
    public void userAddsNBeers(int n) {
        for(int i=0; i<n; i++) {
            cartPage.addBeer();
        }
    }

    @When("user adds {int} wines")
    public void userAddsNWines(int n) {
        for(int i=0; i<n; i++) {
            cartPage.addWine();
        }
    }

    @When("user adds {int} cola {int} beer {int} wine")
    public void userAddsColaBeerWine(int cola, int beer, int wine) {
        userAddsCola(cola);
        userAddsNBeers(beer);
        userAddsNWines(wine);
    }
}
