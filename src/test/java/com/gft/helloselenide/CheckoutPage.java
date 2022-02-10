package com.gft.helloselenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// http://localhost:3000/#!/review
public class CheckoutPage {

    private SelenideElement btnOrder = $(".btn-success");

    private SelenideElement ageInput = $("#ageInput" );

    public OrderPage order() {
        btnOrder.click();
        return page(OrderPage.class);
    }

    public void setAge(String age) {
        ageInput.sendKeys(age);
    }

    public String getAge() {
        return ageInput.getText();
    }

    public SelenideElement ageInput() {
        return ageInput;
    }

}