package com.epam.client.wsimport;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "CalculatorService",
        targetNamespace = "http://controller.service.epam.com/",
        wsdlLocation = "http://localhost:8080/calc?wsdl")
public class CalculatorService extends Service {

    private final static URL CALCULATOR_SERVICE_WSDL_LOCATION;
    private final static WebServiceException CALCULATOR_SERVICE_EXCEPTION;
    private final static QName CALCULATOR_SERVICE_QNAME =
            new QName("http://controller.service.epam.com/",
                    "CalculatorServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/calc?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CALCULATOR_SERVICE_WSDL_LOCATION = url;
        CALCULATOR_SERVICE_EXCEPTION = e;
    }

    public CalculatorService() {
        super(getWsdlLocation(), CALCULATOR_SERVICE_QNAME);
    }

    public CalculatorService(WebServiceFeature... features) {
        super(getWsdlLocation(), CALCULATOR_SERVICE_QNAME, features);
    }

    public CalculatorService(URL wsdlLocation) {
        super(wsdlLocation, CALCULATOR_SERVICE_QNAME);
    }

    public CalculatorService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CALCULATOR_SERVICE_QNAME, features);
    }

    public CalculatorService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CalculatorService(URL wsdlLocation, QName serviceName,
                             WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }


    @WebEndpoint(name = "CalculatorServicePort")
    public Calculator getCalculatorServicePort() {
        return super.getPort(new QName("http://controller.service.epam.com/",
                "CalculatorServicePort"), Calculator.class);
    }


    @WebEndpoint(name = "CalculatorServicePort")
    public Calculator getCalculatorServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://controller.service.epam.com/",
                "CalculatorServicePort"), Calculator.class, features);
    }

    private static URL getWsdlLocation() {
        if (CALCULATOR_SERVICE_EXCEPTION != null) {
            throw CALCULATOR_SERVICE_EXCEPTION;
        }
        return CALCULATOR_SERVICE_WSDL_LOCATION;
    }
}
