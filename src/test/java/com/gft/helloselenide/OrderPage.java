package com.gft.helloselenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// http://localhost:3000/#!/success
public class OrderPage {

    private SelenideElement confirmationMessage = $("p");

    private SelenideElement cancelButton = $(".btn-default");

    private SelenideElement alertAge = $(".alert-danger");

    public SelenideElement getConfirmationMessage() {
        return confirmationMessage;
    }

    public SelenideElement getAlertAge() {
        return alertAge;
    }
}