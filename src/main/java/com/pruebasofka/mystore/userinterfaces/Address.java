package com.pruebasofka.mystore.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class Address {

  public static final Target ADDRESS_LIST =
      Target.the("Selection list to choose delivery address").located(By.id("id_address_delivery"));
  public static final Target WAIT_IMAGE =
      Target.the("Loading element")
          .locatedBy(
              "//div[@id='uniform-id_address_delivery']/following-sibling::span[@class='waitimage']");

  private Address() {}
}
