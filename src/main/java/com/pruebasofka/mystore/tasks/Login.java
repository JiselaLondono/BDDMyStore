package com.pruebasofka.mystore.tasks;

import static com.pruebasofka.mystore.userinterfaces.Authentication.EMAIL_ADDRESS;
import static com.pruebasofka.mystore.userinterfaces.Authentication.PASSWORD;
import static com.pruebasofka.mystore.userinterfaces.Authentication.SIGN_IN_BUTTON;
import static com.pruebasofka.mystore.userinterfaces.Menu.MENU_OPTION;
import static com.pruebasofka.mystore.utils.Constants.CREDENTIALS_PROPERTIES_PATH;
import static com.pruebasofka.mystore.utils.Constants.EMAIL;
import static com.pruebasofka.mystore.utils.enums.MenuOptions.SIGN_IN;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.pruebasofka.mystore.utils.Constants;
import com.pruebasofka.mystore.utils.PropertiesReader;
import java.util.Properties;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class Login implements Task {

  @Step("{0} authenticates with email ******* and password *******")
  @Override
  public <T extends Actor> void performAs(T actor) {
    Properties credentials = PropertiesReader.getProperties(CREDENTIALS_PROPERTIES_PATH);
    actor.attemptsTo(
        Click.on(MENU_OPTION.of(SIGN_IN.getValue())),
        Enter.theValue(credentials.getProperty(EMAIL)).into(EMAIL_ADDRESS),
        Enter.theValue(credentials.getProperty(Constants.PASSWORD)).into(PASSWORD),
        Click.on(SIGN_IN_BUTTON));
  }

  public static Login onMyStore() {
    return instrumented(Login.class);
  }
}
