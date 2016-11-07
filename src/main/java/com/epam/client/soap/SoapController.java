package com.epam.client.soap;

import com.eviware.soapui.impl.WsdlInterfaceFactory;
import com.eviware.soapui.impl.wsdl.*;
import com.eviware.soapui.model.iface.Response;

import java.util.Map;

public class SoapController {

    public String getResponse(String wsdl, String operationName) throws Exception {
        WsdlProject project = new WsdlProject();
        WsdlInterface iface = WsdlInterfaceFactory.importWsdl(project, wsdl, true)[0];
        WsdlOperation operation = (WsdlOperation) iface.getOperationByName(operationName);
        WsdlRequest request = operation.addNewRequest("My request");
        System.out.println(operation.createRequest(true));
        request.setRequestContent(operation.createRequest(true)
                .replace("?", "10"));
        WsdlSubmit<WsdlRequest> submit = request.submit(new WsdlSubmitContext(
                request), false);
        Response response = submit.getResponse();
        return response.getContentAsString();
    }

    public String getResponse(String wsdl, String operationName, Map<String, String> map) throws Exception {
        WsdlProject project = new WsdlProject();
        WsdlInterface iface = WsdlInterfaceFactory.importWsdl(project, wsdl, true)[0];
        WsdlOperation operation = (WsdlOperation) iface.getOperationByName(operationName);
        WsdlRequest request = operation.addNewRequest("My request");
        System.out.println(setValue(operation.createRequest(true), map));
        request.setRequestContent(setValue(operation.createRequest(true), map));
        WsdlSubmit<WsdlRequest> submit = request
                .submit(new WsdlSubmitContext(request), false);
        Response response = submit.getResponse();
        return response.getContentAsString();
    }

    public String setValue(String request, Map<String, String> map){
        for (Map.Entry entry : map.entrySet()) {
            if(request.contains(entry.getKey().toString())){
                request = request.replace( entry.getKey() + ">?",
                        entry.getKey() + ">" + entry.getValue());
            }
        }
        return request;
    }

    public String getResponse(String wsdl, String operationName, String firstValue, String secondValue) throws Exception {
        WsdlProject project = new WsdlProject();
        WsdlInterface iface = WsdlInterfaceFactory.importWsdl(project, wsdl, true)[0];
        WsdlOperation operation = (WsdlOperation) iface.getOperationByName(operationName);
        WsdlRequest request = operation.addNewRequest("My request");
        request.setRequestContent(operation.createRequest(true)
                .replace("?", firstValue));
        WsdlSubmit<WsdlRequest> submit = request.submit(new WsdlSubmitContext(
                request), false);
        Response response = submit.getResponse();
        return response.getContentAsString();
    }
}
