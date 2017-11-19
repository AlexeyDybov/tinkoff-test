package ru.tinkoff.steps.payments;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import qa.abstracts.Steps;
import ru.tinkoff.elements.payments.Card2CardPaymentElement;
import ru.tinkoff.elements.payments.SearchPaymentElement;
import ru.yandex.qatools.allure.annotations.Step;

public class SearchPaymentSteps extends Steps {

    private SearchPaymentElement searchPaymentElement;

    public SearchPaymentSteps(WebDriver driver) {
        super(driver);
        searchPaymentElement = PageFactory.initElements(driver, SearchPaymentElement.class);
    }

    @Step
    public void elementShouldBePresent() {
        Assert.assertTrue("Блок поиска платежа должен отображаться", searchPaymentElement.isPresent());
    }
}
