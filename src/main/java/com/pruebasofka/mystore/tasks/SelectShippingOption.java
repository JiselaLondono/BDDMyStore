package com.pruebasofka.mystore.tasks;

import static com.pruebasofka.mystore.interactions.SelectProduct.getPrice;
import static com.pruebasofka.mystore.userinterfaces.GeneralOptions.NEXT;
import static com.pruebasofka.mystore.userinterfaces.Shipping.SHIPPING_PRICE;
import static com.pruebasofka.mystore.userinterfaces.Shipping.TERMS_OF_SERVICE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SelectShippingOption implements Task {
  private String shippingOption;

  public SelectShippingOption(String shippingOption) {
    this.shippingOption = shippingOption;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.remember("DeliveryPrice", getPrice(actor, SHIPPING_PRICE.of(shippingOption)));
    actor.attemptsTo(Click.on(TERMS_OF_SERVICE), Click.on(NEXT.of("Proceed to checkout")));
  }

  public static SelectShippingOption named(String shippingOption) {
    return instrumented(SelectShippingOption.class, shippingOption);
  }
}
