package com.epam.client;

public interface Client {
    Double add();

    Double subtract();

    Double divide();

    Double multiply();

    Double percentage();

    default double getDouble(String value) {
        return Double.parseDouble(value);
    }
}
