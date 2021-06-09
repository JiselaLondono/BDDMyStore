package com.pruebasofka.mystore.tasks;

import static com.pruebasofka.mystore.userinterfaces.Address.ADDRESS;
import static com.pruebasofka.mystore.userinterfaces.Address.WAIT_IMAGE;
import static com.pruebasofka.mystore.userinterfaces.GeneralOptions.NEXT;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SelectDeliveryAddress implements Task {

  private String address;

  public SelectDeliveryAddress(String address) {
    this.address = address;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        SelectFromOptions.byVisibleText(address).from(ADDRESS),
        WaitUntil.the(WAIT_IMAGE, isNotVisible()),
        // WaitUntil.the(NEXT.of("Proceed to checkout"), isClickable()),
        Click.on(NEXT.of("Proceed to checkout")));
  }

  public static SelectDeliveryAddress named(String address) {
    return instrumented(SelectDeliveryAddress.class, address);
  }
}
