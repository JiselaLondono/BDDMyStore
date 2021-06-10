package com.pruebasofka.mystore.stepdefinitions;

import static com.pruebasofka.mystore.utils.Constants.MY_STORE_URL;
import static com.pruebasofka.mystore.utils.Generate.getProductsData;
import static com.pruebasofka.mystore.utils.enums.ErrorMessages.AMOUNT_PRESENTED_ERROR;
import static com.pruebasofka.mystore.utils.enums.ErrorMessages.EXPECTED_MESSAGE_ERROR;
import static com.pruebasofka.mystore.utils.enums.ErrorMessages.INVALID_ORDER_DATA_ERROR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import com.pruebasofka.mystore.exceptions.InvalidAmountException;
import com.pruebasofka.mystore.exceptions.InvalidMessageException;
import com.pruebasofka.mystore.exceptions.InvalidOrderInformationException;
import com.pruebasofka.mystore.models.Product;
import com.pruebasofka.mystore.questions.TheMessageOfTheOrder;
import com.pruebasofka.mystore.questions.TheOrderAmount;
import com.pruebasofka.mystore.questions.TheOrderInformation;
import com.pruebasofka.mystore.tasks.AddProductsToShoppingCart;
import com.pruebasofka.mystore.tasks.ConfirmSummary;
import com.pruebasofka.mystore.tasks.Login;
import com.pruebasofka.mystore.tasks.PayOrder;
import com.pruebasofka.mystore.tasks.SelectDeliveryAddress;
import com.pruebasofka.mystore.tasks.SelectShippingOption;
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

public class MakePurchaseOrderStepDefinitions {

  private List<Product> products;
  private String paymentMethod;

  @Managed(driver = "chrome")
  WebDriver herBrowser;

  @Before
  public void setStage() {
    OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(herBrowser)));
  }

  @Given("that {word} is a customer with an active MyStore account")
  public void loginOnMyStore(String actor) {
    theActorCalled(actor).wasAbleTo(Open.url(MY_STORE_URL), Login.onMyStore());
  }

  @When("she chooses the {string} that she wants to buy")
  public void chooseProducts(String productsFilter) throws IOException {
    products = getProductsData(productsFilter);
    theActorInTheSpotlight().attemptsTo(AddProductsToShoppingCart.ofTheList(products));
  }

  @When("she confirms the summary of the chosen products")
  public void confirmSummary() {
    theActorInTheSpotlight().attemptsTo(ConfirmSummary.ofTheSelectedProducts());
  }

  @When("she chooses the delivery address {string}")
  public void chooseDeliveryAddress(String address) {
    theActorInTheSpotlight().attemptsTo(SelectDeliveryAddress.named(address));
  }

  @When("she chooses {string} as the shipping option for her order")
  public void chooseShipping(String shippingType) {
    theActorInTheSpotlight().attemptsTo(SelectShippingOption.named(shippingType));
  }

  @When("she pays the order by {string}")
  public void payOrder(String paymentMethod) {
    this.paymentMethod = paymentMethod;
    theActorInTheSpotlight().attemptsTo(PayOrder.by(paymentMethod));
  }

  @Then("she should see the following message {string}")
  public void validateSuccessfulMessage(String message) {
    theActorInTheSpotlight()
        .should(
            seeThat(TheMessageOfTheOrder.paidBy(paymentMethod), equalTo(message))
                .orComplainWith(
                    InvalidMessageException.class, EXPECTED_MESSAGE_ERROR.getMessage()));
  }

  @Then("she should see that the total cost of the order is correct")
  public void validateOrderAmount() {
    theActorInTheSpotlight()
        .should(
            seeThat(TheOrderAmount.correspondsToTheProducts(products))
                .orComplainWith(InvalidAmountException.class, AMOUNT_PRESENTED_ERROR.getMessage()));
  }

  @Then("she should see that the order was recorded in her account's order history")
  public void validateOrderHistory() {
    theActorInTheSpotlight()
        .should(
            seeThat(
                    TheOrderInformation.isRecordedInTheHistory()
                        .withThePaymentMethod(paymentMethod))
                .orComplainWith(
                    InvalidOrderInformationException.class, INVALID_ORDER_DATA_ERROR.getMessage()));
  }
}
