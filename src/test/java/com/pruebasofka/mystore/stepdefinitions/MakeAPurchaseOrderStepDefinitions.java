package com.pruebasofka.mystore.stepdefinitions;

import static com.pruebasofka.mystore.utils.Generate.getProductsData;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.pruebasofka.mystore.models.Product;
import com.pruebasofka.mystore.tasks.AddProductsToShoppingCart;
import com.pruebasofka.mystore.tasks.Login;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.util.List;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class MakeAPurchaseOrderStepDefinitions {

  private List<Product> products;

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

  @When("she chooses the {word} she wants to buy")
  public void chooseProducts(String filter) throws IOException {
    products = getProductsData(filter);
    theActorInTheSpotlight().attemptsTo(AddProductsToShoppingCart.ofTheList(products));
  }
}
