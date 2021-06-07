package com.pruebasofka.mystore.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Authentication {
  public static final Target EMAIL_ADDRESS = Target.the("Email address").located(By.id("email"));
  public static final Target PASSWORD = Target.the("Password").located(By.id("passwd"));
  public static final Target SIGN_IN_BUTTON =
      Target.the("Sign in button").located(By.id("SubmitLogin"));
}
