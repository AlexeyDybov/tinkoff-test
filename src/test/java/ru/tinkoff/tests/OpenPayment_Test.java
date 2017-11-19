package ru.tinkoff.tests;

import org.junit.Before;
import org.junit.Test;
import qa.driver.WebDriverFactory;
import ru.tinkoff.data.MainMenuItem;
import ru.tinkoff.data.Region;
import ru.tinkoff.data.errors.Error;
import ru.tinkoff.data.payments.PaymentCategory;
import ru.tinkoff.data.payments.PaymentField;
import ru.tinkoff.data.payments.categories.Payment;
import ru.tinkoff.steps.main.MainSteps;
import ru.tinkoff.steps.payments.PaymentSteps;
import ru.tinkoff.steps.payments.PaymentsCategorySteps;
import ru.tinkoff.steps.payments.PaymentsSteps;

public class OpenPayment_Test extends BaseTest {

    private MainSteps mainSteps;
    private PaymentsSteps paymentsSteps;
    private PaymentsCategorySteps paymentsCategorySteps;
    private PaymentSteps paymentSteps;

    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriverInstance();
        mainSteps = new MainSteps(driver);
        paymentsSteps = new PaymentsSteps(driver);
        paymentsCategorySteps = new PaymentsCategorySteps(driver);
        paymentSteps = new PaymentSteps(driver);
    }

    @Test
    public void open_payments() {
        mainSteps.openPage();
        mainSteps.clickMenuItem(MainMenuItem.payments);
        paymentsSteps.paymentsPageShouldBeOpened();
        paymentsSteps.selectPaymentCategory(PaymentCategory.UtilitiesPayments);
        paymentsCategorySteps.paymentCategoryShouldBeOpened(PaymentCategory.UtilitiesPayments);
        paymentsCategorySteps.regionShouldBeEqual(Region.Moscow);
        paymentsCategorySteps.selectPayment(Payment.ZHKU_MOSKVA);
        paymentSteps.extraPaymentPageShouldBeOpened(Payment.ZHKU_MOSKVA);
        paymentSteps.selectPayTab(Payment.ZHKU_MOSKVA);
        paymentSteps.payFormShouldBePresent(Payment.ZHKU_MOSKVA);
    }

    @Test
    public void short_account_number() {
        paymentSteps.openExtraPaymentPage(Payment.ZHKU_MOSKVA);
        paymentSteps.selectPayTab(Payment.ZHKU_MOSKVA);
        paymentSteps.payFormShouldBePresent(Payment.ZHKU_MOSKVA);
        paymentSteps.setField(PaymentField.payerCode, "123");
        paymentSteps.errorShouldBePresent(PaymentField.payerCode, Error.invalidField);
    }
}
