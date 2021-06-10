package com.pruebasofka.mystore.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class Shipping {

  public static final Target SHIPPING_PRICE =
      Target.the("Shipping displayed price")
          .locatedBy(
              "//div[@class='delivery_options']//td/strong[contains(text(), '{0}')]/ancestor::tr//div[@class='delivery_option_price']");
  public static final Target TERMS_OF_SERVICE_CHECK =
      Target.the("Check to accept the terms of service").located(By.id("cgv"));

  private Shipping() {}
}
