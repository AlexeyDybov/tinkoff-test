package ru.tinkoff.elements.payments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.abstracts.Pages;

public class Card2CardPaymentElement extends Pages {

    @FindBy(css = ".ui-card-2-card_payments-page")
    private WebElement card2CardPaymentForm;

    public Card2CardPaymentElement(WebDriver driver) {
        super(driver);
    }

    public boolean isPresent() {
        return waitForElementPresent(card2CardPaymentForm);
    }
}
