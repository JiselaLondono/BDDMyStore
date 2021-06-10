package com.pruebasofka.mystore.interactions;

import static com.pruebasofka.mystore.userinterfaces.Menu.CATEGORIES_MENU;
import static com.pruebasofka.mystore.userinterfaces.Menu.CATEGORY_OPTION;
import static com.pruebasofka.mystore.utils.enums.MenuOptions.WOMEN;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class SelectCategory implements Interaction {

  private String subcategory;
  private String category;

  public SelectCategory(String category) {
    this.category = category;
  }

  @Step("{0} selects the category and subcategory of the product")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Move.toTheElement(CATEGORIES_MENU.of(WOMEN.getValue())),
        Click.on(CATEGORY_OPTION.of(WOMEN.getValue(), category, subcategory)));
  }

  public static SelectCategory named(String category) {
    return instrumented(SelectCategory.class, category);
  }

  public SelectCategory andSubcategory(String subcategory) {
    this.subcategory = subcategory;
    return this;
  }
}
