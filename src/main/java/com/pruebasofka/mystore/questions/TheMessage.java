package com.pruebasofka.mystore.questions;

import com.pruebasofka.mystore.exceptions.InvalidValueException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheMessage implements Question<String> {
    private String paymentMethod;

    public TheMessage(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String answeredBy(Actor actor) {
        switch (paymentMethod){
            case "Bank wire":
                return "";
            case "Check":
                return "";
            default:
                throw new InvalidValueException("EL payment method " + paymentMethod + " is invalid.");
        }
    }

    public static TheMessage forThePaymentMethod(String paymentMethod) {
        return new TheMessage(paymentMethod);
    }
}
