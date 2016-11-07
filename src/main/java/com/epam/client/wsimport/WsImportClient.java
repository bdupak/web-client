package com.epam.client.wsimport;

import com.epam.client.Client;
import com.epam.model.Response;
import com.epam.reader.ReadValue;
import org.apache.log4j.Logger;

public class WsImportClient implements Client {

    private String firstValue;
    private String secondValue;
    private String percentage;
    private Calculator calculator;
    private Response response;
    private static final Logger LOG = Logger.getLogger(WsImportClient.class);

    public WsImportClient() {
        calculator = new CalculatorService()
                .getCalculatorServicePort();
        firstValue = ReadValue.getValue("firstValue");
        secondValue = ReadValue.getValue("secondValue");
        percentage = ReadValue.getValue("percentage");
    }

    public Double add(){
        response = calculator.add(firstValue, secondValue);
        return response.getResult().getValue();
    }

    public Double subtract(){
        response = calculator.subtract(firstValue, secondValue);
        return response.getResult().getValue();
    }

    @Override
    public Double divide() {
        response = calculator.divide(firstValue, secondValue);
        return response.getResult().getValue();
    }

    @Override
    public Double multiply() {
        response = calculator.multiply(firstValue, secondValue);
        return response.getResult().getValue();
    }

    @Override
    public Double percentage() {
        response = calculator.percentage(firstValue, percentage);
        return response.getResult().getValue();
    }
}
