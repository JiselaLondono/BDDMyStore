package com.pruebasofka.mystore.stepdefinitions;

import static com.pruebasofka.mystore.utils.Generate.getProductsData;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import com.pruebasofka.mystore.exceptions.InvalidMessageException;
import com.pruebasofka.mystore.models.Product;
import com.pruebasofka.mystore.questions.OrderInformation;
import com.pruebasofka.mystore.questions.TheMessage;
import com.pruebasofka.mystore.questions.TheOrderAmount;
import com.pruebasofka.mystore.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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
  private String paymentMethod;

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

  @When("she confirm her purchase")
  public void confirmSummary() {
    theActorInTheSpotlight().attemptsTo(ConfirmPurchaseSummary.ok());
  }

  @When("she chooses the delivery address {string}")
  public void chooseAddress(String address) {
    theActorInTheSpotlight().attemptsTo(SelectDeliveryAddress.named(address));
  }

  @When("she chooses a shipping option for her address {string}")
  public void chooseShipping(String shippingType) {
    theActorInTheSpotlight().attemptsTo(SelectShippingOption.named(shippingType));
  }

  @When("she chooses to pay by {string} and confirms her order")
  public void choosePaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
    theActorInTheSpotlight().attemptsTo(SelectPaymentMethod.named(paymentMethod));
  }

  @Then("she should see the following message {string}")
  public void succesfulMessage(String message) {
    theActorInTheSpotlight()
        .should(
            seeThat(TheMessage.forThePaymentMethod(paymentMethod), equalTo(message))
                .orComplainWith(InvalidMessageException.class, "MENSAJE ERRADO"));
  }

  @Then("she should see that the total cost of the order is correct")
  public void validateOrderAmount() {
    theActorInTheSpotlight()
        .should(
            seeThat(TheOrderAmount.correspondsToTheProducts(products))
                .orComplainWith(InvalidMessageException.class, "MENSAJE ERRADO"));
  }

  @Then("she should see that the order was recorded in her account's order history")
  public void validateOrder() {
    theActorInTheSpotlight().should(seeThat(OrderInformation.isCorrect().lalalka(paymentMethod)));
  }
}
