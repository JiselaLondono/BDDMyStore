package com.pruebasofka.mystore.tasks;

import static com.pruebasofka.mystore.userinterfaces.Address.ADDRESS_LIST;
import static com.pruebasofka.mystore.userinterfaces.Address.WAIT_IMAGE;
import static com.pruebasofka.mystore.userinterfaces.GeneralOptions.PROCEED_TO_CHECKOUT;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

public class SelectDeliveryAddress implements Task {

  private String address;

  public SelectDeliveryAddress(String address) {
    this.address = address;
  }

  @Step("{0} selects the delivery address of the order")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        SelectFromOptions.byVisibleText(address).from(ADDRESS_LIST),
        WaitUntil.the(WAIT_IMAGE, isNotVisible()),
        Click.on(PROCEED_TO_CHECKOUT));
  }

  public static SelectDeliveryAddress named(String address) {
    return instrumented(SelectDeliveryAddress.class, address);
  }
}
