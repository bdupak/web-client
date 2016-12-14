package com.epam.client.rest;

import com.epam.client.Client;

public interface RestClient extends Client {
    Double add();

    Double subtract();

    Double divide();

    Double multiply();

    Double percentage();
}
