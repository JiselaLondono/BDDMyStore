package com.pruebasofka.mystore.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class GeneralOptions {

  public static final Target NEXT =
      Target.the("Option")
          .locatedBy("//p[@class='cart_navigation clearfix']//span[contains(text(),'{0}')]");
}
