package ru.tinkoff.data.payments.categories;

public enum Payment {

    ZHKU_MOSKVA("ЖКУ-Москва", "zhku-moskva");

    private String name;
    private String locator;

    Payment(String name, String locator) {
        this.name = name;
        this.locator = locator;
    }

    public String getName() {
        return name;
    }

    public String getLinkName() {
        return locator;
    }
}
