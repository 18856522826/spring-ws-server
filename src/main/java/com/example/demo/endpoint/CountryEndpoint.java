package com.example.demo.endpoint;

import mypackage.*;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.wsdl.Message;
import javax.xml.bind.JAXBElement;

/**
 * @author xuxu
 */
@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://www.dexcoder.com/ws";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        Country poland = new Country();
        poland.setName("Poland-" + request.getName());
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(38186860);
        response.setCountry(poland);
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "WebServiceMessage")
    @ResponsePayload
    public WebServiceMessage get(@RequestPayload WebServiceMessage message){
        System.out.println(message);
        return message;
    }
    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "Request")
    @ResponsePayload
    public GetCountryResponse get(@RequestPayload Request request){
        System.out.println(request);
        return  new GetCountryResponse();
    }
}
