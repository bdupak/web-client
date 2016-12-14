package com.epam.chooser;

import com.epam.client.Client;
import com.epam.client.RestService;
import com.epam.client.SoapService;
import com.epam.exception.CustomException;

public class ServiceSelector {

    public Client getService(ServiceType serviceType, ClientType clientType) {
        switch (serviceType) {
            case SOAP:
                return new SoapService().createService(clientType);
            case REST:
                return new RestService().createService(clientType);
            default:
                throw new CustomException("Client type " + clientType + " is not supported yet");
        }
    }
}
