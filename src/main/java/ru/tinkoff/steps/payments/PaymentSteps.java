package ru.tinkoff.steps.payments;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import qa.abstracts.Steps;
import qa.annotations.At;
import ru.tinkoff.data.errors.Error;
import ru.tinkoff.data.payments.PaymentField;
import ru.tinkoff.data.payments.categories.Payment;
import ru.tinkoff.pages.payments.ExtraPaymentPage;
import ru.yandex.qatools.allure.annotations.Step;

public class PaymentSteps extends Steps {

    private ExtraPaymentPage extraPaymentPage;

    public PaymentSteps(WebDriver driver) {
        super(driver);
        extraPaymentPage = PageFactory.initElements(driver, ExtraPaymentPage.class);
    }

    @Step
    public void openExtraPaymentPage(Payment payment) {
        extraPaymentPage.openAt(payment.getLinkName());
    }

    @Step
    public void extraPaymentPageShouldBeOpened(Payment payment) {
        Assert.assertTrue(String.format("Страница платежа <%s> должна быть открыта", payment.getName()),
                extraPaymentPage.isExtraPageOpened() && extraPaymentPage.isPayTabPresent(payment));
    }

    @Step
    public void selectPayTab(Payment payment) {
        extraPaymentPage.selectPayTab(payment);
    }

    @Step
    public void payFormShouldBePresent(Payment payment) {
        Assert.assertTrue(String.format("Не открылась форма платежа для <%s>", payment.getName()),
                extraPaymentPage.isPayFormPresent());
    }



    @Step
    public void setField(PaymentField field, String fieldValue) {
        extraPaymentPage.setField(field, fieldValue);
    }

    @Step
    public void errorShouldBePresent(PaymentField field, Error error) {
        Assert.assertTrue("Поле должно быть выделено как ошибочное", extraPaymentPage.isErrorPresent(field));
        Assert.assertEquals("Неверный текст ошибки", error.getDescription(), extraPaymentPage.getErrorText(field));
    }
}
