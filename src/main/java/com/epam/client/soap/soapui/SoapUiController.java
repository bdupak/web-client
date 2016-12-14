package com.epam.client.soap.soapui;

import com.epam.exception.CustomException;
import com.epam.reader.ReadValue;
import com.eviware.soapui.impl.WsdlInterfaceFactory;
import com.eviware.soapui.impl.wsdl.*;
import com.eviware.soapui.model.iface.Request;
import com.eviware.soapui.model.iface.Response;

import java.util.Map;

public class SoapUiController {

    public String getResponse(String wsdl, String operationName) throws Exception {
        WsdlProject project = new WsdlProject();
        WsdlInterface iface = WsdlInterfaceFactory.importWsdl(project, wsdl, true)[0];
        WsdlOperation operation = (WsdlOperation) iface.getOperationByName(operationName);
        WsdlRequest request = operation.addNewRequest(ReadValue.getValue("request"));
        WsdlSubmit<WsdlRequest> submit = request.submit(new WsdlSubmitContext(
                request), false);
        Response response = submit.getResponse();
        return response.getContentAsString();
    }

    public String getResponse(String wsdl, String operationName, Map<String, String> map) {
        WsdlProject project;
        WsdlInterface iface;
        try {
            project = new WsdlProject();
            iface = WsdlInterfaceFactory.importWsdl(project, wsdl, true)[0];
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Some trouble with wsdl ");
        }
        WsdlOperation operation = iface
                .getOperationByName(operationName);
        WsdlRequest request = operation
                .addNewRequest(ReadValue.getValue("request"));
        request.setRequestContent(setValue(operation
                .createRequest(true), map));
        WsdlSubmit<WsdlRequest> submit;
        try {
            submit = request
                    .submit(new WsdlSubmitContext(request), false);
        } catch (Request.SubmitException e) {
            e.printStackTrace();
            throw new CustomException("Some trouble with request ");
        }
        Response response = submit.getResponse();
        return getValue(response.getContentAsString());
    }

    private String setValue(String request, Map<String, String> map) {
        for (Map.Entry entry : map.entrySet()) {
            if (request.contains(entry.getKey().toString())) {
                request = request.replace(entry.getKey() + ">?",
                        entry.getKey() + ">" + entry.getValue());
            }
        }
        return request;
    }

    private String getValue(String response) {
        String[] values = response.split(" ");
        for (String value : values) {
            if (value.contains(ReadValue.getValue("tagSearch"))){
                return value.substring(ReadValue.getValue("tagSearch").length(),
                        value.length() - ReadValue.getValue("tagSearch").length() - 3);
            }
        }
        throw new CustomException("Some problem with search tag");
    }

    public String getResponse(String wsdl, String operationName, String firstValue, String secondValue) throws Exception {
        WsdlProject project = new WsdlProject();
        WsdlInterface iface = WsdlInterfaceFactory.importWsdl(project, wsdl, true)[0];
        WsdlOperation operation = (WsdlOperation) iface
                .getOperationByName(operationName);
        WsdlRequest request = operation.addNewRequest(ReadValue
                .getValue("request"));
        request.setRequestContent(operation.createRequest(true)
                .replace("?", firstValue));
        WsdlSubmit<WsdlRequest> submit = request
                .submit(new WsdlSubmitContext(request), false);
        Response response = submit.getResponse();
        return response.getContentAsString();
    }
}
