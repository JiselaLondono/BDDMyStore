package com.pruebasofka.mystore.questions;

import com.pruebasofka.mystore.models.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class ValidateAmount implements Question<Boolean> {
    private List<Product> products;
    private String paymentMethod;

    public ValidateAmount(List<Product> products) {
        this.products = products;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        double finalAmount = 0.0;

        for(Product product : products) {
            finalAmount = finalAmount + (product.getPrice() * product.getQuantity());
        }

        finalAmount = finalAmount + Double.parseDouble(actor.recall("DeliveryPrice"));

        return null;
    }

    public static ValidateAmount forTheProducts(List<Product> products) {
        return new ValidateAmount(products);
    }

    public ValidateAmount andThePaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }
}


