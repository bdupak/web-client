package com.epam.chooser;

import com.epam.client.Client;
import com.epam.client.rest.jersey.JerseyClient;
import com.epam.client.soap.cxf.CxfClient;
import com.epam.client.soap.soapui.SoapUiClient;
import com.epam.client.soap.wsimport.WsImportClient;
import com.epam.exception.CustomException;

public class ClientSelector {

    public Client getClient(ClientType clientType) {
        switch (clientType) {
            case CXF:
                return new CxfClient();
            case SOAP_UI:
                return new SoapUiClient();
            case WS_IMPORT:
                return new WsImportClient();
            case JERSEY:
                return new JerseyClient();
            default:
                throw new CustomException("Client type " + clientType + " is not supported yet");

        }
    }
}
