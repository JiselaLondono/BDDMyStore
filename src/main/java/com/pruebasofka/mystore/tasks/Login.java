package com.pruebasofka.mystore.tasks;

import static com.pruebasofka.mystore.userinterfaces.Authentication.*;
import static com.pruebasofka.mystore.userinterfaces.Menu.MENU_OPTION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.pruebasofka.mystore.utils.PropertiesReader;
import java.util.Properties;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Login implements Task {

  @Override
  public <T extends Actor> void performAs(T actor) {
    Properties credentials = PropertiesReader.getProperties("./credentials.properties");
    actor.attemptsTo(
        Click.on(MENU_OPTION.of("Sign in")),
        Enter.theValue(credentials.getProperty("email_address")).into(EMAIL_ADDRESS),
        Enter.theValue(credentials.getProperty("password")).into(PASSWORD),
        Click.on(SIGN_IN_BUTTON));
  }

  public static Login onMyStore() {
    return instrumented(Login.class);
  }
}
