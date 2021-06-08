package com.pruebasofka.mystore.tasks;

import static com.pruebasofka.mystore.userinterfaces.GeneralOptions.NEXT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ConfirmPurchaseSummary implements Task {
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(NEXT.of("Proceed to checkout")));
  }

  public static ConfirmPurchaseSummary ok() {
    return instrumented(ConfirmPurchaseSummary.class);
  }
}
