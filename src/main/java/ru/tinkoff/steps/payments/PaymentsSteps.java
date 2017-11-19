package ru.tinkoff.steps.payments;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import qa.abstracts.Steps;
import ru.tinkoff.data.errors.Error;
import ru.tinkoff.data.payments.PaymentCategory;
import ru.tinkoff.data.payments.PaymentField;
import ru.tinkoff.pages.payments.PaymentsPage;
import ru.yandex.qatools.allure.annotations.Step;

public class PaymentsSteps extends Steps {

    private PaymentsPage paymentsPage;
    private Card2CardSteps card2CardSteps;
    private SearchPaymentSteps searchPaymentSteps;

    public PaymentsSteps(WebDriver driver) {
        super(driver);
        paymentsPage = PageFactory.initElements(driver, PaymentsPage.class);
        card2CardSteps = new Card2CardSteps(driver);
        searchPaymentSteps = new SearchPaymentSteps(driver);
    }

    @Step
    public void paymentsPageShouldBeOpened() {
        Assert.assertTrue("Не открылась страница платежей", paymentsPage.isOpened());
        card2CardSteps.elementShouldBePresent();
        searchPaymentSteps.elementShouldBePresent();
    }

    @Step
    public void selectPaymentCategory(PaymentCategory paymentCategory) {
        paymentsPage.selectPaymentCategory(paymentCategory);
    }
}