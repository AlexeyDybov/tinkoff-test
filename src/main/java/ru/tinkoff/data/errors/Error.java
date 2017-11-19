package ru.tinkoff.data.errors;

public enum Error {

    invalidField("Поле неправильно заполнено");

    private String description;

    Error(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
