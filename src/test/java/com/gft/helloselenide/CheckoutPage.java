package com.gft.helloselenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// http://localhost:3000/#!/review
public class CheckoutPage {

    private SelenideElement btnConfirm = $(".btn-success");

    private SelenideElement fldAge = $("#ageInput");

    public void setAge(String age) {
        fldAge.sendKeys(age);
    }

    public OrderPage confirm() {
        btnConfirm.click();
        return page(OrderPage.class);
    }

}