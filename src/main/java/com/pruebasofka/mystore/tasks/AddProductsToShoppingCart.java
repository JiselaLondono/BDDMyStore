package com.pruebasofka.mystore.tasks;

import static com.pruebasofka.mystore.userinterfaces.Catalog.PRODUCT_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.pruebasofka.mystore.interactions.SelectCategory;
import com.pruebasofka.mystore.interactions.SelectProduct;
import com.pruebasofka.mystore.models.Product;
import java.util.List;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class AddProductsToShoppingCart implements Task {

  private List<Product> products;

  public AddProductsToShoppingCart(List<Product> products) {
    this.products = products;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    int productCounter = 0;
    for (Product product : products) {
      productCounter++;
      actor.attemptsTo(
          SelectCategory.named(product.getCategory()).andSubcategory(product.getSubcategory()),
          SelectProduct.aaaaa(product).bbbb("More"));

      product.setPrice(actor.recall("Price"));

      if (productCounter < products.size()) {
        actor.attemptsTo(Click.on(PRODUCT_BUTTON.of("Continue shopping")));
      }
    }

    actor.attemptsTo(Click.on(PRODUCT_BUTTON.of("Proceed to checkout")));
  }

  public static AddProductsToShoppingCart ofTheList(List<Product> products) {
    return instrumented(AddProductsToShoppingCart.class, products);
  }
}
