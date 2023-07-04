package com.soap.client.springbootsoapclient;

import com.soap.client.springbootsoapclient.config.SoapClientConnector;
import com.soap.client.springbootsoapclient.entity.StudentDetailsRequest;
import com.soap.client.springbootsoapclient.entity.StudentDetailsResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootSoapClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSoapClientApplication.class, args);

    }

    @Bean
    CommandLineRunner lookup(SoapClientConnector soapConnector) {
        String name = "Gokhan";
        StudentDetailsRequest request = new StudentDetailsRequest();
        request.setName(name);
        StudentDetailsResponse response = (StudentDetailsResponse) soapConnector.callWebService("http://localhost:8080/service/student-details", request);
        System.out.println("Name : " + response.getStudent().getName());
        System.out.println("Standard : " + response.getStudent().getStandard());
        System.out.println("Address : " + response.getStudent().getAddress());
        return null;
    }

}
