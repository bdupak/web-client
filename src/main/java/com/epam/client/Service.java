package com.epam.client;

import com.epam.chooser.ClientType;

public interface Service {
    Client createService(ClientType clientType);
}
