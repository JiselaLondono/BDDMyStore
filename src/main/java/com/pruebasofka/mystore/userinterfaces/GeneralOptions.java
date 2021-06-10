package com.pruebasofka.mystore.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public final class GeneralOptions {

  public static final Target PROCEED_TO_CHECKOUT =
      Target.the("Button to proceed to checkout")
          .locatedBy(
              "//p[@class='cart_navigation clearfix']//span[contains(text(),'Proceed to checkout')]");
  public static final Target CONFIRM_ORDER =
      Target.the("Button to confirm order")
          .locatedBy("//button[@type='submit']/span[text()='I confirm my order']");
  public static final Target BACK_TO_ORDERS =
      Target.the("Button to back to orders").locatedBy("//a[@title='Back to orders']");

  private GeneralOptions() {}
}
