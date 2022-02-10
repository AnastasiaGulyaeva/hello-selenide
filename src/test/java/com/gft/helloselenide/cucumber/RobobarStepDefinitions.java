package com.gft.helloselenide.cucumber;

import com.gft.helloselenide.CartPage;
import com.gft.helloselenide.CheckoutPage;
import com.gft.helloselenide.OrderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class RobobarStepDefinitions {
    CartPage cartPage;
    CheckoutPage checkoutPage;
    OrderPage orderPage;

    @Given("user opens robobar website")
    public void userOpensRobobarWebsite() {
        open("http://localhost:3000");
        cartPage = new CartPage();
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
    public void totalShouldBe€(Double total) {
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
        orderPage.getAlertAge();
    }
}
