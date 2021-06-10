package com.pruebasofka.mystore.interactions;

import static com.pruebasofka.mystore.userinterfaces.Catalog.ADD_TO_CART_BUTTON;
import static com.pruebasofka.mystore.userinterfaces.Catalog.COLOR_OPTION;
import static com.pruebasofka.mystore.userinterfaces.Catalog.MORE_BUTTON;
import static com.pruebasofka.mystore.userinterfaces.Catalog.PRICE;
import static com.pruebasofka.mystore.userinterfaces.Catalog.PRODUCT;
import static com.pruebasofka.mystore.userinterfaces.Catalog.QUANTITY;
import static com.pruebasofka.mystore.userinterfaces.Catalog.SIZE_LIST;
import static com.pruebasofka.mystore.utils.Constants.PESO_SIGN;
import static com.pruebasofka.mystore.utils.Constants.UNIT_PRICE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.pruebasofka.mystore.models.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class SelectProduct implements Interaction {

  private Product product;

  public SelectProduct(Product product) {
    this.product = product;
  }

  @Step("{0} selects the product with the required characteristics")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Move.toTheElement(PRODUCT.of(product.getName())),
        Click.on(MORE_BUTTON.of(product.getName())));
    actor.remember(UNIT_PRICE, getPrice(actor, PRICE));
    actor.attemptsTo(
        Enter.theValue(String.valueOf(product.getQuantity())).into(QUANTITY),
        SelectFromOptions.byVisibleText(product.getSize()).from(SIZE_LIST),
        Click.on(COLOR_OPTION.of(product.getColor())),
        Click.on(ADD_TO_CART_BUTTON));
  }

  public static SelectProduct indicatedIn(Product product) {
    return instrumented(SelectProduct.class, product);
  }

  public static Double getPrice(Actor actor, Target target) {
    return Double.parseDouble(Text.of(target).viewedBy(actor).asString().replace(PESO_SIGN, ""));
  }
}
