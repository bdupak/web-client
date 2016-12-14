package com.epam.client.soap.wsimport;

import com.epam.model.Response;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(name = "Calculator",
        targetNamespace = "http://model.service.epam.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({ObjectFactory.class})
public interface Calculator {

    @WebMethod
    @WebResult(partName = "return")
    Response add(
            @WebParam(name = "firstValue", partName = "firstValue")
                    String firstValue,
            @WebParam(name = "secondValue", partName = "secondValue")
                    String secondValue);

    @WebMethod
    @WebResult(partName = "return")
    Response divide(
            @WebParam(name = "firstValue", partName = "firstValue")
                    String firstValue,
            @WebParam(name = "secondValue", partName = "secondValue")
                    String secondValue);

    @WebMethod
    @WebResult(partName = "return")
    Response multiply(
            @WebParam(name = "firstValue", partName = "firstValue")
                    String firstValue,
            @WebParam(name = "secondValue", partName = "secondValue")
                    String secondValue);

    @WebMethod
    @WebResult(partName = "return")
    Response subtract(
            @WebParam(name = "firstValue", partName = "firstValue")
                    String firstValue,
            @WebParam(name = "secondValue", partName = "secondValue")
                    String secondValue);

    @WebMethod
    @WebResult(partName = "return")
    Response percentage(
            @WebParam(name = "value", partName = "value")
                    String value,
            @WebParam(name = "percent", partName = "percent")
                    String percent);
}
