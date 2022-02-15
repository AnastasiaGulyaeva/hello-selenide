package com.gft.helloselenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// http://localhost:3000/#!/success
public class OrderPage {

    private SelenideElement alertDiv = $(".alert-danger");

    private SelenideElement confirmationMessage = $x("//p");

    public SelenideElement alert() {
        return alertDiv;
    }

    public SelenideElement confirmationMessage() {
        return confirmationMessage;
    }
}