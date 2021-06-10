package com.pruebasofka.mystore.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class Authentication {

  public static final Target EMAIL_ADDRESS =
      Target.the("Text field to type email").located(By.id("email"));
  public static final Target PASSWORD =
      Target.the("Text field to type password").located(By.id("passwd"));
  public static final Target SIGN_IN_BUTTON =
      Target.the("Button to authenticate to the MyStore system").located(By.id("SubmitLogin"));

  private Authentication() {}
}
