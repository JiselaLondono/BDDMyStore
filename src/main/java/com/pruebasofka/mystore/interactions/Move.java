package com.pruebasofka.mystore.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.interactions.Actions;

public class Move implements Interaction {
  private Target target;

  public Move(Target target) {
    this.target = target;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    Actions action = new Actions(BrowseTheWeb.as(actor).getDriver());
    action.moveToElement(target.resolveFor(actor).getElement()).perform();
  }

  public static Move toTheElement(Target target) {
    return instrumented(Move.class, target);
  }
}
