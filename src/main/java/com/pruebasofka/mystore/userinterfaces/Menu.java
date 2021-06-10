package com.pruebasofka.mystore.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public final class Menu {

  public static final Target MENU_OPTION =
      Target.the("MyStore system menu option")
          .locatedBy("//div[@class='nav']//a[contains(text(), '{0}')]");
  public static final Target CATEGORIES_MENU =
      Target.the("Product categories menu")
          .locatedBy("//div[@id='block_top_menu']//a[text()='{0}']");
  public static final Target CATEGORY_OPTION =
      Target.the("Category option to select")
          .locatedBy(
              "//div[@id='block_top_menu']//a[text()='{0}']/following-sibling::ul//a[text()='{1}']/following-sibling::ul//a[text()='{2}']");

  private Menu() {}
}
