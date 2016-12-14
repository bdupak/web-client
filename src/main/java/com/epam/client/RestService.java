package com.epam.client;

import com.epam.chooser.ClientSelector;
import com.epam.chooser.ClientType;

public class RestService implements Service {
    @Override
    public Client createService(ClientType clientType) {
        return new ClientSelector().getClient(clientType);
    }
}
