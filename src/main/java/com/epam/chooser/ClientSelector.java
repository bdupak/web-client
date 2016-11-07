package com.epam.chooser;

import com.epam.client.Client;
import com.epam.client.cxf.CxfClient;
import com.epam.client.soap.SoapClient;
import com.epam.client.wsimport.WsImportClient;
import com.epam.exception.CustomException;

public class ClientSelector {

    public Client getClient(ClientType clientType){
        switch(clientType){
            case CXF:
                return new CxfClient();
            case SOAP:
                return new SoapClient();
            case WS_IMPORT:
                return new WsImportClient();
            default:
                throw new CustomException("Client type " + clientType + " is not supported yet");

        }
    }
}
