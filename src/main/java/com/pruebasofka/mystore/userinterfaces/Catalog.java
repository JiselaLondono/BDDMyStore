package com.pruebasofka.mystore.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class Catalog {

  public static final Target PRODUCT =
      Target.the("Product overview")
          .locatedBy(
              "//ul[@class='product_list grid row']//a[@class='product-name' and contains(text(),'{0}')]");
  public static final Target MORE_BUTTON =
      Target.the("Button to see more details of the product")
          .locatedBy(
              "//ul[@class='product_list grid row']//a[@class='product-name' and contains(text(),'{0}')]/../../div[@class='button-container']//span[text()='More']");
  public static final Target QUANTITY =
      Target.the("Text field to type quantity to buy").located(By.id("quantity_wanted"));
  public static final Target SIZE_LIST =
      Target.the("Selection list to choose size").located(By.id("group_1"));
  public static final Target COLOR_OPTION =
      Target.the("Option to choose product color")
          .locatedBy("//ul[@id='color_to_pick_list']//a[@name='{0}']");
  public static final Target ADD_TO_CART_BUTTON =
      Target.the("Button to add product to cart").locatedBy("//p[@id='add_to_cart']/button");
  public static final Target PROCEED_CHECKOUT_BUTTON =
      Target.the("Button to proceed to checkout")
          .locatedBy("//a[@title='Proceed to checkout']/span");
  public static final Target CONTINUE_SHOPPING_BUTTON =
      Target.the("Button to continue shopping")
          .locatedBy("//span[@title='Continue shopping']/span");
  public static final Target PRICE =
      Target.the("Product displayed price").located(By.id("our_price_display"));

  private Catalog() {}
}
