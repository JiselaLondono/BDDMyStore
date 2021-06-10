package com.pruebasofka.mystore.tasks;

import static com.pruebasofka.mystore.userinterfaces.Catalog.CONTINUE_SHOPPING_BUTTON;
import static com.pruebasofka.mystore.userinterfaces.Catalog.PROCEED_CHECKOUT_BUTTON;
import static com.pruebasofka.mystore.utils.Constants.UNIT_PRICE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import com.pruebasofka.mystore.interactions.SelectCategory;
import com.pruebasofka.mystore.interactions.SelectProduct;
import com.pruebasofka.mystore.models.Product;
import java.util.List;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

public class AddProductsToShoppingCart implements Task {

  private List<Product> products;

  public AddProductsToShoppingCart(List<Product> products) {
    this.products = products;
  }

  @Step("{0} chooses the products to buy and adds them to the shopping cart")
  @Override
  public <T extends Actor> void performAs(T actor) {
    int productCounter = 0;
    for (Product product : products) {
      productCounter++;
      actor.attemptsTo(
          SelectCategory.named(product.getCategory()).andSubcategory(product.getSubcategory()),
          SelectProduct.indicatedIn(product));
      product.setPrice(actor.recall(UNIT_PRICE));
      actor.attemptsTo(
          Check.whether(productCounter < products.size())
              .andIfSo(
                  WaitUntil.the(CONTINUE_SHOPPING_BUTTON, isVisible()),
                  Click.on(CONTINUE_SHOPPING_BUTTON)));
    }
    actor.attemptsTo(
        WaitUntil.the(PROCEED_CHECKOUT_BUTTON, isClickable()), Click.on(PROCEED_CHECKOUT_BUTTON));
  }

  public static AddProductsToShoppingCart ofTheList(List<Product> products) {
    return instrumented(AddProductsToShoppingCart.class, products);
  }
}
