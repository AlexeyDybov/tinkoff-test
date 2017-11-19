package ru.tinkoff.steps.payments;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import qa.abstracts.Steps;
import ru.tinkoff.data.Region;
import ru.tinkoff.data.payments.PaymentCategory;
import ru.tinkoff.data.payments.categories.Payment;
import ru.tinkoff.pages.payments.PaymentsCategoryPage;
import ru.yandex.qatools.allure.annotations.Step;

public class PaymentsCategorySteps extends Steps {

    private PaymentsCategoryPage paymentsCategoryPage;

    public PaymentsCategorySteps(WebDriver driver) {
        super(driver);
        paymentsCategoryPage = PageFactory.initElements(driver, PaymentsCategoryPage.class);
    }

    @Step
    public void paymentCategoryShouldBeOpened(PaymentCategory paymentCategory) {
        Assert.assertTrue("Не открылась страница категории платежей", paymentsCategoryPage.isOpened(paymentCategory));
    }

    @Step
    public void regionShouldBeEqual(Region region) {
        Assert.assertTrue("Неверно выбран регион", paymentsCategoryPage.isRegionSelected(region));
    }

    @Step
    public void selectPayment(Payment payment) {
        paymentsCategoryPage.openPayment(payment);
    }
}
