package com.soap.client.springbootsoapclient.config;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SoapClientConnector extends WebServiceGatewaySupport {
    public Object callWebService(String url, Object request){
        return getWebServiceTemplate().marshalSendAndReceive(url, request);
    }
}
