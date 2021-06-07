package com.pruebasofka.mystore.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Menu {

  public static final Target MENU_OPTION =
      Target.the("Menu option").locatedBy("//div[@class='nav']//a[contains(text(), '{0}')]");
}
