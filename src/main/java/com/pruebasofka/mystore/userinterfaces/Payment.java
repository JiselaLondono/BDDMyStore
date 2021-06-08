package com.pruebasofka.mystore.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Payment {
  public static final Target PAYMENT_METHOD =
      Target.the("Payment method")
          .locatedBy("//div[@id='HOOK_PAYMENT']//a[contains(text(), '{0}')]");
}
