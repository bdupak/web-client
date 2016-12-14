package com.epam.client.soap.soapui;

import com.epam.client.Client;
import com.epam.model.DataHolder;
import com.epam.reader.ReadValue;

import java.util.HashMap;
import java.util.Map;

public class SoapUiClient implements Client {
    private SoapUiController soap = new SoapUiController();
    private Map<String, String> map = new HashMap<>();
    private DataHolder data = DataHolder.getInstance();

    public SoapUiClient(){

    }

    @Override
    public Double add() {

        return getDouble(soap
                .getResponse(ReadValue.getValue("wsdl"),
                        ReadValue.getValue("addOperation"),
                        getMap()));
    }

    @Override
    public Double subtract() {
        return getDouble(soap
                .getResponse(ReadValue.getValue("wsdl"),
                        ReadValue.getValue("subtractOperation"),
                        getMap()));
    }

    @Override
    public Double divide() {
        return getDouble(soap
                .getResponse(ReadValue.getValue("wsdl"),
                        ReadValue.getValue("divideOperation"),
                        getMap()));
    }

    @Override
    public Double multiply() {
        return getDouble(soap
                .getResponse(ReadValue.getValue("wsdl"),
                        ReadValue.getValue("multiplyOperation"),
                        getMap()));
    }

    @Override
    public Double percentage() {

        return getDouble(soap
                .getResponse(ReadValue.getValue("wsdl"),
                        ReadValue.getValue("percentageOperation"),
                        getPercentageMap()));
    }

    private Map<String, String> getMap(){
        map.clear();
        map.put(ReadValue.getValue("firstProperty"),
                data.getFirstValue());
        map.put(ReadValue.getValue("secondProperty"),
                data.getSecondValue());
        return map;
    }

    private Map<String, String> getPercentageMap(){
        map.clear();
        map.put(ReadValue.getValue("property"),
                data.getFirstValue());
        map.put(ReadValue.getValue("percentProperty"),
                data.getPercentage());
        return map;
    }
}
