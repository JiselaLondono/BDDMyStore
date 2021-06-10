package com.pruebasofka.mystore.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public final class OrderHistory {
  public static final Target TOTAL_PRICE_TEXT =
      Target.the("Total price value of the order")
          .locatedBy("../following-sibling::td/span[@class='price']");
  public static final Target PAYMENT_TEXT =
      Target.the("Payment method of the order")
          .locatedBy("../following-sibling::td[@class='history_method']");
  public static final Target ORDER =
      Target.the("Order codes registered")
          .locatedBy("//table[@id='order-list']//td[contains(@class, 'history_link')]/a");

  private OrderHistory() {}
}
