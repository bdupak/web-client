package com.epam.client.rest.jersey;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.log4j.Logger;

public class JerseyCalculatorService {
    private static final Logger LOG =
            Logger.getLogger(JerseyCalculatorService.class);

    public static String getRequest(String url) {
        Client client = Client.create();
        WebResource webResource = client.resource(url);
        ClientResponse response = webResource
                .accept("application/json")
                .get(ClientResponse.class);
        return response.getEntity(String.class);
    }

    public static String putRequest(String url) {
        Client client = Client.create();
        WebResource webResource = client.resource(url);
        ClientResponse response = webResource
                .accept("application/json")
                .put(ClientResponse.class);
        return response.getEntity(String.class);
    }

    public static String postRequest(String url, String inputData) {
        Client client = Client.create();
        WebResource webResource = client.resource(url);
        ClientResponse response = webResource
                .type("application/json")
                .post(ClientResponse.class, inputData);
        return response.getEntity(String.class);
    }
}
