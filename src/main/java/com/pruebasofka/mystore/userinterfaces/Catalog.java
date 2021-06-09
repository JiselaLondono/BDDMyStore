package com.pruebasofka.mystore.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Catalog {

  public static final Target PRODUCT =
      Target.the("Product")
          .locatedBy(
              "//ul[@class='product_list grid row']//a[@class='product-name' and contains(text(),'{0}')]");
  public static final Target PRODUCT_OPTION =
      Target.the("Product option")
          .locatedBy(
              "//ul[@class='product_list grid row']//a[@class='product-name' and contains(text(),'{0}')]/../../div[@class='button-container']//span[text()='{1}']");
  public static final Target QUANTITY = Target.the("Quantity").located(By.id("quantity_wanted"));
  public static final Target SIZE = Target.the("Size").located(By.id("group_1"));
  public static final Target COLOR =
      Target.the("Color").locatedBy("//ul[@id='color_to_pick_list']//a[@name='{0}']");
  public static final Target ADD_TO_CART =
      Target.the("Add to cart").locatedBy("//p[@id='add_to_cart']/button");
  public static final Target PROCEED_CHECKOUT_BUTTON =
      Target.the("Button to proceed to checkout")
          .locatedBy("//a[@title='Proceed to checkout']/span");
  public static final Target CONTINUE_SHOPPING_BUTTON =
      Target.the("Button to continue shopping")
          .locatedBy("//span[@title='Continue shopping']/span");

  public static final Target PRICE = Target.the("Price").located(By.id("our_price_display"));
}
