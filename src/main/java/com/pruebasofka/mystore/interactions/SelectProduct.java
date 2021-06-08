package com.pruebasofka.mystore.interactions;

import static com.pruebasofka.mystore.userinterfaces.Catalog.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.pruebasofka.mystore.models.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class SelectProduct implements Interaction {

  private Product product;
  private String option;

  public SelectProduct(Product product) {
    this.product = product;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Move.toTheElement(PRODUCT.of(product.getName())));
    actor.attemptsTo(Click.on(PRODUCT_OPTION.of(product.getName(), option)));
    if (option.equals("More")) {

      actor.remember("Price", getPrice(actor, PRICE));

      actor.attemptsTo(
          Enter.theValue(String.valueOf(product.getQuantity())).into(QUANTITY),
          SelectFromOptions.byVisibleText(product.getSize()).from(SIZE),
          Click.on(COLOR.of(product.getColor())),
          Click.on(ADD_TO_CART));
    }
  }

  public static SelectProduct aaaaa(Product product) {
    return instrumented(SelectProduct.class, product);
  }

  public SelectProduct bbbb(String option) {
    this.option = option;
    return this;
  }

  public static Double getPrice(Actor actor, Target target) {
    return Double.parseDouble(Text.of(target).viewedBy(actor).asString().replace("$", ""));
  }
}
