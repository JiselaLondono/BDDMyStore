package com.pruebasofka.mystore.questions;

import static com.pruebasofka.mystore.userinterfaces.GeneralOptions.NEXT_2;
import static com.pruebasofka.mystore.userinterfaces.OrderHistory.*;

import com.pruebasofka.mystore.interactions.GetOrderReference;
import java.util.List;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;

public class OrderInformation implements Question<Boolean> {
  private String paymentMethod;

  @Override
  public Boolean answeredBy(Actor actor) {
    actor.attemptsTo(GetOrderReference.fromThePaymentMethod(paymentMethod));
    actor.attemptsTo(Click.on(NEXT_2.of("Back to orders")));

    List<WebElementFacade> orders =
        ORDER.resolveAllFor(actor).subList(0, ORDER.resolveAllFor(actor).size());

    for (WebElementFacade webElementFacade : orders) {
      if (webElementFacade.getText().equals(actor.recall("OrderReference"))) {
        return validatePrice(actor, webElementFacade) && validatePayment(webElementFacade);
      }
    }
    return false;
  }

  public static OrderInformation isCorrect() {
    return new OrderInformation();
  }

  public OrderInformation lalalka(String paymentMethod) {
    this.paymentMethod = paymentMethod;
    return this;
  }

  private boolean validatePrice(Actor actor, WebElementFacade webElementFacade) {
    Double amountCalculated = actor.recall("amount");
    String price =
        webElementFacade
            .find(By.xpath(TOTAL_PRICE_TEXT.getCssOrXPathSelector()))
            .getText()
            .replace("$", "");
    if (Double.parseDouble(price) == amountCalculated) {
      return true;
    }
    return false;
  }

  private boolean validatePayment(WebElementFacade webElementFacade) {
    String payment =
        webElementFacade.find(By.xpath(PAYMENT_TEXT.getCssOrXPathSelector())).getText();
    if (payment.toLowerCase().contains(paymentMethod.toLowerCase())) {
      return true;
    }
    return false;
  }
}
