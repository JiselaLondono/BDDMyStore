package com.pruebasofka.mystore.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Address {
  public static final Target ADDRESS = Target.the("Address").located(By.id("id_address_delivery"));
}
