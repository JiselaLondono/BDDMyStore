package com.pruebasofka.mystore.stepdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.pruebasofka.mystore.tasks.Login;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class MakeAPurchaseOrderStepDefinitions {

  @Managed private WebDriver herBrowser;

  @Before
  public void setStage() {
    OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(herBrowser)));
  }

  @Given("that {word} is a customer with an active MyStore account")
  public void thatJiselaIsACustomerWithAnActiveMyStoreAccount(String actor) {
    theActorCalled(actor).wasAbleTo(Open.url("http://automationpractice.com"));
    theActorInTheSpotlight().wasAbleTo(Login.onMyStore());
  }
}
