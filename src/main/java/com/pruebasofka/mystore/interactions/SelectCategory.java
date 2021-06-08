package com.pruebasofka.mystore.interactions;

import static com.pruebasofka.mystore.userinterfaces.Menu.CATEGORY_MENU;
import static com.pruebasofka.mystore.userinterfaces.Menu.CATEGORY_SUBMENU;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

public class SelectCategory implements Interaction {
  private String subcategory;
  private String category;

  public SelectCategory(String category) {
    this.category = category;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Move.toTheElement(CATEGORY_MENU.of("Women")),
        Click.on(CATEGORY_SUBMENU.of("Women", category, subcategory)));
  }

  public static SelectCategory named(String category) {
    return instrumented(SelectCategory.class, category);
  }

  public SelectCategory andSubcategory(String subcategory) {
    this.subcategory = subcategory;
    return this;
  }
}
