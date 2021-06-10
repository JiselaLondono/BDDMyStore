package com.pruebasofka.mystore.questions;

import static com.pruebasofka.mystore.userinterfaces.GeneralOptions.BACK_TO_ORDERS;
import static com.pruebasofka.mystore.userinterfaces.OrderHistory.*;
import static com.pruebasofka.mystore.utils.Constants.AMOUNT;
import static com.pruebasofka.mystore.utils.Constants.ORDER_CODE;
import static com.pruebasofka.mystore.utils.Constants.PESO_SIGN;
import static com.pruebasofka.mystore.utils.enums.ErrorMessages.ORDER_NOT_FOUND_ERROR;
import static com.pruebasofka.mystore.utils.enums.ErrorMessages.PAYMENT_METHOD_ERROR;
import static com.pruebasofka.mystore.utils.enums.ErrorMessages.TOTAL_ORDER_PRICE_ERROR;
import static com.pruebasofka.mystore.utils.enums.InformationMessages.ORDER_FOUND_MESSAGE;
import static com.pruebasofka.mystore.utils.enums.InformationMessages.PAYMENT_METHOD_MESSAGE;
import static com.pruebasofka.mystore.utils.enums.InformationMessages.PRICE_VALIDATION_MESSAGE;

import com.pruebasofka.mystore.interactions.GetOrderReference;
import java.util.List;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheOrderInformation implements Question<Boolean> {

  private static final Logger LOGGER = LoggerFactory.getLogger(TheOrderInformation.class);
  private String paymentMethod;

  @Override
  public Boolean answeredBy(Actor actor) {
    actor.attemptsTo(
        GetOrderReference.forThePaymentMethod(paymentMethod), Click.on(BACK_TO_ORDERS));
    List<WebElementFacade> orders =
        ORDER.resolveAllFor(actor).subList(0, ORDER.resolveAllFor(actor).size());
    for (WebElementFacade webElementFacade : orders) {
      if (webElementFacade.getText().equals(actor.recall(ORDER_CODE))) {
        LOGGER.info(String.format(ORDER_FOUND_MESSAGE.getMessage(), actor.recall(ORDER_CODE)));
        return validatePrice(actor, webElementFacade) && validatePayment(webElementFacade);
      }
    }
    LOGGER.error(String.format(ORDER_NOT_FOUND_ERROR.getMessage(), actor.recall(ORDER_CODE)));
    return false;
  }

  public static TheOrderInformation isRecordedInTheHistory() {
    return new TheOrderInformation();
  }

  public TheOrderInformation withThePaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
    return this;
  }

  private boolean validatePrice(Actor actor, WebElementFacade webElementFacade) {
    Double amountCalculated = actor.recall(AMOUNT);
    String price =
        webElementFacade
            .find(By.xpath(TOTAL_PRICE_TEXT.getCssOrXPathSelector()))
            .getText()
            .replace(PESO_SIGN, "");
    if (Double.parseDouble(price) != amountCalculated) {
      LOGGER.error(String.format(TOTAL_ORDER_PRICE_ERROR.getMessage(), amountCalculated, price));
      return false;
    }
    LOGGER.info(PRICE_VALIDATION_MESSAGE.getMessage());
    return true;
  }

  private boolean validatePayment(WebElementFacade webElementFacade) {
    String payment =
        webElementFacade.find(By.xpath(PAYMENT_TEXT.getCssOrXPathSelector())).getText();
    if (!payment.toLowerCase().contains(paymentMethod.toLowerCase())) {
      LOGGER.error(PAYMENT_METHOD_ERROR.getMessage());
      return false;
    }
    LOGGER.info(PAYMENT_METHOD_MESSAGE.getMessage());
    return true;
  }
}
