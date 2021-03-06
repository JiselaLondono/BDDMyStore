package com.pruebasofka.mystore.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public final class Payment {

  public static final Target PAYMENT_METHOD =
      Target.the("Element to choose payment method")
          .locatedBy("//div[@id='HOOK_PAYMENT']//a[contains(text(), '{0}')]");
  public static final Target ORDER_COMPLETED_CHECK_MSG =
      Target.the("Order completed message with payment method by check")
          .locatedBy("//div[@id='center_column']/p[@class='alert alert-success']");
  public static final Target ORDER_COMPLETED_BANK_MSG =
      Target.the("Order completed message with payment method by bank")
          .locatedBy("//div[@class='box']/p[@class='cheque-indent']/strong");
  public static final Target PAYMENT_AMOUNT =
      Target.the("Total payment amount value of the order")
          .locatedBy("//span[@class='price']/strong");
  public static final Target ORDER_DATA_FOR_CHECK =
      Target.the("Order information for check").locatedBy("//div[@class='box order-confirmation']");
  public static final Target ORDER_DATA_FOR_BANK_WIRE =
      Target.the("Order information for bank wire").locatedBy("//div[@class='box']");

  private Payment() {}
}
