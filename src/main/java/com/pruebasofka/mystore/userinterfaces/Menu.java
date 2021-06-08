package com.pruebasofka.mystore.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Menu {

  public static final Target MENU_OPTION =
      Target.the("Menu option").locatedBy("//div[@class='nav']//a[contains(text(), '{0}')]");

  public static final Target CATEGORY_MENU =
      Target.the("Category Menu").locatedBy("//div[@id='block_top_menu']//a[text()='{0}']");

  public static final Target CATEGORY_SUBMENU =
      Target.the("Category SubMenu")
          .locatedBy(
              "//div[@id='block_top_menu']//a[text()='{0}']/following-sibling::ul//a[text()='{1}']/following-sibling::ul//a[text()='{2}']");
}
