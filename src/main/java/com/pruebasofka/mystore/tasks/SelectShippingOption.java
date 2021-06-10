package com.pruebasofka.mystore.tasks;

import static com.pruebasofka.mystore.interactions.SelectProduct.getPrice;
import static com.pruebasofka.mystore.userinterfaces.GeneralOptions.PROCEED_TO_CHECKOUT;
import static com.pruebasofka.mystore.userinterfaces.Shipping.SHIPPING_PRICE;
import static com.pruebasofka.mystore.userinterfaces.Shipping.TERMS_OF_SERVICE_CHECK;
import static com.pruebasofka.mystore.utils.Constants.DELIVERY_PRICE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class SelectShippingOption implements Task {

  private String shippingOption;

  public SelectShippingOption(String shippingOption) {
    this.shippingOption = shippingOption;
  }

  @Step("{0} chooses the shipping option for her order")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.remember(DELIVERY_PRICE, getPrice(actor, SHIPPING_PRICE.of(shippingOption)));
    actor.attemptsTo(Click.on(TERMS_OF_SERVICE_CHECK), Click.on(PROCEED_TO_CHECKOUT));
  }

  public static SelectShippingOption named(String shippingOption) {
    return instrumented(SelectShippingOption.class, shippingOption);
  }
}
