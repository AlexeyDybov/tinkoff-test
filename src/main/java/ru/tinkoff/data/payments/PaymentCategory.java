package ru.tinkoff.data.payments;

public enum PaymentCategory {

    UtilitiesPayments("Коммунальные платежи", "kommunalnie-platezhi");

    private String name;
    private String locator;

    PaymentCategory(String name, String regionName) {
        this.name = name;
        this.locator = regionName;
    }

    public String getLinkName() {
        return locator;
    }

    public String getName() {
        return name;
    }
}
