package com.epam.client.rest.jersey;

import com.epam.client.Client;
import com.epam.exception.CustomException;
import com.epam.model.Result;
import com.epam.reader.ReadValue;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JerseyClient implements Client {
    private String firstValue = ReadValue.getValue("firstValue");
    private String secondValue = ReadValue.getValue("secondValue");
    private String url;
    private static ObjectMapper objectMapper =
            new ObjectMapper();
    private static final Logger LOG =
            Logger.getLogger(JerseyClient.class);

    @Override
    public Double add() {
        url = ReadValue.getValue("addUrl") + firstValue + "&" + secondValue;
        return convertToDouble(JerseyCalculatorService
                .getRequest(url))
                .getResult();
    }

    @Override
    public Double subtract() {
        url = ReadValue.getValue("subtractUrl") + firstValue + "&" + secondValue;
        return convertToDouble(JerseyCalculatorService
                .getRequest(url))
                .getResult();
    }

    @Override
    public Double divide() {
        url = ReadValue.getValue("divideUrl") + firstValue + "&" + secondValue;
        return convertToDouble(JerseyCalculatorService
                .getRequest(url))
                .getResult();
    }

    @Override
    public Double multiply() {
        url = ReadValue.getValue("multiplyUrl") + firstValue + "&" + secondValue;
        return convertToDouble(JerseyCalculatorService
                .getRequest(url))
                .getResult();
    }

    @Override
    public Double percentage() {
        url = ReadValue.getValue("percentageUrl") + firstValue + "&" + secondValue;
        return convertToDouble(JerseyCalculatorService
                .getRequest(url))
                .getResult();
    }

    private Result convertToDouble(String json) {
        try {
            return objectMapper.readValue(json, Result.class);
        } catch (IOException e) {
            throw new CustomException(e);
        }
    }
}
