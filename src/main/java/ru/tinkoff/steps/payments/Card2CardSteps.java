package ru.tinkoff.steps.payments;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import qa.abstracts.Steps;
import ru.tinkoff.elements.payments.Card2CardPaymentElement;
import ru.yandex.qatools.allure.annotations.Step;

public class Card2CardSteps extends Steps {

    private Card2CardPaymentElement card2CardPaymentElement;

    public Card2CardSteps(WebDriver driver) {
        super(driver);
        card2CardPaymentElement = PageFactory.initElements(driver, Card2CardPaymentElement.class);
    }

    @Step
    public void elementShouldBePresent() {
        Assert.assertTrue("Блок перевод между картами должен отображаться", card2CardPaymentElement.isPresent());
    }
}
